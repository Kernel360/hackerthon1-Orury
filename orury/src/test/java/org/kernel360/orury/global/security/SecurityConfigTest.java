package org.kernel360.orury.global.security;

import org.assertj.core.internal.bytebuddy.dynamic.DynamicType;
import org.kernel360.orury.user.domain.User;
import org.kernel360.orury.user.dto.UserDto;
import org.kernel360.orury.user.service.UserService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
class SecurityConfigTest {
    @MockBean
    private UserService userService;

    @BeforeTestMethod // spring 기능과 관련이 있는 경우에만 사용
    public void securitySetup() {
        UserDto userDto = createUserDto();
        given(userService.searchUser(anyLong()))
                .willReturn(Optional.of(userDto.toEntity()));
        given(userService.saveUser(anyLong(), anyString(), anyString(), anyString()))
                .willReturn(createUserDto().toEntity());
    }

    private UserDto createUserDto() {
        return UserDto.builder()
                .id(1L)
                .password("123")
                .nickname("aaaa")
                .email("mail")
                .build();
    }
}