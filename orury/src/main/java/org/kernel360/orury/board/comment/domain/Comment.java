package org.kernel360.orury.board.comment.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private UserAccount userAccount;
    @ManyToOne
    private Post post;
    private String content;
    private int likeCnt;
    private Integer parentId;
    private Integer childId;
    private boolean isDeleted;
}
