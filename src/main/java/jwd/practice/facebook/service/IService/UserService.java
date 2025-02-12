package jwd.practice.facebook.service.IService;

import jwd.practice.facebook.dto.response.UserDTO;
import jwd.practice.facebook.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> searchUsers(String keyword);
    void sendFriendRequest(Long userId, Long friendId);
    void acceptFriendRequest(Long userId, Long friendId);
    void unfriend(Long userId, Long friendId);
    void blockUser(Long userId, Long blockedId);
}
