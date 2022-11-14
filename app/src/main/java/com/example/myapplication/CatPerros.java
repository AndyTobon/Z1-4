package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CatPerros extends AppCompatActivity {

    Button peque, mediano, grande;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_perros);

        peque = (Button)findViewById(R.id.button10);
        mediano = (Button)findViewById(R.id.button11);
        grande = (Button)findViewById(R.id.button12);

        peque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perro = new Intent(CatPerros.this, PerrosPeque.class);
                startActivity(perro);
            }
        });
    }
}