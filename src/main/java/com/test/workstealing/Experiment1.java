package com.test.workstealing;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Experiment1 {

    private static final Logger log = Logger.getLogger(Experiment1.class.getName());

    public static void main(String[] args) {
        log.log(Level.INFO, "no of available  processor core is {0} ",
                Runtime.getRuntime().availableProcessors());
    }

}
