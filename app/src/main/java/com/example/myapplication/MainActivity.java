package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button formulario, sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formulario = (Button)  findViewById(R.id.button1);
        sesion = (Button) findViewById(R.id.button2);

        sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sesion = new Intent (MainActivity.this,Home1.class);
                startActivity(sesion);
            }
        });

        formulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formulario = new Intent(MainActivity.this, pagregis.class);
                startActivity(formulario);
            }
        });


    }

}