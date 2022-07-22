package com.example.mobilaloqaapp.Settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Sozlamalar extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth
               .inMemoryAuthentication()
               .withUser("1").password(passwordEncoder().encode("1")).roles("DIREKTOR")
               .and()
               .withUser("2").password(passwordEncoder().encode("2")).roles("MANAGER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf() .disable()
                .authorizeRequests()
                .antMatchers("/DirektorController/**","/MijozController/**","/ManagerFColtroller/createXodim","/simkartaController/**","/FilialRaxbarController/**").permitAll()
                .anyRequest()
                .authenticated();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder(5);
    }
}
