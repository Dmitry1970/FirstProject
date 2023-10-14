package Homework.Module6_FinalTask;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(6);
        Map<String, Event> eventMap = new HashMap<>();

        Event event1 = new Event("Совещание", LocalDateTime.now().plusSeconds(5), "Повестка дня", false);
        Event event2 = new Event("Собеседование", LocalDateTime.now().plusSeconds(10), "Устройство на работу", false);

        eventMap.put(event1.getName(), event1);
        eventMap.put(event2.getName(), event2);

        Callable<String> eventHandler;
        Future<String> res;

        for (Mode i : Mode.values()) {
            eventHandler = new EventHandler(i, eventMap);
            res = pool.submit(eventHandler);  // должно быть map??
            System.out.println(res.get());
        }
        pool.shutdown();
    }
}
