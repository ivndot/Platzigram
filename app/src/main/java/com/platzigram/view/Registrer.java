package com.platzigram.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.platzigram.R;

public class Registrer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrer);

        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount), true); //enviamos el titulo por medio de recurso
    }

    public void showToolbar(String tittle, boolean upButton){

        Toolbar toolbar= findViewById(R.id.toolbar); //hacemos una variable de tipo toolabr y lo encontramos  por medio de su id
        setSupportActionBar(toolbar); //para que tenga soporte y se vea bien en versiones anteriores a lollipop
        getSupportActionBar().setTitle(tittle); // le enviamos su titulo
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton); // le decimos si tiene boton de back
    }
}
