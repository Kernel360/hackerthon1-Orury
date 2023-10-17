package org.kernel360.orury.board.post.service;

import lombok.RequiredArgsConstructor;
import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.comment.repository.CommentRepository;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.board.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class PostService {
    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final CommentRepository commentRepository;

    public Post getPostById(Long postId) {
        // postId를 이용하여 게시글 조회
        return postRepository.findById(Math.toIntExact(postId)).orElse(null);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        // postId를 이용하여 댓글리스트 조회
        return commentRepository.findByPostId(postId);
    }
}