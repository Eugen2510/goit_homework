package module12;

import java.time.Duration;
import java.time.LocalTime;

public class TimeFromStartShower{
    private final static Thread eachSecondShower = new Thread(() -> {
        LocalTime lt = LocalTime.now();
        while (true){
            Duration duration = Duration.between(lt, LocalTime.now());
            System.out.println(duration.toSeconds() + " seconds have passed since the start.");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    });;
    private static final Thread fiveSecondShower = new Thread(() -> {
        int interval = 5000;
        while (true){
            try{
                Thread.sleep(interval);
                System.out.println("5 seconds have passed");
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    });


    public static void startPoint(){
        fiveSecondShower.start();
        eachSecondShower.start();
    }
}
