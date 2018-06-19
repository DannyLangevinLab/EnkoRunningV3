package com.example.dlangevin.enkorunningv2;

/**
 * Created by d.langevin on 15/03/2016.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class InterfaceParametre extends AppCompatActivity
{
    private ImageButton retoursport;
    private Button btn_couleur1;
    private Button btn_couleur2;
    private Button btn_couleur3;
    private Button btn_couleur4;
    private Button btn_couleur5;
    private Button btn_couleur1cliquer;
    private Button btn_couleur2cliquer;
    private Button btn_couleur3cliquer;
    private Button btn_couleur4cliquer;
    private Button btn_couleur5cliquer;
//bar de progresse niveau
    private ImageButton  btn_progression1;
    private ImageButton  btn_progression2;
    private ImageButton  btn_progression3;
    private ImageButton  btn_progression1cliquer;
    private ImageButton  btn_progression2cliquer;
    private ImageButton  btn_progression3cliquer;
    SeekBar seekBar3;
    //barre de progresse Objectif
    private ImageButton  btn_objectif1;
    private ImageButton  btn_objectif2;
    private ImageButton  btn_objectif3;
    private ImageButton  btn_objectif1cliquer;
    private ImageButton  btn_objectif2cliquer;
    private ImageButton  btn_objectif3cliquer;
    SeekBar seekBarObjectifs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_parametre);

        retoursport = (ImageButton) findViewById(R.id.retoursport);
        retoursport.setOnClickListener(new buttoncliquer());
        //Boutons barre du bas
        btn_couleur1 = (Button) findViewById(R.id.btn_couleur1);
        btn_couleur1.setOnClickListener(new buttoncliquer());
        btn_couleur2 = (Button) findViewById(R.id.btn_couleur2);
        btn_couleur2.setOnClickListener(new buttoncliquer());
        btn_couleur3 = (Button) findViewById(R.id.btn_couleur3);
        btn_couleur3.setOnClickListener(new buttoncliquer());
        btn_couleur4 = (Button) findViewById(R.id.btn_couleur4);
        btn_couleur4.setOnClickListener(new buttoncliquer());
        btn_couleur5 = (Button) findViewById(R.id.btn_couleur5);
        btn_couleur5.setOnClickListener(new buttoncliquer());
//btn seekbar Niveau
        btn_progression1 = (ImageButton) findViewById(R.id.btn_progression1);
        btn_progression1.setOnClickListener(new buttoncliquer());
        btn_progression2 = (ImageButton) findViewById(R.id.btn_progression2);
        btn_progression2.setOnClickListener(new buttoncliquer());
        btn_progression3 = (ImageButton) findViewById(R.id.btn_progression3);
        btn_progression3.setOnClickListener(new buttoncliquer());
//btn seekbar Objectifs
        btn_objectif1 = (ImageButton) findViewById(R.id.btn_objectif1);
        btn_objectif1.setOnClickListener(new buttoncliquer());
        btn_objectif2 = (ImageButton) findViewById(R.id.btn_objectif2);
        btn_objectif2.setOnClickListener(new buttoncliquer());
        btn_objectif3 = (ImageButton) findViewById(R.id.btn_objectif3);
        btn_objectif3.setOnClickListener(new buttoncliquer());

        btn_couleur1cliquer = (Button) findViewById(R.id.btn_couleur1cliquer);
        btn_couleur1cliquer.setOnClickListener(new buttoncliquer());
        btn_couleur2cliquer = (Button) findViewById(R.id.btn_couleur2cliquer);
        btn_couleur2cliquer.setOnClickListener(new buttoncliquer());
        btn_couleur3cliquer = (Button) findViewById(R.id.btn_couleur3cliquer);
        btn_couleur3cliquer.setOnClickListener(new buttoncliquer());
        btn_couleur4cliquer = (Button) findViewById(R.id.btn_couleur4cliquer);
        btn_couleur4cliquer.setOnClickListener(new buttoncliquer());
        btn_couleur5cliquer = (Button) findViewById(R.id.btn_couleur5cliquer);
        btn_couleur5cliquer.setOnClickListener(new buttoncliquer());
//btn colorés seekbar Niveau
        btn_progression1cliquer = (ImageButton) findViewById(R.id.btn_progression1cliquer);
        btn_progression1cliquer.setOnClickListener(new buttoncliquer());
        btn_progression2cliquer = (ImageButton) findViewById(R.id.btn_progression2cliquer);
        btn_progression2cliquer.setOnClickListener(new buttoncliquer());
        btn_progression3cliquer = (ImageButton) findViewById(R.id.btn_progression3cliquer);
        btn_progression3cliquer.setOnClickListener(new buttoncliquer());
        //btn colorés seekbar Objectifs
        btn_objectif1cliquer = (ImageButton) findViewById(R.id.btn_objectif1cliquer);
        btn_objectif1cliquer.setOnClickListener(new buttoncliquer());
        btn_objectif2cliquer = (ImageButton) findViewById(R.id.btn_objectif2cliquer);
        btn_objectif2cliquer.setOnClickListener(new buttoncliquer());
        btn_objectif3cliquer = (ImageButton) findViewById(R.id.btn_objectif3cliquer);
        btn_objectif3cliquer.setOnClickListener(new buttoncliquer());

        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
seekBar3.setEnabled(false);
    }

    /**METHODE POUR RECUPERER LE CLIQUE D'UN BOUTON */
    private class buttoncliquer implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v == retoursport) {
                InterfaceParametre.this.finish();
            }
            if (v == btn_couleur1) {
                btn_couleur1cliquer.setVisibility(View.VISIBLE);
                btn_couleur2cliquer.setVisibility(View.GONE);
                btn_couleur3cliquer.setVisibility(View.GONE);
                btn_couleur4cliquer.setVisibility(View.GONE);
                btn_couleur5cliquer.setVisibility(View.GONE);
                btn_couleur1.setVisibility(View.GONE);
                btn_couleur2.setVisibility(View.VISIBLE);
                btn_couleur3.setVisibility(View.VISIBLE);
                btn_couleur4.setVisibility(View.VISIBLE);
                btn_couleur5.setVisibility(View.VISIBLE);
            }
            if (v == btn_couleur2) {
                btn_couleur1cliquer.setVisibility(View.GONE);
                btn_couleur2cliquer.setVisibility(View.VISIBLE);
                btn_couleur3cliquer.setVisibility(View.GONE);
                btn_couleur4cliquer.setVisibility(View.GONE);
                btn_couleur5cliquer.setVisibility(View.GONE);

                btn_couleur1.setVisibility(View.VISIBLE);
                btn_couleur2.setVisibility(View.GONE);
                btn_couleur3.setVisibility(View.VISIBLE);
                btn_couleur4.setVisibility(View.VISIBLE);
                btn_couleur5.setVisibility(View.VISIBLE);
            }
            if (v == btn_couleur3) {
                btn_couleur1cliquer.setVisibility(View.GONE);
                btn_couleur2cliquer.setVisibility(View.GONE);
                btn_couleur3cliquer.setVisibility(View.VISIBLE);
                btn_couleur4cliquer.setVisibility(View.GONE);
                btn_couleur5cliquer.setVisibility(View.GONE);

                btn_couleur1.setVisibility(View.VISIBLE);
                btn_couleur2.setVisibility(View.VISIBLE);
                btn_couleur3.setVisibility(View.GONE);
                btn_couleur4.setVisibility(View.VISIBLE);
                btn_couleur5.setVisibility(View.VISIBLE);
            }
            if (v == btn_couleur4) {
                btn_couleur1cliquer.setVisibility(View.GONE);
                btn_couleur2cliquer.setVisibility(View.GONE);
                btn_couleur3cliquer.setVisibility(View.GONE);
                btn_couleur4cliquer.setVisibility(View.VISIBLE);
                btn_couleur5cliquer.setVisibility(View.GONE);

                btn_couleur1.setVisibility(View.VISIBLE);
                btn_couleur2.setVisibility(View.VISIBLE);
                btn_couleur3.setVisibility(View.VISIBLE);
                btn_couleur4.setVisibility(View.GONE);
                btn_couleur5.setVisibility(View.VISIBLE);
            }
            if (v == btn_couleur5) {
                btn_couleur1cliquer.setVisibility(View.GONE);
                btn_couleur2cliquer.setVisibility(View.GONE);
                btn_couleur3cliquer.setVisibility(View.GONE);
                btn_couleur4cliquer.setVisibility(View.GONE);
                btn_couleur5cliquer.setVisibility(View.VISIBLE);

                btn_couleur1.setVisibility(View.VISIBLE);
                btn_couleur2.setVisibility(View.VISIBLE);
                btn_couleur3.setVisibility(View.VISIBLE);
                btn_couleur4.setVisibility(View.VISIBLE);
                btn_couleur5.setVisibility(View.GONE);
            }

            if (v == btn_progression1) {
                btn_progression1cliquer.setVisibility(View.VISIBLE);
                btn_progression2cliquer.setVisibility(View.GONE);
                btn_progression3cliquer.setVisibility(View.GONE);
            }
            if (v == btn_progression2) {
                btn_progression1cliquer.setVisibility(View.GONE);
                btn_progression2cliquer.setVisibility(View.VISIBLE);
                btn_progression3cliquer.setVisibility(View.GONE);
            }
            if (v == btn_progression3) {
                btn_progression1cliquer.setVisibility(View.GONE);
                btn_progression2cliquer.setVisibility(View.GONE);
                btn_progression3cliquer.setVisibility(View.VISIBLE);
            }

//bar Objectifs
            if (v == btn_objectif1) {
                btn_objectif1cliquer.setVisibility(View.VISIBLE);
                btn_objectif2cliquer.setVisibility(View.GONE);
                btn_objectif3cliquer.setVisibility(View.GONE);
            }
            if (v == btn_objectif2) {
                btn_objectif1cliquer.setVisibility(View.GONE);
                btn_objectif2cliquer.setVisibility(View.VISIBLE);
                btn_objectif3cliquer.setVisibility(View.GONE);
            }
            if (v == btn_objectif3) {
                btn_objectif1cliquer.setVisibility(View.GONE);
                btn_objectif2cliquer.setVisibility(View.GONE);
                btn_objectif3cliquer.setVisibility(View.VISIBLE);
            }


        }
    }


}
