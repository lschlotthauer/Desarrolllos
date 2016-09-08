package com.example.android.clase7_thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements Handler.Callback{

    private TextView text;
    private MyThred t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler h = new Handler(this);
        text = (TextView)findViewById(R.id.txt);

        t = new MyThred(h);
        t.start();
    }

    @Override
    public boolean handleMessage(Message msg) {

        String s = (String) msg.obj;
        text.setText(s);
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        t.interrupt();
    }
}
