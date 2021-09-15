package com.example.pizzeria.security;

import com.example.pizzeria.service.DrinkService;
import com.example.pizzeria.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserAppService userAppService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AppSecurityConfig(UserAppService userAppService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userAppService = userAppService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().
                disable().
                authorizeRequests().
                antMatchers("/registration/**").
                permitAll().
                anyRequest().
                authenticated().
                and().
                formLogin();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userAppService);
        return provider;
    }

   /* @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails miloszGUser = User.builder().
                username("milosz").
                password(passwordEncoder.encode("password")).
                roles("ADMIN").
                build();

        return new InMemoryUserDetailsManager(miloszGUser);
    }*/
}
