package com.platzigram.adapter;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.platzigram.R;
import com.platzigram.model.Picture;
import com.platzigram.view.Container;
import com.platzigram.view.ImageDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


//esta clase se va a encargar de hacer un array de tipo objeto y reutilizar los cardview
public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder> { //dento del array va la clase que tiene todos los views

    //variables que necesitamos para hacerlo bien :)
    private ArrayList<Picture> pictures; //Hacemos un array list en donde colocamos el modelo (Picture) para traer los datos de una BD u otro lugar

    private Activity activity;
    //constructor
    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, Activity activity) {
        this.pictures = pictures;
        this.activity=activity;
    }


    //es el metodo que va a inicializar los parametros de la clase PictureViewHolder en donde tenemos la vista
    @NonNull
    @Override
    public PictureAdapterRecyclerView.PictureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_image,viewGroup,false);

        return new PictureViewHolder(view);
    }

    //aqui se trata la lista de elementos, o sea, el array
    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder pictureViewHolder, int i) {

        //creamos una variable de tipo Picture y obtenemos el numero de objeto y se lo asigna a un cardview
        Picture picture= pictures.get(i);

        //ponemos los datos del modelo en los views
        pictureViewHolder.userNameCard.setText(picture.getUsername());
        pictureViewHolder.timeCard.setText(picture.getTime());
        pictureViewHolder.likeNumberCard.setText(picture.getLike_number());

        //picasso
        Picasso.get().load(picture.getPicture()).into(pictureViewHolder.pictureCard);

        //metodo onclick
        pictureViewHolder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(activity, ImageDetail.class);

                //validacion de api

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

                    //creamos nuestro objeto de transicion
                    Slide slide= new Slide();
                    slide.setDuration(1000);



                    activity.getWindow().setEnterTransition(slide);

                    activity.startActivity(intent, ActivityOptionsCompat
                            .makeSceneTransitionAnimation(activity,view, view.getContext().getString(R.string.transitionName)).toBundle());


                }else {
                    activity.startActivity(intent);
                }


            }
        });

    }

    //cuantas veces tiene que recorrer el arreglo
    @Override
    public int getItemCount() {
        return pictures.size();
    }

    //clase inner (una clase dentro de otra clase)
    public class PictureViewHolder extends RecyclerView.ViewHolder {

        //en esta clase trabajamos todos los views que componen el CARD VIEW

        private ImageView pictureCard;
        private TextView userNameCard;
        private TextView timeCard;
        private TextView likeNumberCard;


        //constructor
        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);

            //buscamos los widgets por su id accediendo por el itemview

            pictureCard = itemView.findViewById(R.id.cardProbeImage);
            userNameCard = itemView.findViewById(R.id.viewUserNameCard);
            timeCard = itemView.findViewById(R.id.viewTime);
            likeNumberCard = itemView.findViewById(R.id.viewCountLikes);


        }
    }


}
