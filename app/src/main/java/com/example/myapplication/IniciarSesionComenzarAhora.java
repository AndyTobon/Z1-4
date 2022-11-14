package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IniciarSesionComenzarAhora extends AppCompatActivity {
    Button email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar_sesion_comenzar_ahora);

        email = (Button) findViewById(R.id.button5);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(IniciarSesionComenzarAhora.this, SesionRegistroEmail.class);
                startActivity(email);
            }
        });
    }
}