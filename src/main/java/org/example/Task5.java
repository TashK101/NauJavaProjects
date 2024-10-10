package org.example;

import classes.PortScanner;

public class Task5 {
    public static void taskFiveMain() throws InterruptedException {
        PortScanner scanner = new PortScanner("scanme.nmap.org", 50, 1024);
        scanner.start();

        // to demo the stop() implementation
        Thread.sleep(5000);
        scanner.stop();
    }
}
