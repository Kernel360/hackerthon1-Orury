package org.kernel360.orury.user.dto;

import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.comment.domain.CommentLike;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.board.post.domain.PostLike;
import org.kernel360.orury.user.domain.UserAccount;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

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
        Set<Post> posts,
        Set<Comment> comments,
        Set<PostLike> postLikes,
        Set<CommentLike> commentLikes,
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
            Set<Post> posts,
            Set<Comment> comments,
            Set<PostLike> postLikes,
            Set<CommentLike> commentLikes,
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
                posts,
                comments,
                postLikes,
                commentLikes,
                createdAt,
                createdBy,
                updatedBy,
                updatedAt
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
                entity.getPosts(),
                entity.getComments(),
                entity.getPostLikes(),
                entity.getCommentLikes(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedBy(),
                entity.getUpdatedAt()
        );
    }

    public static UserAccount toEntity(UserAccountDto dto) {
        return UserAccount.of(
                dto.userId(),
                dto.nickname(),
                dto.sex(),
                dto.birth(),
                dto.email(),
                dto.password(),
                dto.posts(),
                dto.comments(),
                dto.postLikes(),
                dto.commentLikes()
        );
    }
}