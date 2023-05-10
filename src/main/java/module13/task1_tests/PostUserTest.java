package module13.task1_tests;

import module13.Task1Methods;
import module13.User;

import java.io.IOException;

public class PostUserTest {
    public static void main(String[] args) {
        User user = User.builder()
                .name("Eugene Luhovyi")
                .username("some_nic")
                .email("my_email@gmail.com")
                .phone("012 344 55 66")
                .website("none")
                .build();

        User userFromResponse = null;

        try {
            userFromResponse = Task1Methods.postUser(user);
        }catch (IOException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(userFromResponse);
    }
}
