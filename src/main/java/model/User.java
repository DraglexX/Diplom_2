package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static constant.RandomData.*;

@Data
@AllArgsConstructor
public class User {
    private String email;
    private String password;
    private String name;

    public static User allField() {
        return new User(System.currentTimeMillis() + EMAIL, PASSWORD + System.currentTimeMillis(), NAME + System.currentTimeMillis());
    }

    public static User withoutEmail() {
        return new User(EMPTY, PASSWORD, NAME);
    }

    public static User withoutPassword() {
        return new User(EMAIL, EMPTY, NAME);
    }

    public static User withoutName() {
        return new User(EMAIL, PASSWORD, EMPTY);
    }
}
