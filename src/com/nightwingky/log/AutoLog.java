package com.nightwingky.log;


public class AutoLog {

    public static void autoLog() {
        Thread thread = new AutoLogThread();
        thread.start();
    }

}
