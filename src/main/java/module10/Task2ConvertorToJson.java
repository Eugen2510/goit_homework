package module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2ConvertorToJson {
    private String dataFromFile;//поле для збереження вмісту файлу
    private ArrayList<User> users;//поле збереження списку об'єктів

    private void fileReader(String filePath){//метод для зчитування вмісту файлу та переводу в Стрінг
        StringBuilder  source = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(filePath)){
            while (fis.available() != 0){
                source.append((char)fis.read());
            }
            dataFromFile = source.toString();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void fillList(){//метод парсить рядок з данними з файлу створює Обєєкти типу Юзер і додає їх в ліст
        users = new ArrayList<>();
        Scanner sc = new Scanner(dataFromFile);
        String title = sc.nextLine();//читаємо заголовок, щоб зрозуміти в якому порядку ідуть дані, що будуть використані для створення Юзерів
        String [] columnName = title.split(" ");
        int indexName = columnName[0].equalsIgnoreCase("name") ? 0 : 1;
        int indexAge = indexName == 0 ? 1 : 0;
        while (sc.hasNextLine()){
            String [] values = sc.nextLine().split(" ");
            User user = new User(values[indexName],Integer.parseInt(values[indexAge]));
            users.add(user);
        }
        sc.close();
    }

    public void convertToJson(String sourceFilePath, String newFilePath){//метод перетворює данні в формат Джсон та пише у вихідний джсон файл
        fileReader(sourceFilePath);
        fillList();
        try(FileWriter fw = new FileWriter(newFilePath)){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();//тупо списав з конспекту, маю дуже загальне уявлення про цей рядок і наступний
            String s = gson.toJson(users);
            fw.write(s);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

