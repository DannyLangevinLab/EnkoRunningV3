package com.example.dlangevin.enkorunningv2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Classe de l'Adaptateur
 */
public class TestRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

       //Déclaration du type du tableau
    List<String> contents;

    public TestRecyclerViewAdapter(List<String> contents) {
        this.contents = contents;
    }


    //Permet de retourner tous les items
    @Override
    public int getItemCount() {
        return contents.size();
    }

    //Prendre le layout List_item_card comme référence de la liste
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card, parent, false);
        return new RecyclerView.ViewHolder(view) {
            
        };
    }


    //d'apres les infos que j'ai pu voir ce serait par ici que le s
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }


}