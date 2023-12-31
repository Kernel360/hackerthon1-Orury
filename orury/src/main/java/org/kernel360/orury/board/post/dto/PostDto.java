package org.kernel360.orury.board.post.dto;

import lombok.Builder;
import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.global.util.isDeletedType;
import org.kernel360.orury.user.dto.UserDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * DTO for {@link org.kernel360.orury.board.post.domain.Post}
 */
@Builder
public record PostDto(
        Long id,
        String title,
        String content,
        int viewCnt,
        int likeCnt,
        isDeletedType isDeleted,
        UserDto user,
        List<Comment> comments,
        LocalDateTime createdAt,
        String createdBy,
        String updatedBy,
        LocalDateTime updatedAt
) {

    public static PostDto of(
            String title,
            String content,
            UserDto user,
            int viewCnt,
            int likeCnt,
            boolean isDeleted
    ) {
        return PostDto.of(
                title,
                content,
                user,
                viewCnt,
                likeCnt,
                isDeleted
        );
    }

    public static PostDto of(
            Long id,
            String title,
            String content,
            int viewCnt,
            int likeCnt,
            isDeletedType isDeleted,
            UserDto user,
            List<Comment> comments,
            LocalDateTime createdAt,
            String createdBy,
            String updatedBy,
            LocalDateTime updatedAt
    ) {
        return PostDto.builder()
                .id(id)
                .title(title)
                .content(content)
                .viewCnt(viewCnt)
                .likeCnt(likeCnt)
                .isDeleted(isDeleted)
                .user(user)
                .comments(comments)
                .createdAt(createdAt)
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .updatedAt(updatedAt)
                .build();
    }

    public static PostDto from(Post entity) {
        return PostDto.builder()
                .id(entity.getId())
                .title(entity.getPostTitle())
                .content(entity.getPostContent())
                .viewCnt(entity.getViewCnt())
                .likeCnt(entity.getLikeCnt())
                .isDeleted(entity.getIsDeleted())
                .user(UserDto.from(entity.getUser()))
                .comments(new ArrayList<>(entity.getComments()))
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .updatedBy(entity.getUpdatedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static Post toEntity(PostDto dto) {
        return Post.builder()
                .id(dto.id)
                .postTitle(dto.title)
                .postContent(dto.content)
                .viewCnt(dto.viewCnt)
                .likeCnt(dto.likeCnt)
                .isDeleted(dto.isDeleted)
                .user(dto.user.toEntity())
                .comments(new HashSet<>(dto.comments))
                .build();
    }
}