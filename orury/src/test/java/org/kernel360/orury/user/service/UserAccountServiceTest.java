package org.kernel360.orury.user.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kernel360.orury.user.domain.UserAccount;
import org.kernel360.orury.user.dto.UserAccountDto;
import org.kernel360.orury.user.repository.UserAccountRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.env.MockEnvironment;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceTest {
    @InjectMocks
    private UserAccountService service;
    @Mock
    private UserAccountRepository repository;

    @DisplayName("회원 정보 저장")
    @Test
    void test1() {
        //given
        String id = "nick";
        given(repository.findByUserId(id)).willReturn(Optional.of(createSigningUpUserAccount(id)));
        //when
        Optional<UserAccountDto> actual = service.searchUser(id);
        //then
        assertThat(actual).isPresent();
        then(repository).should().findByUserId(id);
    }

    private UserAccount createSigningUpUserAccount(String username) {
        return createUserAccount(username, username);
    }

    private UserAccount createUserAccount(String username, String createdBy) {
        return UserAccount.of(
                username,
                "123",
                "aaaa",
                "mail"
        );
    }

}