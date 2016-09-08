package com.example.android.clase7_thread;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by android on 04/05/16.
 */
public class MyThred extends Thread {


    private Handler h ;


    public MyThred(Handler h)
    {
        this.h = h;
    }

    @Override
    public void run() {
        int i=0;
        while(true)
        {
            i++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.d("Thread", "Salgo del thread");
                //e.printStackTrace();
                return;
            }
            Message msg =  new Message();
            msg.obj = "Contador: " + i;
            h.sendMessage(msg);
        }

    }
}
