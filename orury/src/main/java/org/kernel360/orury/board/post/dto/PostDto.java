package org.kernel360.orury.board.post.dto;

import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.user.dto.UserAccountDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * DTO for {@link org.kernel360.orury.board.post.domain.Post}
 */
public record PostDto(
        Integer id,
        String title,
        String content,
        int viewCnt,
        int likeCnt,
        boolean isDeleted,
        UserAccountDto userAccount,
        List<Comment> comments,
        LocalDateTime createdAt,
        String createdBy,
        String updatedBy,
        LocalDateTime updatedAt
) {

    public static PostDto of(
            String title,
            String content,
            UserAccountDto userAccount,
            int viewCnt,
            int likeCnt,
            boolean isDeleted
    ) {
        return PostDto.of(
                title,
                content,
                userAccount,
                viewCnt,
                likeCnt,
                isDeleted
        );
    }

    public static PostDto of(
            Integer id,
            String title,
            String content,
            int viewCnt,
            int likeCnt,
            boolean isDeleted,
            UserAccountDto userAccount,
            List<Comment> comments,
            LocalDateTime createdAt,
            String createdBy,
            String updatedBy,
            LocalDateTime updatedAt
    ) {
        return new PostDto(
                id,
                title,
                content,
                viewCnt,
                likeCnt,
                isDeleted,
                userAccount,
                comments,
                createdAt,
                createdBy,
                updatedBy,
                updatedAt
        );
    }

    public static PostDto from(Post entity) {
        return PostDto.of(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getViewCnt(),
                entity.getLikeCnt(),
                entity.isDeleted(),
                UserAccountDto.from(entity.getUserAccount()),
                new ArrayList<>(entity.getComments()),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedBy(),
                entity.getUpdatedAt()
        );
    }

    public static Post toEntity(PostDto dto) {
        return Post.of(
                dto.id(),
                UserAccountDto.toEntity(dto.userAccount()),
                dto.title(),
                dto.content(),
                dto.viewCnt(),
                dto.likeCnt(),
                new HashSet<>(dto.comments),
                dto.isDeleted()
        );
    }
}