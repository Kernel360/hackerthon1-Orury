package org.kernel360.orury.board.comment.domain;

import lombok.*;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.global.domain.BaseEntity;
import org.kernel360.orury.user.domain.UserAccount;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
@NoArgsConstructor
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private UserAccount userAccount;
    @ManyToOne
    private Post post;
    private String content;
    private int likeCnt;
    private Integer parentId;
    private Integer childId;
    private boolean isDeleted;

    @Builder
    public Comment(Long id, UserAccount userAccount, Post post, String content, int likeCnt, Integer parentId, Integer childId, boolean isDeleted) {
        this.id = id;
        this.userAccount = userAccount;
        this.post = post;
        this.content = content;
        this.likeCnt = likeCnt;
        this.parentId = parentId;
        this.childId = childId;
        this.isDeleted = isDeleted;
    }
}