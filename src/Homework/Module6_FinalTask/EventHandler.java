package Homework.Module6_FinalTask;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.Callable;

import static java.util.concurrent.TimeUnit.SECONDS;


public class EventHandler implements Callable<String> {

    private Map<String, Event> map;

    public EventHandler(Map<String, Event> map) {
        this.map = map;
    }

    @Override
    public String call() throws InterruptedException {
        String result = " ";
        for (Event i : map.values()) {
            long d = Duration.between(LocalDateTime.now(), i.getDate()).toSeconds();
            while (d > 0) {
                d = Duration.between(LocalDateTime.now(), i.getDate()).toSeconds();
                System.out.println(Thread.currentThread().getName() + " " + i + " время до старта " +
                        Duration.between(LocalDateTime.now(), i.getDate()).toSeconds() + " секунд");
                SECONDS.sleep(1);
            }
            if (d == 0 && !i.getIsActive()) {
                System.out.println(Thread.currentThread().getName() + " " + i +
                        " уже началось!");
                i.setIsActive(true);
            }

            if (i.getIsActive()) {
                int notificationAfterEvent = 0;   //количество раз отправки сообщения после начала мероприятия
                while (notificationAfterEvent < 5) {
                    SECONDS.sleep(1);
                    result = Thread.currentThread().getName() + " " + "Мероприятие " + "\"" + i +
                            "\"" + " уже началось";
                    System.out.println(result);
                    notificationAfterEvent++;
                }
            }
        }
        return result;
    }
}
