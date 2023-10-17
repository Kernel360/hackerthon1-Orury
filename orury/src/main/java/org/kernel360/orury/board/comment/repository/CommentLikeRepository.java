package org.kernel360.orury.board.comment.repository;

import org.kernel360.orury.board.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentLikeRepository extends JpaRepository<Comment, Integer> {

}
