package com.platzigram.view.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.platzigram.R;
import com.platzigram.adapter.PictureAdapterRecyclerView;
import com.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{




    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //ponemos a que layout va a mostrar el fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        //ponemos el toolbar
        showToolbar(getResources().getString(R.string.toolbar_tittle_fragmenthome), false, view);

        //hacemos una variable de tipo recyclerview
        RecyclerView picturesRecycler= view.findViewById(R.id.pictureRecyclerView);

        //le decimos que tipo de lista va a tener
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);

        //instanciamos nuestro adapter
        PictureAdapterRecyclerView pictureAdapterRecyclerView= new PictureAdapterRecyclerView(buildPictures(),getActivity());

        //inyectamos nuestro adapter
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        //boton de back


        return view;
    }

    //hacemos metodo para ingresar por HARDCODE algunos datos de personas en el array

    public ArrayList<Picture> buildPictures(){

        ArrayList<Picture> pictures= new ArrayList<>();

        pictures.add(new Picture("http://i.imgur.com/DvpvklR.png","Juan Perez","9 días","10 likes"));
        pictures.add(new Picture("https://i.imgur.com/5iNrabh.jpg","Ivan Alamos","10 días","1 likes"));
        pictures.add(new Picture("https://i.imgur.com/NLADfDJ.jpg?1","Rocio Pacheco","5 meses","100 likes"));
        pictures.add(new Picture("https://conceptodefinicion.de/wp-content/uploads/2015/08/naturaleza-e1439385445458.jpg","Mariana","1 día","500 likes"));
        pictures.add(new Picture("http://i.imgur.com/DvpvklR.png","Kary Romero","1 día","500 likes"));
        pictures.add(new Picture("https://i.imgur.com/5iNrabh.jpg","Andy Meza","1 día","500 likes"));
        pictures.add(new Picture("https://i.imgur.com/NLADfDJ.jpg?1","Haziel Resendiz","1 día","500 likes"));
        pictures.add(new Picture("https://conceptodefinicion.de/wp-content/uploads/2015/08/naturaleza-e1439385445458.jpg","Ivonne Montiel","1 día","500 likes"));
        pictures.add(new Picture("http://i.imgur.com/DvpvklR.png","José","1 día","500 likes"));
        pictures.add(new Picture("https://i.imgur.com/5iNrabh.jpg","Lesly Garrido","1 día","500 likes"));

        return pictures ;
    }

    public void showToolbar(String tittle, boolean upButton, View view){

        Toolbar toolbar= view.findViewById(R.id.toolbar); //hacemos una variable de tipo toolabr y lo encontramos  por medio de su id
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar); //para que tenga soporte y se vea bien en versiones anteriores a lollipop
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle); // le enviamos su titulo
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton); // le decimos si tiene boton de back
    }


}
