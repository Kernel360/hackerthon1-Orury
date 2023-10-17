package org.kernel360.orury.board.post.controller;

import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.board.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/{postId}")
    public String showPostDetail(@PathVariable Long postId, Model model) {
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
    }
}
