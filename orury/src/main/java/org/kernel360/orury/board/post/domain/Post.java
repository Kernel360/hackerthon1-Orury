package org.kernel360.orury.board.post.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.global.domain.BaseEntity;
import org.kernel360.orury.user.domain.UserAccount;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "userId")
    @ManyToOne(optional = false)
    private UserAccount userAccount;
    private String title;
    private String content;
    private int viewCnt;
    private int likeCnt;

    @ToString.Exclude
    @OrderBy("createdAt DESC")
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comments;
    private boolean isDeleted;

    protected Post() {

    }

    private Post(
            Integer id,
            UserAccount userAccount,
            String title,
            String content,
            int viewCnt,
            int likeCnt,
            Set<Comment> comments,
            boolean isDeleted
    ) {
        this.id = id;
        this.userAccount = userAccount;
        this.title = title;
        this.content = content;
        this.viewCnt = viewCnt;
        this.likeCnt = likeCnt;
        this.comments = comments;
        this.isDeleted = isDeleted;
    }

    public static Post of(
            Integer id,
            UserAccount userAccount,
            String title,
            String content,
            int viewCnt,
            int likeCnt,
            Set<Comment> comments,
            boolean isDeleted
    ) {
        return new Post(
                id,
                userAccount,
                title,
                content,
                viewCnt,
                likeCnt,
                comments,
                isDeleted
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
