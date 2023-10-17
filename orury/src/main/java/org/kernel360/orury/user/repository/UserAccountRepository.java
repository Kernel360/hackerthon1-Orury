package org.kernel360.orury.user.repository;

import org.kernel360.orury.user.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
    Optional<UserAccount> findByUserId(String userId);

    void deleteByUserId(String userId);
}
