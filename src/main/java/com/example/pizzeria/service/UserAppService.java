package com.example.pizzeria.service;

import com.example.pizzeria.security.token.ConfirmationToken;
import com.example.pizzeria.security.token.ConfirmationTokenService;
import com.example.pizzeria.security.userApp.UserApp;
import com.example.pizzeria.security.userApp.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserAppService implements UserDetailsService {

    private static final String USER_NOT_FOUND = "User with email %s not found!";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Autowired
    public UserAppService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
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
        if (userExist){
            throw new IllegalStateException("email already taken");
        }

        String encodecPassword = bCryptPasswordEncoder
                .encode(userApp.getPassword());

        userApp.setPassword(encodecPassword);
        userRepository.save(userApp);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                userApp
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }
}