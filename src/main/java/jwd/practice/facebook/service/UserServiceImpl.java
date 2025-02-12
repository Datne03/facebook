package jwd.practice.facebook.service;

import jwd.practice.facebook.dto.response.UserDTO;
import jwd.practice.facebook.entity.User;
import jwd.practice.facebook.repository.UserRepository;
import jwd.practice.facebook.service.IService.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Override
    public List<User> searchUsers(String keyword) {
        List<User> users = userRepository.findByUsernameContaining(keyword);
        return users.stream().filter(u -> u.getUsername().contains(keyword)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void sendFriendRequest(Long userId, Long friendId) {
        User user = userRepository.findById(userId).orElseThrow();
        User friend = userRepository.findById(friendId).orElseThrow();
        user.getFriends().add(friend);
        friend.getFriends().add(user);
        userRepository.save(user);
        userRepository.save(friend);
    }

    @Transactional
    @Override
    public void acceptFriendRequest(Long userId, Long friendId) {
        sendFriendRequest(userId, friendId); // Giả định lời mời đã gửi
    }

    @Transactional
    @Override
    public void unfriend(Long userId, Long friendId) {
        User user = userRepository.findById(userId).orElseThrow();
        User friend = userRepository.findById(friendId).orElseThrow();
        user.getFriends().remove(friend);
        friend.getFriends().remove(user);
        userRepository.save(user);
        userRepository.save(friend);
    }

    @Transactional
    @Override
    public void blockUser(Long userId, Long blockedId) {
        User user = userRepository.findById(userId).orElseThrow();
        User blockedUser = userRepository.findById(blockedId).orElseThrow();
        user.getBlockedUsers().add(blockedUser);
        user.getFriends().remove(blockedUser);
        blockedUser.getFriends().remove(user);
        userRepository.save(user);
    }
}
