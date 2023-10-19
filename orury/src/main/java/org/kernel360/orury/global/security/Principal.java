package org.kernel360.orury.global.security;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kernel360.orury.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public record Principal(
        String userId,
        String password,
        String email,
        Collection<? extends GrantedAuthority> authorities
) implements UserDetails {
    public static Principal of(String userId, String email, String password) {
        Set<RoleType> roleTypes = Set.of(RoleType.USER);
        return new Principal(userId, email, password, roleTypes.stream()
                .map(RoleType::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet()));
    }

    public static Principal from(User dto) {
        return Principal.of(String.valueOf(dto.getId()), dto.getEmail(), dto.getPassword());
    }

//    @Override
//    public String getName() {
//        return userId;
//    }
//
//    @Override
//    public Map<String, Object> getAttributes() {
//        return oAuth2Attributes;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("authorities : {}", authorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Getter
    public enum RoleType {
        USER("ROLE_USER");

        private final String name;

        RoleType(String name) {
            this.name = name;
        }
    }
}
