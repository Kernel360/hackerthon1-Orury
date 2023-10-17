package org.kernel360.orury.global.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService
    ) throws Exception {
        return http.authorizeRequests(auth -> auth
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .mvcMatchers("/api/**").permitAll()
                        .mvcMatchers(
                                HttpMethod.GET,
                                "/"
                        ).permitAll()
                        .anyRequest().authenticated())
                .formLogin(withDefaults())
                .logout(it -> it.logoutSuccessUrl("/"))
                .oauth2Login(auth -> auth.userInfoEndpoint(userInfo -> userInfo.userService(oAuth2UserService)))
                .csrf(csrf -> csrf.ignoringAntMatchers("/api/**"))
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
