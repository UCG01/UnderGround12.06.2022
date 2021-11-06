package com.example.underground40.Login;


import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.underground40.R;
import com.example.underground40.databinding.ActivityMainBinding;
import com.example.underground40.ui.main.Haupt;

import java.io.InputStream;

public class Registriren extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registriren_layout);
int i =1;
if(i==1){
    Intent intent = new Intent(this, Haupt.class);
    startActivity(intent);
}
    }

public void  Registriren(View view){

    EditText phone1 = findViewById(R.id.Phone1);
    EditText phone2 = findViewById(R.id.Phone2);

    String textphone1 = String.valueOf(phone1.getText());
    String textphone2 = String.valueOf(phone2.getText());
    if(textphone1.equals(textphone2)) {
System.out.println("SENDSMS "+textphone1);
        String sms = "TEST";

        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(textphone1, null, sms, null, null);

    }
}

}