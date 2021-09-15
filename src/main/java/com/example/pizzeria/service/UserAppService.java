package com.example.pizzeria.service;

import com.example.pizzeria.security.userApp.UserApp;
import com.example.pizzeria.security.userApp.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAppService implements UserDetailsService {

    private static final String USER_NOT_FOUND = "User with email %s not found!";
    private final UserRepository userRepository;

    @Autowired
    public UserAppService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email).
                orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND, email)));
    }

    public String signUpUser(UserApp userApp){
        Boolean userExist = userRepository.findByEmail(userApp.getEmail()).isPresent();
        return "";
    }
}