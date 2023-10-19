package org.kernel360.orury.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.comment.domain.CommentLike;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.board.post.domain.PostLike;
import org.kernel360.orury.global.domain.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Builder
@AllArgsConstructor
@Table(name = "USER")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String sex;

    private String birthday;

    @Column(nullable = false)
    private String memId;

    @Column(nullable = false, name = "PASSWD")
    private String password;

    private LocalDate passwdUpdateDate;

    @Column(unique = true, name = "EMAIL_ADDR")
    private String email;

    @Column(nullable = false, name = "EMAIL_YN")
    private String isEmailExists;

    @Column(nullable = false)
    private String isWithdraw;

    private String withdrawId;

    private LocalDate withdrawAt;

    private String remark1;

    private String remark2;

    private String remark3;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<PostLike> postLikes = new HashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<CommentLike> commentLikes = new HashSet<>();

    protected User() {

    }
}
