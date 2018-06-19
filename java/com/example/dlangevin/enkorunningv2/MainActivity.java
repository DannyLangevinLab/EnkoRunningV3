package com.example.dlangevin.enkorunningv2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.github.florent37.materialviewpager.MaterialViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MaterialViewPager materialViewPager;
    View headerLogo;
    ImageView headerLogoContent;
    private Toolbar mToolbar;
    private ImageButton btn_amorti_inactif;
    private ImageButton btn_economiearticulaire_inactif;
    private ImageButton btn_caloriesbrulees_inactif;
    private ImageButton btn_meilleurtrajet_inactif;
    private ImageButton btn_trajetmoyen_inactif;
    private ImageButton btn_meilleurtrajet_actif;
    private ImageButton btn_amorti_actif;
    private ImageButton btn_economiearticulaire_actif;
    private ImageButton btn_caloriesbrulees_actif;
    private ImageButton btn_trajetmoyen_actif;
    private ImageButton btn_indicateur;

    private RelativeLayout calories_cliquees;
    private RelativeLayout amorti_cliquee;
    private RelativeLayout ecoart_cliquee;
    private RelativeLayout trajet_cliquee;
    private RelativeLayout calories_noncliquees;
    private RelativeLayout amorti_noncliquee;
    private RelativeLayout ecoart_noncliquee;
    private RelativeLayout trajet_noncliquee;
    private Button btn_drawer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_drawer2= (Button) findViewById(R.id.btn_drawer2);
        btn_drawer2.setOnClickListener(new buttoncliquer());// Recupérer l'appui du bouton

//For Toolbar (Action bar) start
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.retourarriere);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ouverture4 = new Intent(getApplicationContext(), InterfaceNav.class);
                startActivity(ouverture4);
                System.exit(0);
            }
        });


        getSupportActionBar().setTitle("");
        //For Toolbar (Action bar) end

        //4 onglets
        final int tabCount = 4;

        //les vues définies dans @layout/header_logo
        headerLogo = findViewById(R.id.headerLogo);
        headerLogoContent = (ImageView) findViewById(R.id.headerLogoContent);

        //le MaterialViewPager
        this.materialViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        //remplir le ViewPager
        this.materialViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                //je créé pour chaque onglet un RecyclerViewFragment
                switch (position) {

                    case 0:
                        return RecyclerViewFragment.newInstance();
                    case 1:
                        return RecyclerViewFragmentSport.newInstance();
                    case 2:
                        return RecyclerViewFragmentPartager.newInstance();
                    case 3:
                        return RecyclerViewFragmentStatistiques.newInstance();

                    default:
                        return RecyclerViewFragment.newInstance();
                }


            }

            @Override
            public int getCount() {
                return tabCount;
            }

            //le titre à afficher pour chaque page
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getResources().getString(R.string.divertissement);
                    case 1:
                        return getResources().getString(R.string.sports);
                    case 2:
                        return getResources().getString(R.string.technologie);
                    case 3:
                        return ("Stats");
                    default:
                        return "Page" + position;
                }
            }

            int oldItemPosition = -1;

            @Override
            public void setPrimaryItem(ViewGroup container, int position, Object object) {
                super.setPrimaryItem(container, position, object);

                //CHANGEMENT D'ONGLET
                if (oldItemPosition != position) {
                    oldItemPosition = position;
                    headerLogo = findViewById(R.id.headerLogo);
                    headerLogoContent = (ImageView) findViewById(R.id.headerLogoContent);

                    //définir la nouvelle couleur et les nouvelles images
                    int color = Color.BLACK;
                    Drawable newDrawable = null;

                    switch (position) {
                        //AGIR SUR L'ONGLET 1 SANTE
                        case 0:

                            color = getResources().getColor(R.color.rose);
                            newDrawable = getResources().getDrawable(R.drawable.imagesante2);
                            break;
                        //AGIR SUR L'ONGLET 2  SPORT
                        case 1:

                            color = getResources().getColor(R.color.rose);
                            newDrawable = getResources().getDrawable(R.drawable.imagesport2);
                            break;
                        //AGIR SUR L'ONGLET 3 SOCIAL
                        case 2:

                            color = getResources().getColor(R.color.rose);
                            newDrawable = getResources().getDrawable(R.drawable.imagesocial);
                            break;
                        //AGIR SUR L'ONGLET 4 PARAMETRE
                        case 3:

                            color = getResources().getColor(R.color.rose);
                            newDrawable = getResources().getDrawable(R.drawable.imagestatistiques);

                            break;

                    }
                    //puis modifier les images/couleurs
                    int fadeDuration = 400;
                    materialViewPager.setColor(color, fadeDuration);
                    materialViewPager.setImageDrawable(newDrawable, fadeDuration);
                    toggleLogo(newDrawable, color, fadeDuration);

                }

            }
        });


        //permet au viewPager de garder 4 pages en mémoire (à ne pas utiliser sur plus de 4 pages !)
        this.materialViewPager.getViewPager().setOffscreenPageLimit(tabCount);
        //relie les tabs au viewpager
        this.materialViewPager.getPagerTitleStrip().setViewPager(this.materialViewPager.getViewPager());


        class Adapter extends FragmentPagerAdapter {
            private final List<Fragment> mFragmentList = new ArrayList<>();
            private final List<String> mFragmentTitleList = new ArrayList<>();

            public Adapter(FragmentManager manager) {
                super(manager);
            }

            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            public void addFragment(Fragment fragment, String title) {
                mFragmentList.add(fragment);
                mFragmentTitleList.add(title);
            }

        }
    }


    private void toggleLogo(final Drawable newLogo, final int newColor, int duration) {

        //animation de disparition  du header
        final AnimatorSet animatorSetDisappear = new AnimatorSet();
        animatorSetDisappear.setDuration(duration);
        animatorSetDisappear.playTogether(
                ObjectAnimator.ofFloat(headerLogo, "scaleX", 0),
                ObjectAnimator.ofFloat(headerLogo, "scaleY", 0)
        );


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class buttoncliquer implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v== btn_drawer2){
                Intent ouverture0 = new Intent(getApplicationContext(), InterfaceDrawerDroit.class);
                startActivity(ouverture0);
            }


        }


    }
}

