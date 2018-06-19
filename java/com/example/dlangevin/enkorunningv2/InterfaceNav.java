package com.example.dlangevin.enkorunningv2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class InterfaceNav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    // declarations des boutons de l'accueil et des linear layout a utilisés dans les méthodes
    private ImageButton sante;
    private ImageButton sport;
    private ImageButton partager;
    private ImageButton btn_progression0;
    private ImageButton btn_progression1;
    private ImageButton btn_progression2;
    private ImageButton btn_progression3;
    private ImageButton btn_progression4;
    private ImageButton btn_progression5;
    private Button btn_drawer2;

    private LinearLayout trianglesanterouge;
    private LinearLayout encartsportnoir;
    private LinearLayout encartpartagernoir;

    Handler handler = new Handler();
    private int counter = 0;

    SeekBar seekBar2;


    TextView nav_settings,nav_logout,nav_about,nav_help,compteur_eco,compteur_calories;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_nav);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);



       btn_drawer2= (Button) findViewById(R.id.btn_drawer2);
       btn_drawer2.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton

        // pour lier un bouton a une activite
        sante = (ImageButton) findViewById(R.id.sante);
        sante.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        sport = (ImageButton) findViewById(R.id.sport);
        sport.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        partager = (ImageButton) findViewById(R.id.partager);
        partager.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        btn_progression0 = (ImageButton) findViewById(R.id.btn_progression0);
        btn_progression0.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        btn_progression1 = (ImageButton) findViewById(R.id.btn_progression1);
        btn_progression1.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        btn_progression2 = (ImageButton) findViewById(R.id.btn_progression2);
        btn_progression2.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        btn_progression3 = (ImageButton) findViewById(R.id.btn_progression3);
        btn_progression3.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        btn_progression4 = (ImageButton) findViewById(R.id.btn_progression4);
        btn_progression4.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        btn_progression5 = (ImageButton) findViewById(R.id.btn_progression5);
        btn_progression5.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);




        // Declaration du triangle rose
        trianglesanterouge = (LinearLayout) findViewById(R.id.trianglesanterouge);
        encartsportnoir = (LinearLayout) findViewById(R.id.encartsportnoir);
        encartsportnoir.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton
        encartpartagernoir = (LinearLayout) findViewById(R.id.encartpartagernoir);
        encartpartagernoir.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton





//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });





        // encart du menu coulissant
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);

        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        NavigationView rightNavigationView = (NavigationView) findViewById(R.id.nav_right_view);

        rightNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle Right navigation view item clicks here.
                int id = item.getItemId();
                if (id == R.id.nav_partager) {
                    Intent ouverture10 = new Intent(getApplicationContext(), InterfaceProfil.class);
                    startActivity(ouverture10);
                }
                if (id == R.id.stats) {
                    Intent ouverture10 = new Intent(getApplicationContext(), InterfaceCourbesStatistiques.class);
                    startActivity(ouverture10);
                }
                if (id == R.id.courbes) {
                    Intent ouverture10 = new Intent(getApplicationContext(), InterfaceCourbes.class);
                    startActivity(ouverture10);
                }
                if (id == R.id.nav_trajet) {

                }

                drawer.openDrawer(GravityCompat.END);
                drawer.closeDrawer(GravityCompat.END); /*Important Line*/
                return true;
            }
        });
