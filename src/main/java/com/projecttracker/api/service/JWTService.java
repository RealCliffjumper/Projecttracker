package com.projecttracker.api.service;

import com.projecttracker.api.model.JWTRequest;
import com.projecttracker.api.model.JWTResponse;
import com.projecttracker.api.model.User;
import com.projecttracker.api.repository.UserRepository;
import com.projecttracker.api.utility.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JWTService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;


    public JWTResponse createJwtToken(JWTRequest jwtRequest) throws Exception {
        String userLoginId = jwtRequest.getUserLoginId();
        String password = jwtRequest.getPassword();
        authenticate(userLoginId, password);

        final UserDetails userDetails = loadUserByUsername(userLoginId);

        String newGeneratedJwtToken = jwtTokenProvider.generateToken(userDetails);

        User user = userRepository.findByUserLoginId(userLoginId);

        return new JWTResponse(user, newGeneratedJwtToken);
    }

    @Override
    public UserDetails loadUserByUsername(String userLoginId) throws UsernameNotFoundException {
        User user = userRepository.findByUserLoginId(userLoginId);

        if(user != null){
            return new org.springframework.security.core.userdetails.User(
                    user.getUserLoginId(),
                    user.getPassword(),
                    getAuthorities(user)
            );
        } else {
            throw new UsernameNotFoundException("Username is not valid");
        }
    }

    private Set getAuthorities(User user){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        });

        return authorities;
    }

    private void authenticate(String userLoginId, String password) throws Exception{
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginId, password));
        }
        catch(DisabledException e )
        {
            throw new Exception("User is disabled");
        }
        catch(BadCredentialsException e)
        {
            throw new Exception("Bad credentials");
        }
    }
}
