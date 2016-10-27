package com.example.lucass.tpmemotest;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
/**
 * Created by lucass on 10/27/2016.
 */

public class Cronometro extends Thread {

    private Handler h;

    public Cronometro(Handler h){
        this.h = h;
    }

    @Override
    public void run() {
        for(int i=30; i>-1; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.d("Cronometro", "Saliendo del cronometro.");
                return;
            }
            Message msg =  new Message();
            msg.arg1 = 2;
            msg.arg2 = i;
            h.sendMessage(msg);
        }

    }


}
