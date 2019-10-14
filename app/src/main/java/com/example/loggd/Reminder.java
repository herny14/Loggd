package com.example.loggd;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.util.Calendar;



class reminder extends AppCompatActivity {

    Button btnSet = findViewById(R.id.btnSet);
    EditText hh = findViewById(R.id.editText4);
    EditText mm = findViewById(R.id.editText5);
    TextView txtView = findViewById(R.id.tvTime);
    private PendingIntent pendingIntent;


    private void alarmMethod(int hr, int mn){
        Intent myIntent = new Intent(this, NotifyService.class);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        pendingIntent = PendingIntent.getService(this, 0, myIntent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, mn);
        calendar.set(Calendar.HOUR, hr);
        calendar.set(Calendar.AM_PM, Calendar.AM);
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent);

        Toast.makeText(reminder.this, "Alarm starting", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        getIntent();
        setTitle("Reminder");

        btnSet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txtView.setText(hh.getText().toString()+mm.getText().toString());
                alarmMethod(Integer.parseInt(hh.getText().toString()), Integer.parseInt(mm.getText().toString()));
            }
        });
    }




}

