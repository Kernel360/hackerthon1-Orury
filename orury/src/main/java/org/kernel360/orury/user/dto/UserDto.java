package org.kernel360.orury.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.comment.domain.CommentLike;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.board.post.domain.PostLike;
import org.kernel360.orury.user.domain.User;

import java.util.Set;

/**
 * DTO for {@link org.kernel360.orury.user.domain.User}
 */

@Getter
@Setter
@Builder
public class UserDto{
        private Long id;

        private String nickname;

        private String sex;

        private String birth;

        private String email;

        private String password;

        private Set<Post> posts;

        private Set<Comment> comments;

        private Set<PostLike> postLikes;

        private Set<CommentLike> commentLikes;

        public User toEntity() {
              return User.builder()
                      .id(id)
                      .nickname(nickname)
                      .sex(sex)
                      .birthday(birth)
                      .email(email)
                      .password(password)
                      .comments(comments)
                      .postLikes(postLikes)
                      .commentLikes(commentLikes)
                      .build();
        }

        public static UserDto from(User entity) {
                return UserDto.builder()
                        .id(entity.getId())
                        .nickname(entity.getNickname())
                        .sex(entity.getSex())
                        .birth(entity.getBirthday())
                        .email(entity.getEmail())
                        .password(entity.getPassword())
                        .comments(entity.getComments())
                        .postLikes(entity.getPostLikes())
                        .commentLikes(entity.getCommentLikes())
                        .build();
        }
}