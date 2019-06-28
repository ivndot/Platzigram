package com.platzigram;

import android.content.Intent;

import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.platzigram.login.view.Login;


public class SplashScreen extends AppCompatActivity {

    private final int time_splash_screen=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        //validación para poner la barra de notificaciones transparente
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent= new Intent(SplashScreen.this, Login.class);
                startActivity(intent);
                finish();
            }
        },time_splash_screen);


    }
}
