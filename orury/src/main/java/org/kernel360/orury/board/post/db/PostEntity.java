package org.kernel360.orury.board.post.db;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "post")

public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long userId;

    private String postTitle;
    @Column(columnDefinition = "TEXT")
    private String postContent;
    private String userNickname;
    private int viewCnt;
    private int likeCnt;
    private String isDelete;
    private String remark1;
    private String remark2;
    private String remark3;

    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
