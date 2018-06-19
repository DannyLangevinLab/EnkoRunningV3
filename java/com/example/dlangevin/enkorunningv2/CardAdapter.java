package com.example.dlangevin.enkorunningv2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*ADAPTATEUR POUR AFFICHER LES CARDVIEWS DE LA PAGE SANTE**/
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    List<Choix> mItems;

    /**TABLEAU AVEC TOUS LES ITEMS DE LA PAGE*/
    public CardAdapter(List<String> mItems) {
        super();
        this.mItems = new ArrayList<Choix>();
        Choix choix = new Choix();
        choix = new Choix();/**CREER UN NOUVEL OBJET DU TABLEAU*/
        choix.setName("Les plus efficaces en consommations de Calories");/* TITRE**/
        choix.setThumbnail(R.drawable.btncalories);/**LOGO */
        this.mItems.add(choix);/**AJOUTER AU TABLEAU CHOIX*/

        choix = new Choix();
        choix.setName("Les plus Souples");
        choix.setThumbnail(R.drawable.fragmentsouples);
        this.mItems.add(choix);

        choix = new Choix();
        choix.setName("Les plus Difficiles");
        choix.setThumbnail(R.drawable.fragmentdifficiles);
        this.mItems.add(choix);

        choix = new Choix();
        choix.setName("Les Recommandations");
        choix.setThumbnail(R.drawable.fragmentrecommandations);
        this.mItems.add(choix);

        choix = new Choix();
        choix.setName("Les Courbes d'Utilisations");
        choix.setThumbnail(R.drawable.fragmentcourbes);
        this.mItems.add(choix);

        choix = new Choix();
        choix.setName("Les Temps de Courses");
        choix.setThumbnail(R.drawable.fragmenttemps);
        this.mItems.add(choix);
    }

    @Override
    /**RECUPERER LE MODEL LAYOUT_LIST_ITEM_CARD POUR UNIFIER TOUTES LES CARDS*/
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    /*POUR DISPOSER D1 ITEM D1 LOGO ET D1 TEXTE POUR CHAQUE CARD**/
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Choix choix = mItems.get(i);
        viewHolder.tvMovie.setText(choix.getName());
        viewHolder.imgThumbnail.setImageResource(choix.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgThumbnail;
        public TextView tvMovie;
        /*METHODE POUR RECUPERER LA POSITION DU CLIQUE SUR LES CARDVIEWS**/
        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            tvMovie = (TextView) itemView.findViewById(R.id.tv_movie);
            itemView.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    Context context = v.getContext();

                    /**LES DIFFERENTS CHEMINS OU RENVOIENT LES CARDVIEWS*/
                   switch ( position){

                       case 1:
                           Intent intent1 = new Intent(context, InterfaceCalories.class);
                           context.startActivity(intent1);

                           break;
                       case 2:
                           Intent intent = new Intent(context, InterfacePlussouple.class);
                           context.startActivity(intent);
                           break;
                       case 3:
                           Intent intent3 = new Intent(context, InterfaceDifficiles.class);
                           context.startActivity(intent3);
                           break;
                       case 4:
                           Intent intent4 = new Intent(context, InterfaceRecommandations.class);
                           context.startActivity(intent4);
                           break;
                       case 5:
                           Intent intent5 = new Intent(context, InterfaceCourbes.class);
                           context.startActivity(intent5);
                           System.exit(0);
                           break;
                       case 6:
                           Intent intent6 = new Intent(context, InterfaceTempscourses.class);
                           context.startActivity(intent6);
                           break;
                   }

                }
            });
        }

    }

}
