package module13.task3_tests;

import module13.Task3ToDoShower;

import java.io.IOException;

public class OpenTasksShower {
    public static void main(String[] args){
        try {
            Task3ToDoShower.openTaskShower(1);
        }catch (IOException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }

    }
}
