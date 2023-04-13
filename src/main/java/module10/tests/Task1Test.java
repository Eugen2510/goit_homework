package module10.tests;

import module10.Task1ValidPhoneShower;

public class Task1Test {
    public static void main(String[] args) {
        Task1ValidPhoneShower.showAllValidNumbers("./src/main/java/module10/source_files/phone-file.txt");
        Task1ValidPhoneShower.showAllValidNumbers("IncorrectPath.txt");
    }
}
