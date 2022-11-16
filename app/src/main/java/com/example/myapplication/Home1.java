package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;


public class Home1 extends AppCompatActivity  {
    Button agregar,perro,gato;
    ArrayList<AdapHome> ListaMenu;
    RecyclerView recyclerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        agregar = (Button) findViewById(R.id.button);
        perro = (Button) findViewById(R.id.button4);
        gato = (Button)  findViewById(R.id.button9);

        ListaMenu = new ArrayList<>();
        recyclerMenu = (RecyclerView) findViewById(R.id.recycle);
        recyclerMenu.setLayoutManager(new GridLayoutManager(this,3));

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

        llenarMenu();
        AdapterHome adapter = new AdapterHome(ListaMenu);
        adapter.setOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaMenu.add(new AdapHome(R.drawable.image_6));
                Intent perfil = new Intent(Home1.this, Perfil.class);
                startActivity(perfil);
                ListaMenu.add(new AdapHome(R.drawable.imagegoo_3_1));
                Intent home = new Intent(Home1.this, Home1.class);
                startActivity(home);
                ListaMenu.add(new AdapHome(R.drawable.image_2));
                Intent chat = new Intent(Home1.this, Chat.class);
                startActivity(chat);
                ListaMenu.add(new AdapHome(R.drawable.image_4));
                Intent favoritos = new Intent(Home1.this, Favoritos.class);
                startActivity(favoritos);
                ListaMenu.add(new AdapHome(R.drawable.image_8));
                Intent mapa = new Intent(Home1.this, MAPA.class);
                startActivity(mapa);
                ListaMenu.add(new AdapHome(R.drawable.image_5));
                Intent ajustes = new Intent(Home1.this, Ajustes.class);
                startActivity(ajustes);

            }
        });
        recyclerMenu.setAdapter(adapter);

    }
    private void llenarMenu() {
        ListaMenu.add(new AdapHome(R.drawable.image_6));
        ListaMenu.add(new AdapHome(R.drawable.imagegoo_3_1));
        ListaMenu.add(new AdapHome(R.drawable.image_2));
        ListaMenu.add(new AdapHome(R.drawable.image_4));
        ListaMenu.add(new AdapHome(R.drawable.image_8));
        ListaMenu.add(new AdapHome(R.drawable.image_5));

}
}
