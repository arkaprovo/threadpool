package com.test.workstealing;

import java.util.Objects;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RejectTaskHandler implements RejectedExecutionHandler{

    private static final Logger log = Logger.getLogger(RejectTaskHandler.class.getName());


    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        Objects.requireNonNull(r);
        log.log(Level.SEVERE,"rejecting task  ");
    }
}
