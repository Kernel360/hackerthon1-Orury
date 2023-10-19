package org.kernel360.orury.global.security;

import lombok.extern.slf4j.Slf4j;
import org.kernel360.orury.user.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public SecurityFilterChain securityFilterChain(
//            HttpSecurity http
//    ) throws Exception {
//        return http.authorizeRequests(auth -> auth
//                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                        .mvcMatchers(
//                                HttpMethod.GET,
//                                "/"
//                        ).permitAll()
//                        .anyRequest().authenticated())
//                .formLogin(withDefaults())
//                .logout(it -> it.logoutSuccessUrl("/"))
//                .csrf().disable()
//                .build();
//    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return id -> userService
                .searchUser(Long.parseLong(id))
                .map(Principal::from)
                .orElseThrow(() -> new UsernameNotFoundException("유저 정보가 없습니다."));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    }

}
