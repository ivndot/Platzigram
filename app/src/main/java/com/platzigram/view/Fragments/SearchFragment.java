package com.platzigram.view.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.platzigram.R;
import com.platzigram.adapter.PictureAdapterRecyclerView;
import com.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {



    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ponemos a que layout va a mostrar el fragment
        View view= inflater.inflate(R.layout.fragment_search, container, false);



        GridLayoutManager gridLayoutManager= new GridLayoutManager(view.getContext(),2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);


        RecyclerView recyclerView= view.findViewById(R.id.pictureSearchRecyclerView);

        recyclerView.setLayoutManager(gridLayoutManager);


        PictureAdapterRecyclerView pictureAdapterRecyclerView= new PictureAdapterRecyclerView(buildPictures(),getActivity());

        recyclerView.setAdapter(pictureAdapterRecyclerView);


        return view;
    }

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


}
