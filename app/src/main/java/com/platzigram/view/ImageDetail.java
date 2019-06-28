package com.platzigram.view;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;

import com.platzigram.R;

public class ImageDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        showToolbar(null,true);

        //validacion para api
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            getWindow().setEnterTransition(new Fade());

            //poner la barra de notificaciones transparente
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


    }

    public void showToolbar(String tittle, boolean upButton){

        Toolbar toolbar= findViewById(R.id.toolbar); //hacemos una variable de tipo toolabr y lo encontramos  por medio de su id
        setSupportActionBar(toolbar); //para que tenga soporte y se vea bien en versiones anteriores a lollipop
        getSupportActionBar().setTitle(tittle); // le enviamos su titulo
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton); // le decimos si tiene boton de back

        //buscamos nuestro collpasingtoolbar
        CollapsingToolbarLayout collapsingToolbarLayout= findViewById(R.id.collapsingToolbar);
    }


}
