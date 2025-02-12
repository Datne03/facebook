package jwd.practice.facebook.repository;

import jwd.practice.facebook.entity.Post;
import jwd.practice.facebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
