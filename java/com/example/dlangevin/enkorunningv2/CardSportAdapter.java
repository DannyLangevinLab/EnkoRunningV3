package com.example.dlangevin.enkorunningv2;

/**
 * Created by d.langevin on 15/03/2016.
 */

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
public class CardSportAdapter extends RecyclerView.Adapter<CardSportAdapter.ViewHolder>{
    List<Choix> mItems;
    /**TABLEAUX**/
    public CardSportAdapter(List<String> mItems) {
        super();
        this.mItems = new ArrayList<Choix>();

        Choix choix = new Choix();/**CREER UN NOUVEL OBJET **/
        choix.setName("Nouveau Parcours");/**DONNER UN TITRE**/
        choix.setThumbnail(R.drawable.btnnouveauparcours);/**METTRE UN LOGO**/
        this.mItems.add(choix);/**AJOUTER AU TABLEAU**/

        choix = new Choix();
        choix.setName("Les plus efficaces en consommations de Calories");/**DONNER UN TITRE**/
        choix.setThumbnail(R.drawable.btncalories);/**METTRE UN LOGO**/
        this.mItems.add(choix);/**AJOUTER AU TABLEAU**/

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
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
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
                            Intent intent1 = new Intent(context, InterfaceNvoParcours.class);
                            context.startActivity(intent1);
                            break;
                        case 2:
                            Intent intent = new Intent(context, InterfaceCaloriesSport.class);
                            context.startActivity(intent);
                            break;
                        case 3:
                            Intent intent3 = new Intent(context, InterfacePlussoupleSport.class);
                            context.startActivity(intent3);
                            break;
                        case 4:
                            Intent intent4 = new Intent(context, InterfaceDifficilesSport.class);
                            context.startActivity(intent4);
                            break;
                        case 5:
                            Intent intent5 = new Intent(context, InterfaceRecommandationsSport.class);
                            context.startActivity(intent5);
                            break;
                        case 6:
                            Intent intent6 = new Intent(context, InterfaceCourbesSport.class);
                            context.startActivity(intent6);
                            break;
                        case 7:
                            Intent intent7 = new Intent(context, InterfaceTempscoursesSport.class);
                            context.startActivity(intent7);
                            break;
                    }

                }
            });
        }

    }

}