package com.example.loggd;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {


    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    };


    Switch sNotification, sLocation, sReminder;
    TextView reminder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        sNotification = (Switch)v.findViewById(R.id.switchNotification);
        sLocation = (Switch)v.findViewById(R.id.switchLocation);
        sReminder = (Switch)v.findViewById(R.id.switchReminder);
        sReminder.setEnabled(false);
        reminder = (TextView)v.findViewById(R.id.tvReminder);

        sNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(((Switch)v).isChecked()){
                    Toast.makeText(getActivity().getApplicationContext(), "Notification ON!", Toast.LENGTH_SHORT).show();
                    sReminder.setEnabled(true);
                }else {
                    Toast.makeText(getActivity().getApplicationContext(), "Notification OFF!", Toast.LENGTH_SHORT).show();
                    sReminder.setEnabled(false);
                }
            }
        });

        sLocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((Switch)v).isChecked()){
                    Toast.makeText(getActivity().getApplicationContext(), "Location Services ON!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Location Services OFF!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sReminder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((Switch)v).isChecked()){
                    Toast.makeText(getActivity().getApplicationContext(), "Reminder ON!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Reminder OFF!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reminder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(sReminder.isChecked()){
                    //Intent i = new Intent(getContext(), Reminderv2.class);
                    //startActivity(i);
                    alarmMethod();
                    Toast.makeText(getActivity().getApplicationContext(), "Starting Alarm!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "CAN'T OPEN! PLEASE ENABLE REMINDER!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        /*
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
        */
        return v;
    }
    private PendingIntent pendingIntent;
    private void alarmMethod(){
        Intent myIntent = new Intent(getActivity().getApplicationContext(), NotifyActivity.class);
        AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(ALARM_SERVICE);
        pendingIntent = PendingIntent.getService(getActivity().getApplicationContext(), 0, myIntent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 6);
        calendar.set(Calendar.AM_PM, Calendar.AM);
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent);

        Toast.makeText(getActivity().getApplicationContext(), "Alarm starting at 6 AM Everyday!", Toast.LENGTH_SHORT).show();
    }
}