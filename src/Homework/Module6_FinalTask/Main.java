package Homework.Module6_FinalTask;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        LocalDateTime dateTime = LocalDateTime.now();

        Map<String, Event> eventMap = new HashMap<>();

        Event event1 = new Event("Совещание", dateTime.plusSeconds(5), "Повестка дня", false);
        Event event2 = new Event("Собеседование", dateTime.plusSeconds(15), "Устройство на работу", false);

        eventMap.put(event1.getName(), event1);
        eventMap.put(event2.getName(), event2);

//        Способ создания потоков без цикла
//
        Callable<String> eventHandler1 = new EventHandler(Mode.MODE1, eventMap);
        Callable<String> eventHandler2 = new EventHandler(Mode.MODE2, eventMap);
        Callable<String> eventHandler3 = new EventHandler(Mode.MODE3, eventMap);

        Future<String> res1 = pool.submit(eventHandler1);
        Future<String> res2 = pool.submit(eventHandler2);
        Future<String> res3 = pool.submit(eventHandler3);

        System.out.println(res1.get());
        System.out.println(res2.get());
        System.out.println(res3.get());


        // сделал цикл для потоков

//        Callable<String> eventHandler;
//        Future<String> res = null;
//        for (Mode m : Mode.values()) {
//            eventHandler = new EventHandler(m, eventMap);
//            res = pool.submit(eventHandler);
//        }
//        System.out.println(res.get());
        pool.shutdown();

    }
}
