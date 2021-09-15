package com.example.pizzeria.service;

import com.example.pizzeria.security.AppUserRole;
import com.example.pizzeria.security.EmailValidator;
import com.example.pizzeria.security.userApp.RegistrationRequest;
import com.example.pizzeria.security.userApp.UserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final UserAppService userAppService;

    public RegistrationService(EmailValidator emailValidator, UserAppService userAppService) {
        this.emailValidator = emailValidator;
        this.userAppService = userAppService;
    }

    public String register(RegistrationRequest request){
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return userAppService.signUpUser(
                new UserApp(
                request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
