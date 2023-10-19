package org.kernel360.orury.board.post.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.global.util.isDeletedConverter;
import org.kernel360.orury.global.util.isDeletedType;
import org.kernel360.orury.global.domain.BaseEntity;
import org.kernel360.orury.user.domain.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "BOARD_POST")
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postTitle;

    private String postContent;

    @JoinColumn(name = "USER_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    private int viewCnt;

    private int likeCnt;

    @Convert(converter = isDeletedConverter.class)
    @Column(name = "IS_DELETE", nullable = false)
    private isDeletedType isDeleted;

    private String remark1;

    private String remark2;

    private String remark3;

    @ToString.Exclude
    @OrderBy("createdAt DESC")
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;

    protected Post() {

    }

    @Builder
    public Post(Long id, String postTitle, String postContent, User user, int viewCnt, int likeCnt, isDeletedType isDeleted, String remark1, String remark2, String remark3, Set<Comment> comments) {
        this.id = id;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.user = user;
        this.viewCnt = viewCnt;
        this.likeCnt = likeCnt;
        this.isDeleted = isDeleted;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.remark3 = remark3;
        this.comments = comments;
    }

    public static Post of(
            Long id,
            User user,
            String postTitle,
            String postContent,
            int viewCnt,
            int likeCnt,
            Set<Comment> comments,
            isDeletedType isDeleted
    ) {
        return Post.builder()
                .id(id)
                .user(user)
                .postTitle(postTitle)
                .postContent(postContent)
                .viewCnt(viewCnt)
                .likeCnt(likeCnt)
                .comments(comments)
                .isDeleted(isDeleted)
                .build();

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
