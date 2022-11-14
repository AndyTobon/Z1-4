package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class RegistroComenzarAhora extends AppCompatActivity {
    Button email2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_comenzar_ahora);

        email2 = (Button) findViewById(R.id.button5);
        email2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email2 = new Intent(RegistroComenzarAhora.this, SesionRegistroEmail.class);
                startActivity(email2);
            }
        });

    }

}