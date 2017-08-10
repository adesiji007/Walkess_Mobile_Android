package com.example.adesiji.Walkess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by adesiji on 20/12/2015.
 */
public class PoochService extends AppCompatActivity implements View.OnClickListener{

    ImageButton switch_to_imageButton_camera = null;
    ImageButton switch_to_contact = null;
    ImageButton switch_to_imageButton_twitter = null;
    ImageButton switch_to_imageButton_sms = null;
    ImageButton switch_to_imageButton_pictures = null;
    ImageButton switch_to_web_page = null;
    ImageButton switch_to_email = null;
    ImageButton switch_to_phone = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pooch_services);

        switch_to_imageButton_camera = (ImageButton)findViewById(R.id.imageButton_camera);
        switch_to_imageButton_camera.setOnClickListener(this);

        switch_to_contact = (ImageButton)findViewById(R.id.contact);
        switch_to_contact.setOnClickListener(this);

        switch_to_imageButton_twitter = (ImageButton)findViewById(R.id.imageButton_twitter);
        switch_to_imageButton_twitter.setOnClickListener(this);

        switch_to_imageButton_sms = (ImageButton)findViewById(R.id.imageButton_sms);
        switch_to_imageButton_sms.setOnClickListener(this);

        switch_to_imageButton_pictures = (ImageButton)findViewById(R.id.imageButton_pictures);
        switch_to_imageButton_pictures.setOnClickListener(this);

        switch_to_web_page = (ImageButton)findViewById(R.id.web);
        switch_to_web_page.setOnClickListener(this);

        switch_to_email = (ImageButton)findViewById(R.id.email);
        switch_to_email.setOnClickListener(this);

        switch_to_phone = (ImageButton)findViewById(R.id.phone);
        switch_to_phone.setOnClickListener(this);

    }

    public void onClick(View view)
    {
        int id = view.getId();

        if (id == R.id.imageButton_camera) {
            Intent track_my_walk_intent = new Intent(view.getContext(), Camera1.class);
            startActivity(track_my_walk_intent);
        }

        if (id == R.id.contact) {
            Intent track_my_walk_intent = new Intent(view.getContext(), User.class);
            startActivity(track_my_walk_intent);
        }
        if (id == R.id.imageButton_twitter) {
            Intent track_my_walk_intent = new Intent(view.getContext(), Twitter.class);
            startActivity(track_my_walk_intent);
        }
        if (id == R.id.imageButton_sms) {
            Intent track_my_walk_intent = new Intent(view.getContext(), Sms.class);
            startActivity(track_my_walk_intent);
        }
        if (id == R.id.imageButton_pictures) {
            Intent track_my_walk_intent = new Intent(view.getContext(), Picture.class);
            startActivity(track_my_walk_intent);
        }
        if (id == R.id.web) {
            Intent track_my_walk_intent = new Intent(view.getContext(), Web.class);
            startActivity(track_my_walk_intent);
        }
        if (id == R.id.email) {
            Intent track_my_walk_intent = new Intent(view.getContext(), Email.class);
            startActivity(track_my_walk_intent);
        }
        if (id == R.id.phone) {
            Intent track_my_walk_intent = new Intent(view.getContext(), Phone.class);
            startActivity(track_my_walk_intent);
        }
    }
}
