package com.projecttracker.api.service;

import com.projecttracker.api.dto.UserReq;
import com.projecttracker.api.model.User;
import com.projecttracker.api.principal.UserPrincipal;
import com.projecttracker.api.repository.UserRepository;
import com.projecttracker.api.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRoleService userRoleService;

    private final UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userLoginId) throws UsernameNotFoundException{
            User user = this.userRepository.findByUserLoginId(userLoginId);

//            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//            user.getRoles().forEach(role -> {
//                authorities.(new SimpleGrantedAuthority(.getRoleName()));
//            });

            return new UserPrincipal(user/*, authorities*/){
            };
    }

    public User loginUser(UserReq userReq) throws Exception {
        String userLoginId1 = userReq.getUserLoginId();
        String userPassword = userReq.getPassword();

    if(userLoginId1 != null && userPassword != null){
            return userRepository.findByUserLoginId(userLoginId1);
        }
    else throw new Exception("Bad Credentials");
    }

    @Transactional
    public User signUpUser(UserReq userReq){
        String encodedPassword = bCryptPasswordEncoder.
                encode((userReq.getPassword()));
        User user = new User(
                userReq.getUserFirstName(),
                userReq.getUserLastName(),
                userReq.getUserLoginId(),
                encodedPassword
        );

        user = userRepository.save(user);
        userRoleService.createUserRole(user, "USER");

        return user;
    }

    @Transactional
    public void deleteUser(String userLoginId){
        userRepository.deleteUserByUserLoginId(userLoginId);
    }
}