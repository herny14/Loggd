package com.example.loggd;


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
                if(sReminder.isEnabled()){
                    Toast.makeText(getActivity().getApplicationContext(), "OPENING REMINDER MENU!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), Reminderv2.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "CAN'T OPEN REMINDER MENU! ENABLE NOTIFICATIONS!", Toast.LENGTH_SHORT).show();
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
}