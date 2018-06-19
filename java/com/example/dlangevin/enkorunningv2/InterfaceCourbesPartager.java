package com.example.dlangevin.enkorunningv2;

/**
 * Created by d.langevin on 15/03/2016.
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.GraphViewXML;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;

/**
 * Provides UI for the Detail page with Collapsing Toolbar.
 */
public class InterfaceCourbesPartager extends AppCompatActivity {
    private ImageButton retoursport;
    private LinearLayout btn_economie;
    private LinearLayout btn_distance;
    private LinearLayout btn_vitesse;
    private LinearLayout btn_energie;
    private LinearLayout btn_total;
    private ImageView total_courbes;
    private GraphViewXML grapheconomie;
    private GraphViewXML graphdistance;
    private GraphViewXML graphvitesse;
    private GraphViewXML graphenergie;
    private ImageButton btn_drawer2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_courbes_partager);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        collapsingToolbar.setTitle(getString(R.string.item_title));
        retoursport = (ImageButton) findViewById(R.id.retoursport);
        retoursport.setOnClickListener(new buttoncliquer());

        btn_economie = (LinearLayout) findViewById(R.id.btn_economie);
        btn_economie.setOnClickListener(new buttoncliquer());
        btn_distance = (LinearLayout) findViewById(R.id.btn_distance);
        btn_distance.setOnClickListener(new buttoncliquer());
        btn_vitesse = (LinearLayout) findViewById(R.id.btn_vitesse);
        btn_vitesse.setOnClickListener(new buttoncliquer());
        btn_energie = (LinearLayout) findViewById(R.id.btn_energie);
        btn_energie.setOnClickListener(new buttoncliquer());
        btn_total = (LinearLayout) findViewById(R.id.btn_total);
        btn_total.setOnClickListener(new buttoncliquer());

        graphdistance = (GraphViewXML) findViewById(R.id.graphdistance);
        grapheconomie = (GraphViewXML) findViewById(R.id.grapheconomie);
        graphvitesse = (GraphViewXML) findViewById(R.id.graphvitesse);
        graphenergie = (GraphViewXML) findViewById(R.id.graphenergie);
        total_courbes = (ImageView) findViewById(R.id.total_courbes);
        btn_drawer2 = (ImageButton) findViewById(R.id.btn_drawer2);
        btn_drawer2.setOnClickListener(new buttoncliquer());
        //legende en bas
        graphdistance.getLegendRenderer().setVisible(true);
        graphdistance.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);
        grapheconomie.getLegendRenderer().setVisible(true);
        grapheconomie.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);
        graphvitesse.getLegendRenderer().setVisible(true);
        graphvitesse.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);
        graphenergie.getLegendRenderer().setVisible(true);
        graphenergie.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);


        //montrer les données

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(grapheconomie);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"1", "2", "3", "Amorti (bar)"});
        staticLabelsFormatter.setVerticalLabels(new String[]{"0", "10", "50", "100", "500", "1000", "Metres"});
        grapheconomie.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        grapheconomie.getGridLabelRenderer().setVerticalLabelsColor(Color.BLACK);
        grapheconomie.getGridLabelRenderer().setHorizontalLabelsColor(Color.BLACK);


        staticLabelsFormatter = new StaticLabelsFormatter(graphdistance);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"0", "30", "60", "Minutes"});
        staticLabelsFormatter.setVerticalLabels(new String[]{"10", "50", "100", "500", "1000", "Metres Sup"});
        graphdistance.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        graphdistance.getGridLabelRenderer().setVerticalLabelsColor(Color.BLACK);
        graphdistance.getGridLabelRenderer().setHorizontalLabelsColor(Color.BLACK);

        staticLabelsFormatter = new StaticLabelsFormatter(graphvitesse);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"0", "500", "60", "Mn"});
        staticLabelsFormatter.setVerticalLabels(new String[]{"10", "50", "100", "500", "1000", "Metres"});
        graphvitesse.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        graphvitesse.getGridLabelRenderer().setVerticalLabelsColor(Color.BLACK);
        graphvitesse.getGridLabelRenderer().setHorizontalLabelsColor(Color.BLACK);

        staticLabelsFormatter = new StaticLabelsFormatter(graphenergie);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"10", "50", "100", "500", "1000", "Metres"});
        staticLabelsFormatter.setVerticalLabels(new String[]{"0", "5", "10", "15", "20", "Kjoules"});
        graphenergie.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        graphenergie.getGridLabelRenderer().setVerticalLabelsColor(Color.BLACK);
        graphenergie.getGridLabelRenderer().setHorizontalLabelsColor(Color.BLACK);

    }
    /**METHODE POUR RECUPERER LE CLIQUE D'UN BOUTON */
    private class buttoncliquer implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == retoursport) {
               InterfaceCourbesPartager.this.finish();
                System.exit(0);
            }
            if (v== btn_drawer2){
                Intent ouverture0 = new Intent(getApplicationContext(), InterfaceDrawerDroit.class);
                startActivity(ouverture0);
            }

            if (v == btn_economie) {
                grapheconomie.setVisibility(View.VISIBLE);
                graphdistance.setVisibility(View.GONE);
                graphvitesse.setVisibility(View.GONE);
                graphenergie.setVisibility(View.GONE);
                total_courbes.setVisibility(View.GONE);
            }
            if (v == btn_distance) {
                grapheconomie.setVisibility(View.GONE);
                graphdistance.setVisibility(View.VISIBLE);
                graphvitesse.setVisibility(View.GONE);
                graphenergie.setVisibility(View.GONE);
                total_courbes.setVisibility(View.GONE);
            }
            if (v == btn_vitesse) {
                grapheconomie.setVisibility(View.GONE);
                graphdistance.setVisibility(View.GONE);
                graphvitesse.setVisibility(View.VISIBLE);
                graphenergie.setVisibility(View.GONE);
                total_courbes.setVisibility(View.GONE);
            }
            if (v == btn_energie) {
                grapheconomie.setVisibility(View.GONE);
                graphdistance.setVisibility(View.GONE);
                graphvitesse.setVisibility(View.GONE);
                graphenergie.setVisibility(View.VISIBLE);
                total_courbes.setVisibility(View.GONE);

            }
            if (v == btn_total) {
                total_courbes.setVisibility(View.VISIBLE);
                graphenergie.setVisibility(View.GONE);
                grapheconomie.setVisibility(View.GONE);
                graphdistance.setVisibility(View.GONE);
                graphvitesse.setVisibility(View.GONE);
            }



        }
    }
}
