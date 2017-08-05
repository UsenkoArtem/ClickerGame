package com.clicker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationEntryPoint authEntryPoint;

    @Autowired
    public SpringSecurityConfig(AuthenticationEntryPoint authEntryPoint) {
        this.authEntryPoint = authEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic().authenticationEntryPoint(authEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/user").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/user/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/user/isRegUser").permitAll()
                .antMatchers(HttpMethod.GET, "/user/isRegUser").permitAll()
                .antMatchers(HttpMethod.DELETE, "/user/**").permitAll()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .anyRequest().authenticated();


    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().
                withUser("roma").password("1111111").roles("USER");
    }

}