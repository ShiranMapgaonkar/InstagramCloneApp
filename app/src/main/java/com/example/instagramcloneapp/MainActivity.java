package com.example.instagramcloneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;
    private EditText txtname, txtpspeed, txtkspeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave= findViewById(R.id.btnsave);
        btnSave.setOnClickListener(MainActivity.this);

        txtname= findViewById(R.id.txtname);
        txtkspeed= findViewById(R.id.txtkspeed);
        txtpspeed= findViewById(R.id.txtpspeed);

    }



    @Override
    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        super.applyOverrideConfiguration(overrideConfiguration);
    }

    @Override
    public void onClick(View view) {
        try {
            final ParseObject kickboxer = new ParseObject("Kickboxer");
            kickboxer.put("name", txtname.getText().toString());
            kickboxer.put("kick_speed", Integer.parseInt(txtkspeed.getText().toString()));
            kickboxer.put("punch_speed", Integer.parseInt(txtpspeed.getText().toString()));
            kickboxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        // Toast.makeText(MainActivity.this, , Toast.LENGTH_LONG).show();
                        FancyToast.makeText(MainActivity.this, kickboxer.get("name") + " is saved to server", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                    } else {
                        // Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();


                    }

                }
            });
        } catch (Exception e ) {
            FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

        }
    }
}