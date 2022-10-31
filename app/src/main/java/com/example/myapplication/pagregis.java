package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pagregis extends AppCompatActivity {
    Button bienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regi_formu);

        bienvenido = (Button) findViewById(R.id.button);
        bienvenido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bienvenido = new Intent(pagregis.this, CreasteCuenta.class);
                startActivity(bienvenido);
            }
        });
    }
}