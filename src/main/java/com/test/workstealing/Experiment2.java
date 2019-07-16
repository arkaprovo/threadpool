package com.test.workstealing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Experiment2 {

    private static final Logger log = Logger.getLogger(Experiment2.class.getName());
    // private static final int NO_OF_CPU_CORE = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        ExecutorService executor; //= Executors.newWorkStealingPool(NO_OF_CPU_CORE);
        executor = Executors.newFixedThreadPool(100);
        IntStream.range(0,100).forEach( number -> executor.submit(newWork(number)));
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
