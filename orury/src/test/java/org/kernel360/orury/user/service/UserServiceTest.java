package org.kernel360.orury.user.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kernel360.orury.user.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService service;
    @Mock
    private UserRepository repository;

    @DisplayName("회원 정보 저장")
    @Test
    void test1() {
//        //given
//        String id = "nick";
//        given(repository.findByUserId(id)).willReturn(Optional.of(createSigningUpUser(id)));
//        //when
//        Optional<UserDto> actual = service.searchUser(id);
//        //then
//        assertThat(actual).isPresent();
//        then(repository).should().findByUserId(id);
//    }
//
//    private User createSigningUpUser(String username) {
//        return createUser(username, username);
//    }
//
//    private User createUser(String username, String createdBy) {
//        return User.of(
//                username,
//                "123",
//                "aaaa",
//                "mail"
//        );
    }

}