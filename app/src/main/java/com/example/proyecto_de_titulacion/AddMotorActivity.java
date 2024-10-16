package com.example.proyecto_de_titulacion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMotorActivity extends Activity {

    private EditText etNombre, etNumeroSerie, etPotencia, etVoltaje, etFrecuencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_motor);

        etNombre = findViewById(R.id.etNombre);
        etNumeroSerie = findViewById(R.id.etNumeroSerie);
        etPotencia = findViewById(R.id.etPotencia);
        etVoltaje = findViewById(R.id.etVoltaje);
        etFrecuencia = findViewById(R.id.etFrecuencia);
        Button btnGuardar = findViewById(R.id.btnGuardar);
        Button btnCancelar = findViewById(R.id.btnCancelar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String motorInfo = etNombre.getText().toString() + " - " +
                        etNumeroSerie.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("motor", motorInfo);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
