
package com.example.dlangevin.enkorunningv2;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/** */
    public class InterfaceClassementsStatistiques extends AppCompatActivity {
        private ImageButton retoursport;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_interface_lesclassements_statistiques);
            setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // Set Collapsing Toolbar layout to the screen
            CollapsingToolbarLayout collapsingToolbar =
                    (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
            // Set title of Detail page
            collapsingToolbar.setTitle(getString(R.string.item_title));
            retoursport = (ImageButton) findViewById(R.id.retoursport);
            retoursport.setOnClickListener(new buttoncliquer());
        }

    /**METHODE POUR RECUPERER LE CLIQUE D'UN BOUTON */
        private class buttoncliquer implements Button.OnClickListener {

            @Override
            public void onClick(View v) {


                if (v == retoursport) {
                    InterfaceClassementsStatistiques.this.finish();

                }

            }
        }
    }


