package com.manikandansethuraj.nepeancricketclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MorePage extends AppCompatActivity implements View.OnClickListener {


    ImageButton scheduleButton, playersButton, galleryButton, likeusButton, captainsButton, sponsorsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_page);


        scheduleButton = (ImageButton) findViewById(R.id.btnSchedule);
        playersButton = (ImageButton) findViewById(R.id.btnPlayers);
        galleryButton = (ImageButton) findViewById(R.id.btnGallery);
        likeusButton = (ImageButton) findViewById(R.id.btnLikeUs);
        captainsButton = (ImageButton) findViewById(R.id.btnCaptains);
        sponsorsButton = (ImageButton) findViewById(R.id.btnSponsors);

        scheduleButton.setOnClickListener(this);
        playersButton.setOnClickListener(this);
        galleryButton.setOnClickListener(this);
        likeusButton.setOnClickListener(this);
        captainsButton.setOnClickListener(this);
        sponsorsButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnCaptains:
                intent = new Intent(this,CaptainsPage.class);
                break;
            case R.id.btnPlayers:
                intent = new Intent(this,PlayersPage.class);
                break;
            case  R.id.btnGallery:
                intent = new Intent(this, GalleryPage.class);
                break;
            case  R.id.btnLikeUs:
                intent = new Intent(this, LikeUsPage.class);
                break;
            case  R.id.btnSchedule:
                intent = new Intent(this, SchedulePage.class);
                break;
            case  R.id.btnSponsors:
                intent = new Intent(this, Sponsorsspage.class);
                break;
            default:

        }

        if (intent != null){
            startActivity(intent);
        }

    }
}
