package org.kernel360.orury.board.comment.domain;

import lombok.*;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.global.domain.BaseEntity;
import org.kernel360.orury.global.util.isDeletedConverter;
import org.kernel360.orury.global.util.isDeletedType;
import org.kernel360.orury.user.domain.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "BOARD_COMMENT")
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String commentContent;

    @Column(nullable = false)
    private String userNickName;

    @Column(nullable = false)
    private int likeCnt;

    @Column(name = "P_ID")
    private Long parentId;

    @Convert(converter = isDeletedConverter.class)
    @Column(name = "IS_DELETE")
    private isDeletedType isDeleted;

    private String remark1;

    private String remark2;

    private String remark3;

    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;;

}