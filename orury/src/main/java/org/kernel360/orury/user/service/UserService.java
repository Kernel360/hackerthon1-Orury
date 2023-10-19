package org.kernel360.orury.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kernel360.orury.user.domain.User;
import org.kernel360.orury.user.dto.UserDto;
import org.kernel360.orury.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    // 유저 id로 찾기
    @Transactional(readOnly = true)
    public Optional<User> searchUser(Long id) {
        return userRepository.findById(id);
    }

    //유저 저장, 정보 변경
    public User saveUser(Long userId, String password, String nickname, String email) {
        UserDto userDto = UserDto.builder()
                .id(userId)
                .password(password)
                .nickname(nickname)
                .email(email)
                .build();
        return userRepository.save(userDto.toEntity());
    }

    public User saveUser(UserDto userDto) {
        return userRepository.save(userDto.toEntity());
    }

    //유저 삭제
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
