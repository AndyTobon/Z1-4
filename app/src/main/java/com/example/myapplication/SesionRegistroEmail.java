package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SesionRegistroEmail extends AppCompatActivity {
    Button formulario, sesion;
    private EditText edtEmail, edtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_registro_email);
        edtEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        edtPassword = (EditText) findViewById(R.id.editTextTextPassword);
        formulario = (Button) findViewById(R.id.button1);
        sesion = (Button) findViewById(R.id.button2);

        formulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formulario = new Intent(SesionRegistroEmail.this, PaginaRegistroFormulario.class);
                startActivity(formulario);
            }
        });

        sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmailAddress(edtEmail);

            }
        });

    }

    private boolean validateEmailAddress(EditText edtEmail) {
        String emailInput = edtEmail.getText().toString();
        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {

            Intent sesion =new Intent(SesionRegistroEmail.this, Home1.class);
            startActivity(sesion);
            return true;
        } else Toast.makeText(this, "Correo no valido", Toast.LENGTH_SHORT).show();
        return false;
    }

}





