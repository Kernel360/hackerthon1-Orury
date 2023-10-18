package org.kernel360.orury.board.post.controller;

import lombok.RequiredArgsConstructor;
import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.board.post.service.PostService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.kernel360.orury.board.post.PostViewRequest;
import org.kernel360.orury.board.post.db.PostEntity;
import org.kernel360.orury.board.post.model.PostRequest;
import org.kernel360.orury.board.post.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public PostEntity create(
            @Valid
            @RequestBody
            PostRequest postRequest
    ) {
        return postService.create(postRequest);
    }

    @PostMapping("/view")
    public PostEntity view(
            @Valid
            @RequestBody PostViewRequest postViewRequest
    ) {
        return postService.view(postViewRequest);
    }

    @GetMapping("/all")
    public List<PostEntity> list(

    ) {
        return postService.all();
    }

    @PostMapping("/delete")
    public void delete(
            @Valid
            @RequestBody PostViewRequest postViewRequest
    ) {
        postService.delete(postViewRequest);
    }

    /*
    // 작업내용 주석처리
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/{postId}")
    public String showPostDetail(@PathVariable Integer postId, Model model) {
        // postId를 이용하여 게시글 상세 정보 조회
        Post post = postService.getPostById(postId);

        // 현재 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        // 현재 사용자와 게시글 작성자 비교
        boolean currentUserIsAuthor = currentUsername.equals(post.getUserAccount().getCreatedBy());

        // 댓글 목록 조회
        List<Comment> comments = postService.getCommentsByPostId(postId);

        // Thymeleaf 템플릿에 데이터 전달
        model.addAttribute("post", post);
        model.addAttribute("currentUserIsAuthor", currentUserIsAuthor);
        model.addAttribute("comments", comments);

        return "PostDetail";


     */
}
