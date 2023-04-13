package module10.tests;

import module10.Task2ConvertorToJson;

public class Task2Test {
    public static void main(String[] args) {
        Task2ConvertorToJson t2 = new Task2ConvertorToJson();

        t2.convertToJson("./src/main/java/module10/source_files/user-data.txt",
                "./src/main/java/module10/output_files/user-from-user-data.json");

        t2.convertToJson("./src/main/java/module10/source_files/user-data-reverse.txt",
                "./src/main/java/module10/output_files/user-from-user-data-reverse.json");


    }
}
