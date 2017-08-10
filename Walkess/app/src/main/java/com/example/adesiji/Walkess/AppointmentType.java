package com.example.adesiji.Walkess;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import static android.widget.Toast.*;

/**
 * Created by adesiji on 22/12/2015.
 */
public class AppointmentType extends AppCompatActivity {
    private CheckBox check1, check2;
    private Button button_sel;

    @Override
    protected void onCreate (Bundle saveInstancedState) {
        super.onCreate(saveInstancedState);
        setContentView(R.id.appointment_type);

         addListeneronButton();
         addListenerToCheckBox();
    }

     public void addListenerToCheckBox(){
    check1 = (CheckBox)findViewById(R.id.checkBox_Walking);
     check1.setOnClickListener(
 new View.OnClickListener() {
@Override
public void onClick(View view) {
if (((CheckBox) view).isChecked()) {
makeText(AppointmentType.this, "Walking Dog is selected", LENGTH_LONG).show();
}

}
}
 );

 check2 = (CheckBox)findViewById(R.id.checkBox_Dog);
 check2.setOnClickListener(
 new View.OnClickListener() {
@Override
public void onClick(View view) {
if (((CheckBox) view).isChecked()) {
makeText(AppointmentType.this, "Walking Dog is selected", LENGTH_LONG).show();
}

}
}
 );

 }
 public void addListeneronButton() {
 check1 = (CheckBox) findViewById(R.id.checkBox_Walking);
 check2 = (CheckBox) findViewById(R.id.checkBox_Dog);

 button_sel = (Button) findViewById(R.id.btnSave);
 button_sel.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View v) {
StringBuffer result = new StringBuffer();
result.append("\n Walking Dog : ").append(check1.isChecked());
result.append("\n Sit Pet: ").append(check2.isChecked());
Toast.makeText(AppointmentType.this, result.toString(), Toast.LENGTH_LONG).show();
}

;

});
 }
/**
    //------------------------------ToggleButton----------------------
     ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggle1);
     toggleButton.setOnClickListener(new View.OnClickListener())
     {
     public void onClick(View v)
     {
     if (((ToggleButton) v).isChecked()) {
     Toast.makeText(getBaseContext(),"Toggle button is On",Toast.LENGTH_LONG).show();
     else
     Toast.makeText(getBaseContext(),"Toggle button is Off",Toast.LENGTH_LONG).show();
     }
     });
     }**/

    private void DisplayToast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void OnClickBack(View view) {
        int id = view.getId();

        if (id == R.id.btnBack) {
            Intent intent = new Intent(view.getContext(), AddContact.class);
            startActivity(intent);
        }
    }

    }


