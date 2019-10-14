package com.example.loggd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.loggd.R.id.button;
import static com.example.loggd.R.id.textView2;

public class Reminderv2 extends AppCompatActivity {

    EditText eT1 = findViewById(R.id.editText);
    TextView tV1 = findViewById(textView2);
    Button btn = findViewById(button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminderv2);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), eT1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
