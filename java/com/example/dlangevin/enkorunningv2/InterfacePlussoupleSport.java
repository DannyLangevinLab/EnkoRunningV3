package com.example.dlangevin.enkorunningv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class InterfacePlussoupleSport extends AppCompatActivity
{
    private ImageButton retoursport;
    private ImageButton btn_drawer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_plussouple_sport);

        retoursport = (ImageButton) findViewById(R.id.retoursport);
        retoursport.setOnClickListener(new buttoncliquer());
        btn_drawer2 = (ImageButton) findViewById(R.id.btn_drawer2);
        btn_drawer2.setOnClickListener(new buttoncliquer());
    }

    /**METHODE POUR RECUPERER LE CLIQUE D'UN BOUTON */
    private class buttoncliquer implements Button.OnClickListener {

        @Override
        public void onClick(View v) {


            if (v == retoursport) {
                InterfacePlussoupleSport.this.finish();
            }
            if (v== btn_drawer2){
                Intent ouverture0 = new Intent(getApplicationContext(), InterfaceDrawerDroit.class);
                startActivity(ouverture0);
            }
        }
    }



}
