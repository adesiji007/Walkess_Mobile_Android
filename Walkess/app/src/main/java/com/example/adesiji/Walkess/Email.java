package com.example.adesiji.Walkess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by adesiji on 16/12/2015.
 */
public class Email extends AppCompatActivity implements View.OnClickListener{
    ImageButton switch_to_email = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);

    }
    //switch_to_email = (ImageButton)findViewById(R.id.email);


    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.email) {


            switch_to_email = (ImageButton)findViewById(R.id.email);
            switch_to_email.setOnClickListener(this);
        }

        //Intent emailIntent = new Intent(view.getContext(), Email.class);
        //startActivity(emailIntent);
        // You have to replace the email address to the following**********
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        String[] to = {"adesiji007@yahoo.com","bg47de@student.sunderland.ac.uk"};
        String[] cc = {"adesiji0007@gmail.com"};
        sendEmail(to, cc, "Hello", "Hello my friends!");
    }
    // ****send an sms messages to another device*****
    private void sendEmail(String[] emailAddresses, String[] carbonCopies, String subject, String message)
    {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        //emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
        String[] to= emailAddresses;
        String[] cc = carbonCopies;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
        emailIntent.setType("message/rfc822");
        //chooser = Intent.createChooser(emailIntent, "sendEmail");
        //this.startActivities(Intent.createChooser(emailIntent, "Email"));
        //this.startActivities(chooser);
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Email.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }


}