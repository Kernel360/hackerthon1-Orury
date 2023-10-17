package org.kernel360.orury.user.dto;

import org.kernel360.orury.user.domain.UserAccount;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.kernel360.orury.user.domain.UserAccount}
 */
public record UserAccountDto(
        String userId,
        String nickname,
        String sex,
        String birth,
        String email,
        String password,
        LocalDateTime createdAt,
        String createdBy,
        String updatedBy,
        LocalDateTime updatedAt
) {
    public static UserAccountDto of(
            String userId,
            String nickname,
            String sex,
            String birth,
            String email,
            String password,
            LocalDateTime createdAt,
            String createdBy,
            String updatedBy,
            LocalDateTime updatedAt
    ) {
        return new UserAccountDto(
                userId,
                nickname,
                sex,
                birth,
                email,
                password,
                createdAt,
                createdBy,
                updatedBy,
                updatedAt
        );
    }

    public static UserAccountDto of(
            String userId,
            String nickname,
            String sex,
            String birth,
            String email,
            String password
    ) {
        return UserAccountDto.of(
                userId,
                nickname,
                sex,
                birth,
                email,
                password,
                null,
                null,
                null,
                null
        );
    }

    public static UserAccountDto from(UserAccount entity) {
        return new UserAccountDto(
                entity.getUserId(),
                entity.getNickname(),
                entity.getSex(),
                entity.getBirth(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedBy(),
                entity.getUpdatedAt()
        );
    }
}