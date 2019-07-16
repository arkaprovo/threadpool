package com.test.workstealing;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Experiment3 {

    private static final Logger log = Logger.getLogger(Experiment3.class.getName());

    private static BlockingQueue queue=new LinkedBlockingQueue(4);
    private static ThreadFactory threadFactory= Executors.defaultThreadFactory();
    private static RejectTaskHandler rth=new RejectTaskHandler();
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2,
            10L, TimeUnit.MILLISECONDS, queue,
            threadFactory,rth
    );

    public static void main(String[] args) {


        IntStream.range(0,100).forEach(number -> threadPoolExecutor.submit(newWork(number)));
        log.log(Level.INFO, "all work scheduled successfully");

        while(true){

        }

    }

    private static Runnable newWork(int workNumber){
        return ()-> {
            try {
                Thread.sleep(4000);
                log.log(Level.INFO, "work {0} ended under thread {1} ", new Object[]{workNumber,Thread.currentThread().getName()});
            } catch (InterruptedException e) {
                log.log(Level.SEVERE, "error is {0} ", e.getLocalizedMessage());
                Thread.currentThread().interrupt();
            }
        };
    }

}
