package com.example.mapeo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecureConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/webapp/secure/**").access("denyALL('user')").
                and().authorizeRequests().
                antMatchers("/webapp/**").access("hasRole('admin')").
                and().
                formLogin().
                loginPage("/login.faces").
                loginProcessingUrl("/appLogin").
                usernameParameter("username").
                passwordParameter("password").
                defaultSuccessUrl("/index.faces").failureForwardUrl("/login.xhtml?error=1").
                and().logout().    //logout configuration
                logoutUrl("/appLogout").
                logoutSuccessUrl("/access.faces");
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder()).
                usersByUsernameQuery("select user,password, enabled  from user where user=?").
                authoritiesByUsernameQuery("select user, role from user where user =? ");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}
