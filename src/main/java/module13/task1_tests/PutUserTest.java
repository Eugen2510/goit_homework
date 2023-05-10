package module13.task1_tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import module13.Task1Methods;
import module13.User;

import java.io.IOException;

public class PutUserTest {
    public static void main(String[] args) {
        User user = User.builder()
                .name("Eugene Luhovyi")
                .username("some_nic")
                .email("my_email@gmail.com")
                .phone("012 344 55 66")
                .website("none")
                .build();

        User changedUser = null;

        try {
            changedUser = Task1Methods.putUser(2,user);
        }catch (IOException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(changedUser));

    }
}
