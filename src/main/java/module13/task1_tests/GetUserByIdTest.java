package module13.task1_tests;

import module13.Task1Methods;
import module13.User;

import java.io.IOException;

public class GetUserByIdTest {
    public static void main(String[] args) {
        User userById = null;
        int id = 2;

        try {
            userById = Task1Methods.getUserById(id);
        }catch (IOException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(userById);
    }
}
