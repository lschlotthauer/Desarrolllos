package com.example.lucass.tpmemotest;

import android.os.Handler;
import android.os.Message;

/**
 * Created by lucass on 5/6/2016.
 */
public class Worker extends Thread {

    private Handler h ;
    private long timeSleep;
    public Worker(Handler h, long time)
    {
        this.h = h;
        this.timeSleep = time;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            return;
        }
        Message msg =  new Message();
        if (timeSleep == 1000) {
            msg.arg1 = 1;
        }

        h.sendMessage(msg);

    }
}
