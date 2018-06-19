package com.example.dlangevin.enkorunningv2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ${Danny} on ${aujourdhui}.
 */
public class InterfaceDrawerDroit extends AppCompatActivity {
    private ImageButton retoursport;
    Handler handler = new Handler();
    private int counter = 0;
    TextView compteur_calorie,compteur_amorti,compteur_economie;
    LinearLayout partager,stats,courbes;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_droit);
        retoursport= (ImageButton) findViewById(R.id.retoursport);
        retoursport.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton

        compteur_calorie= (TextView) findViewById(R.id.compteur_calories);
        compteur_amorti= (TextView) findViewById(R.id.compteur_amortis);
        compteur_economie= (TextView) findViewById(R.id.compteur_economie);
        partager= (LinearLayout) findViewById(R.id.partager);
        stats= (LinearLayout) findViewById(R.id.stats);
        courbes= (LinearLayout) findViewById(R.id.courbes);
       partager.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        stats.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        courbes.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        //compteur qui s'incrémente
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (++counter < 10000) {
                    handler.postDelayed(this, 1000L);
                    compteur_calorie.setText(counter + "  " + "Cal");
                    return;
                }

                handler.removeCallbacks(this);
            }
        }, 1000L);
        //compteur qui s'incrémente
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (++counter < 10000) {
                    handler.postDelayed(this, 1000L);
                    compteur_amorti.setText(counter + "  " + "Kg");
                    return;
                }

                handler.removeCallbacks(this);
            }
        }, 1000L);
        //compteur qui s'incrémente
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (++counter < 10000) {
                    handler.postDelayed(this, 1000L);
                    compteur_economie.setText(counter + "  " + "%");
                    return;
                }

                handler.removeCallbacks(this);
            }
        }, 1000L);

    }




    private class buttoncliquer implements Button.OnClickListener {

        @Override
        public void onClick(View v) {


            if (v == retoursport) {
                InterfaceDrawerDroit.this.finish();
                System.exit(0);
            }
            if (v == partager) {

                Intent ouverture10 = new Intent(getApplicationContext(), InterfaceProfil.class);
                startActivity(ouverture10);
            }
            if (v == stats) {
                Intent ouverture10 = new Intent(getApplicationContext(), InterfacePlussoupleStatistiques.class);
                startActivity(ouverture10);
            }
            if (v == courbes) {
                Intent ouverture2 = new Intent(getApplicationContext(),InterfaceCourbes.class);
                startActivity(ouverture2);
            }
        }
    }



}