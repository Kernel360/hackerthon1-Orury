package org.kernel360.orury.user.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kernel360.orury.user.domain.User;
import org.kernel360.orury.user.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService service;
    @Mock
    private UserRepository userRepository;

    @DisplayName("회원 정보 저장")
    @Test
    void test1() {
        //given
        Long id = 1L;
        given(userRepository.findById(id)).willReturn(Optional.of(createSigningUpUserAccount(id)));
        //when
        Optional<User> actual = service.searchUser(id);
        //then
        assertThat(actual).isPresent();
        then(userRepository).should().findById(id);
    }

    private User createSigningUpUserAccount(Long id) {
        return createUser(id);
    }

    private User createUser(Long id) {
        return User.builder()
                .id(id)
                .password("123")
                .nickname("aaadad")
                .email("mail")
                .build();
    }
}