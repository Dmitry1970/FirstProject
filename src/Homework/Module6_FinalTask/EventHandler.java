package Homework.Module6_FinalTask;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.Callable;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;


public class EventHandler implements Callable<String> {

    private Map<String, Event> map;
    private Event event;
    private Mode mode;


    public EventHandler(Mode mode, Map<String, Event> map) {
        this.mode = mode;
        this.map = map;
    }

    @Override
    public String call() throws InterruptedException {
        long d = Duration.between(LocalDateTime.now(), event.getDate()).toSeconds();
        switch (mode) {
            case MODE1:
                while (d > 0 && d <= 3600) {
                    SECONDS.sleep(1);
                    System.out.println(event.getName() + " время до старта " + d + " секунд");
                }
            case MODE2:
                if (d == 0) {
                    event.setIsActive(true);
                    System.out.println(event.getName() + " уже началось!");
                    break;
                }
            case MODE3:
                if (event.getIsActive()) {
                    MINUTES.sleep(1);
                    System.out.println("Мероприятие уже началось");
                }
        }
        return Thread.currentThread().getName() + event.getName();   // что возвращает??
    }

}
