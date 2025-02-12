package jwd.practice.facebook.repository;

import jwd.practice.facebook.dto.response.UserDTO;
import jwd.practice.facebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    List<UserDTO> findByUsernameContaining(String username); // Tìm kiếm bạn bè theo tên

}
