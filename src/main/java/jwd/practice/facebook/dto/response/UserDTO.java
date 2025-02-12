package jwd.practice.facebook.dto.response;

import jakarta.persistence.*;
import jwd.practice.facebook.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    long id;
    String username;
    String email;
    String password;
    String avatar;
    String bio;
    User.Status status;
    Timestamp createdAt;
}
