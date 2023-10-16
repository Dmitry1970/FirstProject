package Homework.Module6_FinalTask;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.Callable;

import static java.util.concurrent.TimeUnit.SECONDS;


public class EventHandler implements Callable<String> {

    private Map<String, Event> map;
    private Mode mode;


    public EventHandler(Mode mode, Map<String, Event> map) {
        this.mode = mode;
        this.map = map;
    }

    @Override
    public String call() throws InterruptedException {
        long d = 0;
        String result = " ";
        for (Map.Entry<String, Event> i : map.entrySet()) {
            d = Duration.between(LocalDateTime.now(), i.getValue().getDate()).toSeconds();
//            System.out.println(d);
            switch (mode) {
                case MODE1:
                    while (d > 0) {
                        SECONDS.sleep(1);
                        System.out.println(Thread.currentThread().getName() + " " + i.getKey() + " время до старта " +
                                Duration.between(LocalDateTime.now(), i.getValue().getDate()).toSeconds() + " секунд");
                        d--;
                    }
                case MODE2:
                    if (d == 0) {
                        i.getValue().setIsActive(true);
                        System.out.println(Thread.currentThread().getName() + " " + i.getValue().getName() +
                                " уже началось!");
                    }
                case MODE3:
                    if (i.getValue().getIsActive()) {
                        int notificationAfterEvent = 0;   //количество раз отправки сообщения после начала мероприятия
                        while (notificationAfterEvent < 10) {
                            SECONDS.sleep(1);
                            result = "Мероприятие " + "\"" + i.getValue().getName() + "\"" + " уже началось";
                            System.out.println(Thread.currentThread().getName() + " " + result);
                            ++notificationAfterEvent;
                            break;
                        }
                    }
            }
        }
        return result;
    }
}
