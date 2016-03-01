package com.manikandansethuraj.nepeancricketclub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class Splashone extends AppCompatActivity {

    VideoView video;
    protected boolean active = true;
    protected int splashTime = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashone);

        video = (VideoView) findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.johnson;
        video.setVideoURI(Uri.parse(path));
        video.start();
        video.requestFocus();



        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (active && (waited < splashTime)) {
                        sleep(100);
                        if (active) {
                            waited += 100;
                        }
                    }
                } catch (Exception e) {

                } finally {

                    startActivity(new Intent(Splashone.this,
                            SplashScreen.class));
                    finish();
                }
            };
        };
        splashTread.start();



    }
}
