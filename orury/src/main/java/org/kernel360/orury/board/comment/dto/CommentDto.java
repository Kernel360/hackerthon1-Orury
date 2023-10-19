package org.kernel360.orury.board.comment.dto;

import lombok.Getter;
import lombok.Setter;
import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.global.util.isDeletedType;
import org.kernel360.orury.user.domain.User;

import java.time.LocalDateTime;

/**
 * DTO for {@link org.kernel360.orury.board.comment.domain.Comment}
 */
@Getter
@Setter
public class CommentDto{
    private Long id;

    private String content;

    private Post post;

    private User user;

    private int likeCnt;

    private Long parentId;

    private isDeletedType isDeleted;

    private LocalDateTime createdAt;

    private String createdBy;

    private String updatedBy;

    private LocalDateTime updatedAt;

    public Comment toEntity() {
            return Comment.builder()
                    .id(id)
                    .commentContent(content)
                    .likeCnt(likeCnt)
                    .parentId(parentId)
                    .isDeleted(isDeleted)
                    .build();
    }
}