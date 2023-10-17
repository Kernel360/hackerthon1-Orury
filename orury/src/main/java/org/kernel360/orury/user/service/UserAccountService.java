package org.kernel360.orury.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kernel360.orury.user.domain.UserAccount;
import org.kernel360.orury.user.dto.UserAccountDto;
import org.kernel360.orury.user.repository.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class UserAccountService {
    private final UserAccountRepository repository;

    // 유저 id로 찾기
    @Transactional(readOnly = true)
    public Optional<UserAccountDto> searchUser(String id) {
        return repository.findByUserId(id).map(UserAccountDto::from);
    }

    //유저 저장, 정보 변경
    public UserAccountDto saveUser(String userId, String password, String nickname, String email, String s) {
        return UserAccountDto.from(repository.save(UserAccount.of(userId, password, nickname, email)));
    }

    //유저 삭제
    public void deleteUser(String userId) {
        repository.deleteById(userId);
    }
}
