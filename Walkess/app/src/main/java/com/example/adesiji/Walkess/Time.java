package com.example.adesiji.Walkess;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.widget.Toast;

public class Time extends AppCompatActivity {
    //TextView tv;
    TimePicker timePicker;
    int hour, minute;
    static final int TIME_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

        showDialog(TIME_DIALOG_ID);
    }

    @Override
    protected Dialog onCreateDialog(int id){
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(
                        this, mTimeSetListener, hour, minute, false);
        }
        return null;

        }
    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minuteofHour)
        {
            hour = hourOfDay;
            minute = minuteofHour;

            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
            Date date = new Date(0,0,0, hour, minute);
            String strDate = timeFormat.format(date);

            Toast.makeText(getBaseContext(), " Time shown is: " + strDate, Toast.LENGTH_SHORT).show();

        }
    };

    public void onClick(View view)
    {
        Toast.makeText(getBaseContext(), "Time selected: " + timePicker.getCurrentHour() +
        ":" + timePicker.getCurrentMinute(), Toast.LENGTH_SHORT).show();

    }

        /*
        TimePicker tp = (TimePicker)
                findViewById(R.id.timePicker);
        tp.setIs24HourView(true);
        tp.setCurrentMinute(10);
        tp.setCurrentHour(13);
        tp.setOnTimeChangedListener(OnTimeChanged);
    }

    public  void doButtonClick(View e) {
        TextView tv =
                (TextView)findViewById(R.id.textView);
        TimePicker tp =
                (TimePicker) findViewById(R.id.timePicker);
        tv.setText(tp.getCurrentHour().toString()
                + ":" + tp.getCurrentMinute().toString());
    }

    TimePicker.OnTimeChangedListener OnTimeChanged =
            new TimePicker.OnTimeChangedListener() {
                @Override
                public void onTimeChanged(
                        TimePicker view,
                        int hourOfDay,
                        int minute) {
                    TextView tv =
                            (TextView) findViewById(R.id.textView);
                    tv.setText(Integer.toString(hourOfDay) +
                            ":" + Integer.toString(minute));
                }
            };
            **/

}