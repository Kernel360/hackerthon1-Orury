package org.kernel360.orury.user.domain;

import lombok.Getter;
import lombok.Setter;
import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.comment.domain.CommentLike;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.board.post.domain.PostLike;
import org.kernel360.orury.global.domain.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class UserAccount extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50)
    private String userId;
    @Column(nullable = false)
    private String password;
    private String nickname;
    private String sex;
    private String birth;
    @Column(nullable = false, unique = true)
    private String email;
    @OneToMany
    private Set<Post> posts = new HashSet<>();
    @OneToMany
    private Set<Comment> comments = new HashSet<>();
    @OneToMany
    private Set<PostLike> postLikes = new HashSet<>();
    @OneToMany
    private Set<CommentLike> commentLikes = new HashSet<>();

    protected UserAccount() {
    }

    private UserAccount(
            String userId,
            String password,
            String nickname,
            String sex,
            String birth,
            String email,
            Set<Post> posts,
            Set<Comment> comments,
            Set<PostLike> postLikes,
            Set<CommentLike> commentLikes
    ) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.sex = sex;
        this.birth = birth;
        this.email = email;
        this.posts = posts;
        this.comments = comments;
        this.postLikes = postLikes;
        this.commentLikes = commentLikes;
    }

    public static UserAccount of(String userId, String password, String nickname, String email) {
        return UserAccount.of(
                userId,
                password,
                nickname,
                null,
                null,
                email,
                null,
                null,
                null,
                null
        );
    }

    public static UserAccount of(
            String userId,
            String password,
            String nickname,
            String sex,
            String birth,
            String email,
            Set<Post> posts,
            Set<Comment> comments,
            Set<PostLike> postLikes,
            Set<CommentLike> commentLikes
    ) {
        return new UserAccount(
                userId,
                password,
                nickname,
                sex,
                birth,
                email,
                posts,
                comments,
                postLikes,
                commentLikes
        );
    }
}
