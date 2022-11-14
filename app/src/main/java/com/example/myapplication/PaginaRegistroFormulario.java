package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaginaRegistroFormulario extends AppCompatActivity {
    Button button;
    private EditText name, date, email, password1, password2;
    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina_registro_formulario);


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrarDialogo();

            }
        });

    }


    private void mostrarDialogo() {
        button = (Button) findViewById(R.id.button);
        AlertDialog.Builder builder = new AlertDialog.Builder(PaginaRegistroFormulario.this);
        builder.setTitle("Bienvenido");
        builder.setMessage("Ya estas registrado")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent buttom = new Intent(PaginaRegistroFormulario.this, Home1.class);
                        startActivity(buttom);


                    }
                }).show();
    }
}
