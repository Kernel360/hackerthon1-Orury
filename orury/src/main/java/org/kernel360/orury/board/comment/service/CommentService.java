package org.kernel360.orury.board.comment.service;

import lombok.RequiredArgsConstructor;
import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }

    public void deleteComment(Integer commentId) {
        commentRepository.deleteById(commentId);
    }

    public List<Comment> getComments(Integer postId){
        return commentRepository.findCommentsByPostId(postId);
    }

    public Comment searchCommentById(Integer commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다!"));
        return comment;
    }
}
