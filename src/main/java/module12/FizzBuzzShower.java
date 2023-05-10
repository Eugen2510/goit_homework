package module12;

import java.util.HashMap;
import java.util.stream.Collectors;

public class FizzBuzzShower {

    private final int n;
    private final HashMap<Integer, String> map1 = new HashMap<>();

    Thread fizzSearcher = new Thread(this::fizz);//поток для додавання чисел, що діляться на 3
    Thread buzzSearcher = new Thread(this::buzz);//поток для додавання чисел, що діляться на 5
    Thread fizzBuzzSearcher = new Thread(this::fizzBuzz);//поток для додавання чисел, що діляться на 3 і на 5 одночасно

    Thread transformer = new Thread(this::transformToFizzBuzz);//резюмуючий поток, що запускає 3 інших, а також додає цифри, що не підпадають під будь-яку з умов


    public FizzBuzzShower(int n){
        this.n = n;
    }

    public void startTransform(){//запускаємо виконання
        transformer.start();
    }

    private void fizz(){
        for (int i = 1; i <= n; i++) {
            if(i %3 == 0 && i % 5 != 0){
                addToMap(i, "fizz");
            }
        }
    }

    private void buzz(){
        for (int i = 1; i <= n; i++) {
            if(i %3 != 0 && i % 5 == 0){
                addToMap(i, "buzz");
            }
        }
    }

    private void fizzBuzz(){
        for (int i = 1; i <= n; i++) {
            if(i %3 == 0 && i % 5 == 0){
                addToMap(i, "fizzBuzz");
            }
        }
    }

    private void transformToFizzBuzz(){//запускаємо 3 потоки, чекаємо завершення, результат виводимо в консоль
        fizzSearcher.start();
        buzzSearcher.start();
        fizzBuzzSearcher.start();
        for (int i = 1; i <= n; i++) {
            if(i %3 != 0 && i % 5 != 0){
                addToMap(i, String.valueOf(i));
            }
        }

        try {
            fizzSearcher.join();
            buzzSearcher.join();
            fizzBuzzSearcher.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!fizzBuzzSearcher.isAlive() && !fizzSearcher.isAlive()&& !buzzSearcher.isAlive()){
            System.out.println(map1.keySet().stream()
                    .sorted()
                    .map(map1::get)
                    .collect(Collectors.joining(", ")));
        }
    }

    private synchronized void addToMap(int key, String value){
        map1.put(key,value);
    }

}
