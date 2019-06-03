package com.engtharwat.mystopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds=0;
    private boolean running;

    private TextView time_view;
    private Button start_btn,stop_btn,reset_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time_view = (TextView) findViewById(R.id.time_view);
        start_btn=(Button)findViewById(R.id.start_btn);
        stop_btn=(Button)findViewById(R.id.stop_btn);
        reset_btn=(Button)findViewById(R.id.reset_btn);
        runTimer();


        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                running=true;
            }
        });
        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                running=false;
            }
        });
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running=false;
                seconds=0;
            }
        });
    }
        private void runTimer(){
        final Handler hander= new Handler();
        hander.post(new Runnable() {
            @Override
            public void run() {
                int hours=seconds/3600;
                int minutes=(seconds%3600)/60;
                int secs=seconds%60;
                String time=String.format("%d:%02d:%02d",hours,minutes,secs);
                time_view.setText(time);
                if (running){
                    seconds++;
                }
                hander.postDelayed(this,1000);
            }
        });
    }

}
