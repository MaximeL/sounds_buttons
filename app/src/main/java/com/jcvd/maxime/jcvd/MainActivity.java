package com.jcvd.maxime.jcvd;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout background;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        background = (ConstraintLayout) findViewById(R.id.background);
        background.setBackgroundColor(Color.BLACK);

        video = (VideoView) findViewById(R.id.videoView);
        initVideo();

        background.setOnTouchListener(this::playViedo);
    }

    private void initVideo() {
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.jcvd_c_beau);
        video.setVideoURI(uri);
    }

    private boolean playViedo(View v, MotionEvent event) {
        if(video.isPlaying()) {
            initVideo();
        }
        video.start();
        return true;
    }
}
