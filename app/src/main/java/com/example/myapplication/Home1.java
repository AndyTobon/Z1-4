package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home1 extends AppCompatActivity {
    Button agregar,perro,gato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        agregar = (Button) findViewById(R.id.button);
        perro = (Button) findViewById(R.id.button4);
        gato = (Button)  findViewById(R.id.button9);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent agregar = new Intent(Home1.this, Agregar.class);
                startActivity(agregar);
            }
        });

        perro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perro = new Intent(Home1.this, CatPerros.class);
                startActivity(perro);
            }
        });

        gato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gato = new Intent(Home1.this, Catgatos.class);
                startActivity(gato);
            }
        });
    }
}