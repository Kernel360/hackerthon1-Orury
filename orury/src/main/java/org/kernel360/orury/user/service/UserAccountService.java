package org.kernel360.orury.user.service;

import lombok.RequiredArgsConstructor;
import org.kernel360.orury.user.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserAccountService {
    private final UserAccountRepository repository;
}
