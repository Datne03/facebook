package jwd.practice.facebook.controller;

import jwd.practice.facebook.dto.response.UserDTO;
import jwd.practice.facebook.entity.User;
import jwd.practice.facebook.service.IService.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String keyword) {
        return ResponseEntity.ok(userService.searchUsers(keyword));
    }

    @PostMapping("/{userId}/send-friend-request/{friendId}")
    public ResponseEntity<Void> sendFriendRequest(@PathVariable Long userId, @PathVariable Long friendId) {
        userService.sendFriendRequest(userId, friendId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}/accept-friend-request/{friendId}")
    public ResponseEntity<Void> acceptFriendRequest(@PathVariable Long userId, @PathVariable Long friendId) {
        userService.acceptFriendRequest(userId, friendId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}/unfriend/{friendId}")
    public ResponseEntity<Void> unfriend(@PathVariable Long userId, @PathVariable Long friendId) {
        userService.unfriend(userId, friendId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}/block/{blockedId}")
    public ResponseEntity<Void> blockUser(@PathVariable Long userId, @PathVariable Long blockedId) {
        userService.blockUser(userId, blockedId);
        return ResponseEntity.ok().build();
    }
}
