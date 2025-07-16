package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Credentials {
    private String email;
    private String password;
    private String name;

    public static Credentials fromUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Пользователь не может быть null.");
        }
        return new Credentials(user.getEmail(), user.getPassword(), user.getName());
    }

    public static Credentials withOtherEmail(User user, String newEmail) {
        Credentials credentials = fromUser(user);
        return new Credentials(newEmail, credentials.getPassword(), credentials.getName());
    }

    public static Credentials withOtherPassword(User user, String newPassword) {
        Credentials credentials = fromUser(user);
        return new Credentials(credentials.getEmail(), newPassword, credentials.getName());
    }

    public static Credentials withOtherName(User user, String newName) {
        Credentials credentials = fromUser(user);
        return new Credentials(credentials.getEmail(), credentials.getPassword(), newName);
    }
}
