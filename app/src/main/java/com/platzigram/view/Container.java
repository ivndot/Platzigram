package com.platzigram.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.platzigram.R;
import com.platzigram.view.Fragments.HomeFragment;
import com.platzigram.view.Fragments.ProfileFragment;
import com.platzigram.view.Fragments.SearchFragment;

public class Container extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);


        //creamos un objeto de tipo BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        //los parametros del metodo replace(en donde quiero poner mi fragment, el fragment que voy a inyectar)
        getSupportFragmentManager().beginTransaction().replace(R.id.container_1, new HomeFragment()).commit();



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment selectedFragment=null;

                switch (menuItem.getItemId()){

                    case R.id.tabHome:
                        selectedFragment= new HomeFragment();
                        break;
                    case R.id.tabProfile:
                        selectedFragment= new ProfileFragment();
                        break;
                    case R.id.tabSearch:
                        selectedFragment= new SearchFragment();
                        break;
                }

                //los parametros del metodo replace(en donde quiero poner mi fragment, el fragment que voy a inyectar)
                getSupportFragmentManager().beginTransaction().replace(R.id.container_1, selectedFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();

                return true;
            }
        });
    }


}
