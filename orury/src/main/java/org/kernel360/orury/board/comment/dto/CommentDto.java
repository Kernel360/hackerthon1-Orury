package org.kernel360.orury.board.comment.dto;

import org.kernel360.orury.board.comment.domain.Comment;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.kernel360.orury.board.comment.domain.Comment}
 */
public record CommentDto(
        Integer id,
        String content,
        int likeCnt,
        Integer parentId,
        Integer childId,
        boolean isDeleted,
        LocalDateTime createdAt,
        String createdBy,
        String updatedBy,
        LocalDateTime updatedAt
) {
}