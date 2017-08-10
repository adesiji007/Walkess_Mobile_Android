package com.example.adesiji.Walkess;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by adesiji on 02/12/2015.
 */
public class Date extends AppCompatActivity {
    Button btn;
    TextView contact_date;
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;

    /** called when the activity first created.  .....*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date);

        contact_date = (TextView)findViewById(R.id.contact_date);
        contact_date.getText().toString();


        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        showDialogOnButtonClick();
    }

    public void showDialogOnButtonClick() {
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);

                    }
                }
        ) ;
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if (id == DIALOG_ID)
            return new DatePickerDialog(this,dpickerListener, year_x, month_x, day_x );
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public  void onDateSet(DatePicker view, int year, int monthofYear, int dayofMonth)
        {
            year_x = year;
            month_x = monthofYear + 1;
            day_x = dayofMonth;

            // display the toast
            String message = "The date is : ";
            Toast.makeText(Date.this, year_x + "/" + month_x + "/" + day_x, Toast.LENGTH_LONG).show();
            contact_date.setText(message);
        }
    };
    public void addContact (View view)

    {int id = view.getId();
        String message = "The date is : ";
        Toast.makeText(Date.this, year_x + "/" + month_x + "/" + day_x, Toast.LENGTH_LONG).show();;
        contact_date.setText(message);

        if (id == R.id.button) {
            Intent intent = new Intent(view.getContext(), AddContact.class);
            startActivity(intent);
        }
    }

    public void addCancel (View view)
    {int id = view.getId();

        if (id == R.id.buttonCancel) {
            Intent intent = new Intent(view.getContext(), AddContact.class);
            startActivity(intent);
        }
    }


}
