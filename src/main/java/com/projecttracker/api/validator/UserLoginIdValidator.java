package com.projecttracker.api.validator;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class UserLoginIdValidator implements Predicate<String> {
    @Override
    public boolean test(String s){
        //ADD REGEX
    return true;
}
}
