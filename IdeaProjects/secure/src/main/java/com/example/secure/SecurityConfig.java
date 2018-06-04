package com.example.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().permitAll()
                .and().authorizeRequests().antMatchers("/WEB-INF/**").permitAll().anyRequest().permitAll()
                .and().authorizeRequests().antMatchers("/webapp/pages/**")
                .permitAll().anyRequest().authenticated();
        // login
        http.formLogin().loginPage("/pages/login.xhtml").permitAll().
                defaultSuccessUrl("/pages/index.xhtml").permitAll().
                failureUrl("/pages/login.xhtml?error=true");
        // logout
        http.logout().logoutSuccessUrl("/pages/login.xhtml");
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder()).
                usersByUsernameQuery("select user,password, enabled from user where user=?").
                authoritiesByUsernameQuery("select user, role from user where user=? ");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}