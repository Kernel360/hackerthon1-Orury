package org.kernel360.orury.user.repository;

import org.kernel360.orury.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    void deleteById(Long userId);
}
