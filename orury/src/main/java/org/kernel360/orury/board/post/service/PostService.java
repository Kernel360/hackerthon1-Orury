package org.kernel360.orury.board.post.service;

import lombok.RequiredArgsConstructor;
import org.kernel360.orury.board.comment.repository.CommentRepository;
import org.kernel360.orury.board.post.PostViewRequest;
import org.kernel360.orury.board.post.db.PostEntity;
import org.kernel360.orury.board.post.model.PostRequest;
import org.kernel360.orury.board.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

//    @Transactional(readOnly = true)
//    public PostDto getPost(Integer postId) {
//        // postId를 이용하여 게시글 조회
//        return PostDto.from(
//                postRepository.findById(postId)
//                        .orElseThrow(() -> new UsernameNotFoundException("조회된 게시글이 없습니다.")));
//    }
//
//    @Transactional(readOnly = true)
//    public List<PostDto> getPostAll() {
//        // 게시판 조회
//        return postRepository.findAll().stream().map(PostDto::from).collect(Collectors.toList());
//    }
//
//    public void savePost(PostDto dto) {
//        postRepository.save(PostDto.toEntity(dto));
//    }

    public PostEntity create(
            PostRequest postRequest
    ) {
        var entity = PostEntity.builder()
                .id(1L) // 임시 고정
                .postTitle(postRequest.getPostTitle())
                .isDelete("0")
                .userNickname(postRequest.getUserNickname())
                .postContent(postRequest.getPostContent())
                .createdBy("1234")
                .createdAt(LocalDateTime.now())
                .updatedBy("1234")
                .updatedAt(LocalDateTime.now())
                .build();
        return postRepository.save(entity);

    }

    /**
     * 게시글이 존재할때만 view
     * @param postViewRequest
     * @return
     */
    public PostEntity view(PostViewRequest postViewRequest) {
        return postRepository.findFirstByIdAndIsDeleteOrderByIdDesc(postViewRequest.getId(), "0")
                .map(it -> {
                    // entity 존재할때만
                    return it;
                }).orElseThrow(
                        () -> {
                            return new RuntimeException("해당 게시글이 존재하지 않습니다 : " + postViewRequest.getId());
                        }
                );
    }

    public List<PostEntity> all() {
        return postRepository.findAll();
    }

    public void delete(PostViewRequest postViewRequest) {
        postRepository.findById(postViewRequest.getId())
                .map(it -> {
                    // 만약 비밀번호가 맞다면 삭제해준다.
                    it.setIsDelete(("1"));
                    postRepository.save(it);
                    return it;
                }).orElseThrow(
                        () -> {
                            return new RuntimeException("해당 게시글이 존재하지 않습니다 : " + postViewRequest.getId());
                        }
                );
    }
}