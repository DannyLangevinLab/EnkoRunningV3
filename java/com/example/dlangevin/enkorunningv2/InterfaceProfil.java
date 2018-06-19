package com.example.dlangevin.enkorunningv2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by d.langevin on 17/05/2016.
 */
public class InterfaceProfil extends AppCompatActivity {
    private ImageButton retoursport;
    private ImageButton btn_facebook;
    private ImageButton btn_twitter;
    private ImageButton btn_google_plus;
    private ImageButton ajouter_photo;
    private ImageView imageHolder;
    private final int requestCode = 20;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_profil);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        collapsingToolbar.setTitle(getString(R.string.item_title));
        retoursport = (ImageButton) findViewById(R.id.retoursport);
        retoursport.setOnClickListener(new buttoncliquer());
        btn_facebook = (ImageButton) findViewById(R.id.btn_facebook);
        btn_facebook.setOnClickListener(new buttoncliquer());
        btn_twitter = (ImageButton) findViewById(R.id.btn_twitter);
        btn_twitter.setOnClickListener(new buttoncliquer());
        btn_google_plus = (ImageButton) findViewById(R.id.btn_google_plus);
        btn_google_plus.setOnClickListener(new buttoncliquer());
        ajouter_photo = (ImageButton) findViewById(R.id.ajouter_photo);
        ajouter_photo.setOnClickListener(new buttoncliquer());
        imageHolder = (ImageView)findViewById(R.id.captured_photo);

    }


    private class buttoncliquer implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v == retoursport) {
                InterfaceProfil.this.finish();
            }

            if (v == ajouter_photo) {
                Intent photoCaptureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, requestCode);
            }

            if (v == btn_facebook) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fr-fr.facebook.com/login/"));
                startActivity(browserIntent);
            }
            if (v == btn_twitter) {
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mobile.twitter.com/session/new"));
                startActivity(browserIntent2);
            }
            if (v == btn_google_plus) {
                Intent browserIntent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://aboutme.google.com/u/0/?referer=gplus"));
                startActivity(browserIntent3);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.requestCode == requestCode && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageHolder.setImageBitmap(bitmap);
        }
    }
}

