package org.kernel360.orury.board.post.repository;

import org.kernel360.orury.board.post.db.PostEntity;
import org.kernel360.orury.board.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    // select * from post where id = ? and status = ? order by id desc limit 1
    public Optional<PostEntity> findFirstByIdAndIsDeleteOrderByIdDesc(Long id, String isDelete);
    Post getPostById(Integer postId);
}