//COMPTE REBOURS CALORIES ITEM///
        final TextView calories = (TextView) MenuItemCompat.getActionView(rightNavigationView.getMenu().findItem(R.id.nav_calories));
        calories.setText("200" + " " + "Cal");
       //compteur qui s'incrémente
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (++counter < 1000) {
                    handler.postDelayed(this, 1000L);
                    calories.setText(counter + "" + "Cal");
                    return;
                }

                handler.removeCallbacks(this);
            }
        }, 1000L);

        //COMPTE REBOURS AMORTI ITEM///
        final TextView amorti = (TextView) MenuItemCompat.getActionView( rightNavigationView.getMenu().findItem(R.id.nav_amorti));
        seekBar2.setEnabled(false);
        //compteur qui s'incrémente
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (++counter < 60) {
                    handler.postDelayed(this, 1000L);
                    amorti.setText(counter + "" + "Kg");
                    return;
                }

                handler.removeCallbacks(this);
            }
        }, 1000L);
        //COMPTE REBOURS ECONOMIE ARTICULAIRE ITEM///
        final TextView eco = (TextView) MenuItemCompat.getActionView( rightNavigationView.getMenu().findItem(R.id.nav_articulation));
        seekBar2.setEnabled(false);
        //compteur qui s'incrémente
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (++counter < 50) {
                    handler.postDelayed(this, 1000L);
                    eco.setText(counter + "" + "%");
                    return;
                }

                handler.removeCallbacks(this);
            }
        }, 1000L);

        // ITEM TRAJET
        final TextView trajet = (TextView) MenuItemCompat.getActionView( rightNavigationView.getMenu().findItem(R.id.nav_trajet));
        trajet.setText(" " + "20 Km/2h20");

    }



        // Classe pour renvoyer le click d'un bouton vers une activite
    private class buttoncliquer implements Button.OnClickListener {

        @Override
        public void onClick(View v) {

            if (v== btn_drawer2){
                if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                   drawer.closeDrawer(Gravity.RIGHT);
                } else {
                    drawer.openDrawer(Gravity.RIGHT);
                }

            }

            if (v == sante) {
                Intent ouverture1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ouverture1);
                trianglesanterouge.setVisibility(View.VISIBLE);
                encartsportnoir.setVisibility(View.GONE);
                encartpartagernoir.setVisibility(View.GONE);
                System.exit(0);


            }
            if (v == sport) {
                Intent ouverture2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ouverture2);
                trianglesanterouge.setVisibility(View.GONE);
                encartsportnoir.setVisibility(View.VISIBLE);
                encartpartagernoir.setVisibility(View.GONE);
                System.exit(0);


            }

            if (v == partager) {
                Intent ouverture3 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ouverture3);
                trianglesanterouge.setVisibility(View.GONE);
                encartsportnoir.setVisibility(View.GONE);
                encartpartagernoir.setVisibility(View.VISIBLE);
                encartsportnoir.setVisibility(View.GONE);
                System.exit(0);


            }
            if (v == trianglesanterouge) {
                trianglesanterouge.setVisibility(View.GONE);
                encartsportnoir.setVisibility(View.GONE);
            }
            if (v == encartsportnoir) {
                Intent ouverture4 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ouverture4);
                trianglesanterouge.setVisibility(View.GONE);
                sport.setVisibility(View.GONE);

            }
            if (v == encartpartagernoir) {
                trianglesanterouge.setVisibility(View.GONE);
                encartsportnoir.setVisibility(View.GONE);
                encartpartagernoir.setVisibility(View.GONE);
                Intent ouverture5 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ouverture5);


            }
            if (v.equals(btn_progression0)) {

            btn_progression0.setBackgroundResource(R.drawable.thumb_cliquer);
                seekBar2.setProgress(seekBar2.getMax()*0);
                btn_progression1.setBackgroundResource(R.drawable.thumb_image);
                btn_progression5.setBackgroundResource(R.drawable.thumb_image);
                btn_progression2.setBackgroundResource(R.drawable.thumb_image);
                btn_progression3.setBackgroundResource(R.drawable.thumb_image);
                btn_progression4.setBackgroundResource(R.drawable.thumb_image);
        }
            if (v.equals(btn_progression1)) {
                btn_progression1.setBackgroundResource(R.drawable.thumb_cliquer);
                btn_progression0.setBackgroundResource(R.drawable.thumb_cliquer);
                seekBar2.setProgress(seekBar2.getMax() / 5);
                btn_progression5.setBackgroundResource(R.drawable.thumb_image);
                btn_progression2.setBackgroundResource(R.drawable.thumb_image);
                btn_progression3.setBackgroundResource(R.drawable.thumb_image);
                btn_progression4.setBackgroundResource(R.drawable.thumb_image);

            }
            if (v.equals(btn_progression2)) {
                btn_progression0.setBackgroundResource(R.drawable.thumb_cliquer);
                btn_progression5.setBackgroundResource(R.drawable.thumb_image);
                btn_progression3.setBackgroundResource(R.drawable.thumb_image);
                btn_progression4.setBackgroundResource(R.drawable.thumb_image);
                btn_progression2.setBackgroundResource(R.drawable.thumb_cliquer);
                seekBar2.setProgress(seekBar2.getMax() * 2 / 5);
                btn_progression1.setBackgroundResource(R.drawable.thumb_cliquer);


            }
            if (v.equals(btn_progression3)) {
                btn_progression0.setBackgroundResource(R.drawable.thumb_cliquer);
                btn_progression5.setBackgroundResource(R.drawable.thumb_image);
                btn_progression4.setBackgroundResource(R.drawable.thumb_image);
                btn_progression3.setBackgroundResource(R.drawable.thumb_cliquer);
                seekBar2.setProgress(seekBar2.getMax() * 3 / 5);
                btn_progression1.setBackgroundResource(R.drawable.thumb_cliquer);
                btn_progression2.setBackgroundResource(R.drawable.thumb_cliquer);

            }
            if (v.equals(btn_progression4)) {
                btn_progression0.setBackgroundResource(R.drawable.thumb_cliquer);
                btn_progression5.setBackgroundResource(R.drawable.thumb_image);
                btn_progression4.setBackgroundResource(R.drawable.thumb_cliquer);
                seekBar2.setProgress(seekBar2.getMax() * 4 / 5);
                btn_progression1.setBackgroundResource(R.drawable.thumb_cliquer);
                btn_progression2.setBackgroundResource(R.drawable.thumb_cliquer);
                btn_progression3.setBackgroundResource(R.drawable.thumb_cliquer);
            }
            if (v.equals(btn_progression5)) {
                btn_progression0.setBackgroundResource(R.drawable.thumb_cliquer);
                btn_progression5.setBackgroundResource(R.drawable.thumb_cliquer);
                btn_progression1.setBackgroundResource(R.drawable.thumb_cliquer);
                btn_progression2.setBackgroundResource(R.drawable.thumb_cliquer);
                btn_progression3.setBackgroundResource(R.drawable.thumb_cliquer);
                btn_progression4.setBackgroundResource(R.drawable.thumb_cliquer);
                seekBar2.setProgress(seekBar2.getMax());

            }


        }


    }


    

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // boutons de la barre de menu coulissant
        int id = item.getItemId();

        if (id == R.id.nav_profil) {
            Intent ouverture7 = new Intent(getApplicationContext(), InterfaceProfil.class);
            startActivity(ouverture7);
            System.exit(0);
            // Handle the camera action
        } else if (id == R.id.nav_stats) {
            Intent ouverture5 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(ouverture5);
            System.exit(0);
        } else if (id == R.id.nav_param) {
            Intent ouverture6 = new Intent(getApplicationContext(), InterfaceParametre.class);
            startActivity(ouverture6);
            System.exit(0);
        } else if (id == R.id.nav_deco) {
        }
        else if (id== R.id.nav_trajet) {
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
