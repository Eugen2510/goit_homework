package module13.task1_tests;

import module13.Task1Methods;
import module13.User;

import java.io.IOException;

public class GetUserByUserNameTest {
    public static void main(String[] args) {
        User userByUsername = null;

        try {
            userByUsername = Task1Methods.getUserByUsername("Karianne");
        }catch (IOException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(userByUsername);
    }
}
