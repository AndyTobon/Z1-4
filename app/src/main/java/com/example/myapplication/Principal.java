package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    Button comenzar,cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        comenzar = (Button) findViewById(R.id.button6);
        cuenta = (Button) findViewById(R.id.button8);

        comenzar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent comenzar = new Intent(Principal.this, RegistroComenzarAhora.class) ;
                startActivity(comenzar);
            }
        });

        cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cuenta = new Intent(Principal.this, IniciarSesionComenzarAhora.class);
                startActivity(cuenta);
            }
        });


    }
}