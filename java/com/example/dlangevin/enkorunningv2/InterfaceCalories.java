package com.example.dlangevin.enkorunningv2;

/**
 * Created by d.langevin on 17/03/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Provides UI for the Detail page with Collapsing Toolbar.
 */
public class InterfaceCalories extends AppCompatActivity {
    private ImageButton retoursport;
    private ImageButton btn_drawer2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_consocalories);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        collapsingToolbar.setTitle(getString(R.string.item_title));
        retoursport = (ImageButton) findViewById(R.id.retoursport);
        retoursport.setOnClickListener(new buttoncliquer());
        btn_drawer2 = (ImageButton) findViewById(R.id.btn_drawer2);
        btn_drawer2.setOnClickListener(new buttoncliquer());
    }


    private class buttoncliquer implements Button.OnClickListener {

        @Override
        public void onClick(View v) {


            if (v == retoursport) {
                InterfaceCalories.this.finish();
                System.exit(0);
            }
            if (v== btn_drawer2){
                Intent ouverture0 = new Intent(getApplicationContext(), InterfaceDrawerDroit.class);
                startActivity(ouverture0);
                InterfaceCalories.this.finish();
                System.exit(0);
            }

        }
    }
}
