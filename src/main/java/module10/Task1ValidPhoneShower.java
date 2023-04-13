package module10;

import java.io.*;

public class Task1ValidPhoneShower {
    public static void showAllValidNumbers(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))//користуюся BufferedReader, щоб зчитувати рядки
        {
           String line;
           while ((line = br.readLine())!=null){
               if(line.matches("(\\(\\d{3}\\) \\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4})")){//кожен рядок перевіряю на відповідність рег виразу
                   System.out.println(line);
               }
           }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

}

