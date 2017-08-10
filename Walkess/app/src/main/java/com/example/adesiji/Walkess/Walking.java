package com.example.adesiji.Walkess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by adesiji on 27/11/2015.
 */
public class Walking extends AppCompatActivity implements View.OnClickListener {
    ImageButton switch_to_track_my_walk = null;
    ImageButton switch_to_imageButton_map = null;

    ImageButton switch_to_imageButton_facebook = null;
    ImageButton switch_to_imageButton_time_walk = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walking);

        switch_to_track_my_walk = (ImageButton)findViewById(R.id.imageButton_time_walk);
        switch_to_track_my_walk.setOnClickListener(this);

        switch_to_imageButton_map = (ImageButton)findViewById(R.id.imageButton_map);
        switch_to_imageButton_map.setOnClickListener(this);



        switch_to_imageButton_facebook = (ImageButton)findViewById(R.id.imageButton_facebook);
        switch_to_imageButton_facebook.setOnClickListener(this);

        switch_to_imageButton_time_walk = (ImageButton)findViewById(R.id.imageButton_time_walk);
        switch_to_imageButton_time_walk.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.imageButton_map) {
            Intent track_my_walk_intent = new Intent(v.getContext(), MapsActivity.class);
            startActivity(track_my_walk_intent);
        }

        if (id == R.id.imageButton_working) {
            Intent track_my_walk_intent = new Intent(v.getContext(), Tracking.class);
            startActivity(track_my_walk_intent);
        }


        if (id == R.id.imageButton_time_walk) {
            Intent switch_to_imageButton_time_walk_intent = new Intent(v.getContext(), Sensors.class);
            startActivity(switch_to_imageButton_time_walk_intent);
        }
        if (id == R.id.imageButton_facebook) {
            Intent switch_to_imageButton_facebook_intent = new Intent(v.getContext(), Facebook.class);
            startActivity(switch_to_imageButton_facebook_intent);
        }

    }

}

