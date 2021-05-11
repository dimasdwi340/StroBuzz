package com.dimas.projectakhirku;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1200);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(splash.this, MainActivity.class));
                    finish();
                }

            }
        };
        thread.start();
    }
}
