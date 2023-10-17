package org.kernel360.orury.global.security;

import org.kernel360.orury.user.domain.UserAccount;
import org.kernel360.orury.user.dto.UserAccountDto;
import org.kernel360.orury.user.service.UserAccountService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
class SecurityConfigTest {
    @MockBean
    private UserAccountService userAccountService;

    @BeforeTestMethod // spring 기능과 관련이 있는 경우에만 사용
    public void securitySetup() {
        given(userAccountService.searchUser(anyString()))
                .willReturn(Optional.of(createUserAccountDto()));
        given(userAccountService.saveUser(anyString(), anyString(), anyString(), anyString(), anyString()))
                .willReturn(createUserAccountDto());
    }

    private UserAccountDto createUserAccountDto() {
        return UserAccountDto.from(UserAccount.of(
                "name",
                "123",
                "aaaa",
                "mail"
        ));
    }
}