package com.example.dlangevin.enkorunningv2;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui gere le RecyclerView
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;


    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);


        //permet un affichage sous forme liste verticale
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        //Création du contenu dans cette configuration ce matérialise sur tous les onglets,
        // ce tableau est aussi déclarer dans le fichier

        List<String> mItems = new ArrayList<>();



        //penser à passer notre Adapter (ici : TestRecyclerViewAdapter) à un RecyclerViewMaterialAdapter
        mAdapter = new RecyclerViewMaterialAdapter(new CardAdapter(mItems));
        mRecyclerView.setAdapter(mAdapter);



        //notifier le MaterialViewPager qu'on va utiliser une RecyclerView
        MaterialViewPagerHelper.registerRecyclerView(getActivity(), mRecyclerView, null);
    }


    public static void add(int materialViewPager, RecyclerViewFragment fragment) {

    }
}