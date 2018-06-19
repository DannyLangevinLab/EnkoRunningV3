package com.example.dlangevin.enkorunningv2;

/****/

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

/**
 * Created by d.langevin on 15/03/2016.
 */
public class CardPartagerAdapter extends RecyclerView.Adapter<CardPartagerAdapter.ViewHolder>{
    List<Choix> mItems;
    /**TABLEAU DES ONGLETS**/
    public CardPartagerAdapter(List<String> mItems) {
        super();
        this.mItems = new ArrayList<Choix>();
        Choix choix = new Choix();/**CREER UN NOUVEL OBJET**/
        choix.setName("Les plus Courants");/**DONNER UN TITRE AU ONGLET**/
        choix.setThumbnail(R.drawable.itempluscourants);/**LOGO DES ONGLETS**/
        this.mItems.add(choix);/**AJOUTER CET OBJET AU TABLEAU**/

        choix = new Choix();
        choix.setName("Les plus Rapides");
        choix.setThumbnail(R.drawable.itemplusrapides);
        this.mItems.add(choix);

        choix = new Choix();
        choix.setName("Les plus Prisés");
        choix.setThumbnail(R.drawable.itemplusprises);
        this.mItems.add(choix);

        choix = new Choix();
        choix.setName("Les Classements");
        choix.setThumbnail(R.drawable.itemclassement);
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
    /**APPELER LE LAYOUT LIST_ITEM_CARD POUR AVOIR LE MODEL DE CHAQUE CARD**/
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override/***RECUPERER LA POSITION DU CLIQUE*/
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

        /**LES DIFFERENTS CHEMINS DE RENVOIT APRES CLIQUE**/
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

                    switch ( position){

                        case 1:
                            Intent intent1 = new Intent(context, InterfacePlusCourants.class);
                            context.startActivity(intent1);
                            break;
                        case 2:
                            Intent intent = new Intent(context, InterfacePlusRapides.class);
                            context.startActivity(intent);
                            break;
                        case 3:
                            Intent intent3 = new Intent(context, InterfacePlusPrises.class);
                            context.startActivity(intent3);
                            break;
                        case 4:
                            Intent intent4 = new Intent(context, InterfaceClassements.class);
                            context.startActivity(intent4);
                            break;
                        case 5:
                            Intent intent5 = new Intent(context, InterfaceCourbesPartager.class);
                            context.startActivity(intent5);
                            break;
                        case 6:
                            Intent intent6 = new Intent(context, InterfaceTempscoursesPartager.class);
                            context.startActivity(intent6);
                            break;
                    }

                }
            });
        }

    }

}