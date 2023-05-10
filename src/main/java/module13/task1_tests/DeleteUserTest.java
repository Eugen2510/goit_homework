package module13.task1_tests;

import module13.Task1Methods;
import module13.User;

import java.io.IOException;
import java.util.List;

public class DeleteUserTest {
    public static void main(String[] args) {
        List<User> users;
        String result = null;
        try {
            users = Task1Methods.getUsers();
            result = Task1Methods.deleteUser(users.get(2));

        }catch (IOException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(result);
    }
}
