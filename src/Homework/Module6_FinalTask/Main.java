package Homework.Module6_FinalTask;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Map<String, Event> eventMap = new HashMap<>();

        Event event1 = new Event("Совещание", LocalDateTime.now().plusSeconds(25), "Повестка дня", false);
        Event event2 = new Event("Собеседование", LocalDateTime.now().plusSeconds(5), "Устройство на работу", false);

        eventMap.put(event1.getName(), event1);
        eventMap.put(event2.getName(), event2);

        Callable<String> eventHandler1 = new EventHandler(eventMap);
        Callable<String> eventHandler2 = new EventHandler(eventMap);
        Callable<String> eventHandler3 = new EventHandler(eventMap);
        Callable<String> eventHandler4 = new EventHandler(eventMap);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(eventHandler1);
        executor.submit(eventHandler2);
        executor.submit(eventHandler3);
        executor.submit(eventHandler4);

        executor.shutdown();
    }
}