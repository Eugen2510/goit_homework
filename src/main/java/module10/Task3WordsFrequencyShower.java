package module10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class Task3WordsFrequencyShower {
    public void showEachWordFrequency(String filePath){//метод для виклику, запускає два службових, що реалізують всю логіку
        HashMap<String, Integer> map = contentReader(filePath);
        contentShower(map);
    }
    private HashMap <String, Integer> contentReader(String filePath){//зчитує вміст файлу створює і повертає мапу, де зберігаються пари ключ(слово) значення(кількість повторів)
        File file = new File(filePath);
        HashMap <String, Integer> map = new HashMap<>();
        try(Scanner sc = new Scanner(file)) {
            while (sc.hasNext()){
                String s = sc.next();
                if(map.containsKey(s)){
                    map.replace(s, map.get(s)+1);
                }else {
                    map.put(s,1);
                }
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return map;
    }

    private void contentShower(HashMap <String, Integer> map){//рекурсивно шукає, ключ з найбільшим значенням та видаляє його з мапи
        if(map.size() == 0) return;
        Set<String> set = map.keySet();
        String word = null;
        int freq = 0;
        for (String key : set){
            if(map.get(key) > freq){
                freq = map.get(key);
                word = key;
            }
        }
        System.out.println(word +"\t\t" + map.remove(word));
        contentShower(map);
    }
}
