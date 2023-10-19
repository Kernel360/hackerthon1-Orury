package org.kernel360.orury.board.comment.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.kernel360.orury.global.domain.BaseEntity;
import org.kernel360.orury.user.domain.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class CommentLike extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    private boolean isLike;
}

