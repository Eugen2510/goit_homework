package module13.task2_tests;

import module13.Task1Methods;
import module13.Task2CommentsShower;
import module13.User;

import java.io.IOException;
import java.util.List;

public class AllCommentsForLastUserPostShower {
    public static void main(String[] args) {
        List<User> users;
        try {
            users = Task1Methods.getUsers();
            Task2CommentsShower.commentsToLastUserPost(users.get(5));
        }catch (IOException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }

    }
}
