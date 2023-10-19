package org.kernel360.orury.board.comment.controller;

import lombok.RequiredArgsConstructor;
import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.comment.dto.CommentDto;
import org.kernel360.orury.board.comment.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    public void createComment(@RequestBody CommentDto commentDto) {
        commentService.saveComment(commentDto.toEntity());
    }

    public void createComment(Integer postId, Integer userId, CommentDto commentDto) {
        commentService.saveComment(commentDto.toEntity());
    }

    public void deleteComment(Integer commentId) {
        commentService.deleteComment(commentId);
    }

    public void updateComment(Integer commentId, String content) {
        Comment comment = commentService.searchCommentById(commentId);

        comment.setCommentContent(content);
        commentService.saveComment(comment);
    }
}
