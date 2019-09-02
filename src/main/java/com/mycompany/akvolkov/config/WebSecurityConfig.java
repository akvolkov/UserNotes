package com.mycompany.akvolkov.config;

import com.mycompany.akvolkov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/registration").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<com.mycompany.akvolkov.entity.User> users = userService.getAllUsers();
        ArrayList<UserDetails> details = new ArrayList<>();
        for (com.mycompany.akvolkov.entity.User user: users
             ) {
            UserDetails userDetails =
                    User.withDefaultPasswordEncoder()
                            .username(user.getLogin())
                            .password(user.getPassword())
                            .roles("USER")
                            .build();
            details.add(userDetails);
        }
        return new InMemoryUserDetailsManager(details.toArray(new UserDetails[0]));
    }

}