package com.example.spring_security.configuration.security;


/* Spring Security v4.x.x to v5.6.0 */
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import static org.springframework.security.config.Customizer.withDefaults;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//                 .csrf(csrf -> csrf.disable())
//                 .authorizeRequests(requests -> requests
//                         .antMatchers("/", "/public/**").permitAll()
//                         .anyRequest().authenticated())
//                 .formLogin(withDefaults());
            
//     }
// }

public class SecurityConfig {}

