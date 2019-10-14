package com.example.loggd;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;


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
    TextView tV;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        sNotification = (Switch)v.findViewById(R.id.switchNotification);
        sLocation = (Switch)v.findViewById(R.id.switchLocation);
        sReminder = (Switch)v.findViewById(R.id.switchReminder);
        tV = (TextView)v.findViewById(R.id.textView7);
        btn = (Button)v.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity().getApplicationContext(), "Ticked!", Toast.LENGTH_SHORT).show();
            }
        });
        sNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(((Switch)v).isChecked()){
                    tV.setText("Notif is checked!");
                }else
                    tV.setText("Notif is not chekced!");
            }
        });

        /*
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
        */
        return v;
    }






}
