package org.kernel360.orury.board.post.repository;

import org.kernel360.orury.board.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeRepository extends JpaRepository<Post, Integer> {
}
