package com.example.lucass.tpmemotest;

import android.os.Handler;
import android.os.Message;

/**
 * Created by lucass on 5/6/2016.
 */
public class Worker extends Thread {

    private Handler h ;
    public Worker(Handler h)
    {
        this.h = h;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
        Message msg =  new Message();
        msg.arg1= 1;
        msg.obj = "ALGO";
        h.sendMessage(msg);

    }
}
