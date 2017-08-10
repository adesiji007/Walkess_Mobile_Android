package com.example.adesiji.Walkess;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.example.adesiji.Walkess.R.id.buttonBooking;
import static com.example.adesiji.Walkess.R.id.buttonPooch;
import static com.example.adesiji.Walkess.R.id.buttonTracking;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "bHPlcCzbfH8EljWik61JVHwdA";
    private static final String TWITTER_SECRET = "ID4wSmLEbJE1XNuj2RKj59rsOHrYlCKjRcge9aFV1MHDGn5gyZ";


    ViewPager viewPager;
    //ImageButton buttonBooking;


    ImageButton imageButton3 = null;
    ImageButton imageButton2 = null;
    ImageButton imageButton1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ActionBar actionBar = getActionBar();
       // actionBar.setDisplayHomeAsUpEnabled(true);
        //actionBar.hide();
        //actionBar.show();

        //TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        //Fabric.with(this, new Twitter(authConfig));

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);

        imageButton3 = (ImageButton)findViewById(buttonBooking);
        imageButton3.setOnClickListener(this);

        imageButton2 = (ImageButton)findViewById(buttonTracking);
        imageButton2.setOnClickListener(this);


        imageButton1 = (ImageButton)findViewById(buttonPooch);
        imageButton1.setOnClickListener(this);

    }
    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event)
    {
        switch (KeyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Toast.makeText(getBaseContext(),
                        "Center was clicked",
                        Toast.LENGTH_LONG).show();
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                Toast.makeText(getBaseContext(),
                        "Left was clicked",
                        Toast.LENGTH_LONG).show();
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                Toast.makeText(getBaseContext(),
                        "Right was clicked",
                        Toast.LENGTH_LONG).show();
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                Toast.makeText(getBaseContext(),
                        "Up was clicked",
                        Toast.LENGTH_LONG).show();
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                Toast.makeText(getBaseContext(),
                        "Down  was clicked",
                        Toast.LENGTH_LONG).show();
                break;

        }
            return false;

        }



        //ActionBar actionBar = getActionBar();
    //actionBar.hide(); // This will hide the action Bar
    //actionBar.show(); // This will show the action Bar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
        return true;
    }
    private void CreateMenu(Menu menu) {
        MenuItem menu1 = menu.add(0, 0, 0, "booking");
        {
            menu1.setIcon(R.drawable.booking);
            menu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

        }
        MenuItem menu2 = menu.add(0, 1, 1, "track_my_walk");
        {
            menu1.setIcon(R.drawable.walk);
            menu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        MenuItem menu3 = menu.add(0, 2, 2, "camera");
        {
            menu1.setIcon(R.drawable.camera);
            menu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        MenuItem menu4 = menu.add(0, 3, 3, "search");
        {
            menu1.setIcon(R.drawable.email);
            menu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        MenuItem menu5 = menu.add(0, 4, 4, "search");
        {
            menu1.setIcon(R.drawable.email);
            menu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //return onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.action_booking) {
            Toast.makeText(getApplicationContext(), "booking is Selected",
                    Toast.LENGTH_LONG).show();
            Intent booking2intent = new Intent(this, Booking.class);
            this.startActivity(booking2intent);
            return true;

        } else if (id == R.id.action_track_my_walk) {
            Toast.makeText(getApplicationContext(), "track_my_walk is Selected",
                    Toast.LENGTH_LONG).show();

            Intent Track2intent = new Intent(this, Walking.class);
            this.startActivity(Track2intent);
            return true;

        } else if (id == R.id.imageButton_working) {
            Toast.makeText(getApplicationContext(), "Pooch Service is Selected",
                    Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, Walking.class);
            this.startActivity(intent);
            return true;

        } else if (id == R.id.add_contact_layout) {
            Toast.makeText(getApplicationContext(), "AddContact is Selected",
                    Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, AddContact.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == buttonBooking){
            Intent intent = new Intent(view.getContext(), Booking.class );
            startActivity(intent);
        }

        if (id == buttonTracking){
            Intent intent = new Intent(view.getContext(), Walking.class );
            startActivity(intent);
        }
        if (id == buttonPooch){
            Intent intent = new Intent(view.getContext(), PoochService.class );
            startActivity(intent);
        }

    }


}
