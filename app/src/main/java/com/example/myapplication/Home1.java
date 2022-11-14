package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Home1 extends AppCompatActivity  {
    Button agregar,perro,gato;
    ImageButton perfil, chat, favoritos, mapa, home,ajustes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        agregar = (Button) findViewById(R.id.button);
        perro = (Button) findViewById(R.id.button4);
        gato = (Button)  findViewById(R.id.button9);
        perfil = (ImageButton) findViewById(R.id.imageButton5);
        chat = (ImageButton) findViewById(R.id.imageButton2);
        home = (ImageButton)findViewById(R.id.imageView13);
        favoritos = (ImageButton) findViewById(R.id.imageButton);
        mapa = (ImageButton) findViewById(R.id.imageButton4);
        ajustes = (ImageButton) findViewById(R.id.imageButton3);

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

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent favoritos = new Intent(Home1.this, Perfil.class);
                startActivity(favoritos);///
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent favoritos = new Intent(Home1.this, Chat.class);
                startActivity(favoritos);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent favoritos = new Intent(Home1.this, Home1.class);
                startActivity(favoritos);
            }
        });

        favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent favoritos = new Intent(Home1.this, Favoritos.class);
                startActivity(favoritos);///es el icono de la estrella
            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent favoritos = new Intent(Home1.this, MAPA.class);
                startActivity(favoritos);
            }
        });

        ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent favoritos = new Intent(Home1.this, Ajustes.class);
                startActivity(favoritos);
            }
        });

    }


}