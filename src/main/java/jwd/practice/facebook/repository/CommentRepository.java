package jwd.practice.facebook.repository;

import jwd.practice.facebook.entity.Comment;
import jwd.practice.facebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
