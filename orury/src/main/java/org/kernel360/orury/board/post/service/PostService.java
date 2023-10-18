package org.kernel360.orury.board.post.service;

import lombok.RequiredArgsConstructor;
import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.comment.repository.CommentRepository;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.board.post.dto.PostDto;
import org.kernel360.orury.board.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public PostDto getPost(Integer postId) {
        // postId를 이용하여 게시글 조회
        return PostDto.from(
                postRepository.findById(postId)
                        .orElseThrow(() -> new UsernameNotFoundException("조회된 게시글이 없습니다.")));
    }

    @Transactional(readOnly = true)
    public List<PostDto> getPostAll() {
        // 게시판 조회
        return postRepository.findAll().stream().map(PostDto::from).collect(Collectors.toList());
    }

    public void savePost(PostDto dto) {
        postRepository.save(PostDto.toEntity(dto));
    }

    public Post getPostById(Integer postId) {
        return postRepository.getPostById(postId);
    }

    public List<Comment> getCommentsByPostId(Integer postId) {
        return commentRepository.findCommentsByPostId(postId);
    }
}