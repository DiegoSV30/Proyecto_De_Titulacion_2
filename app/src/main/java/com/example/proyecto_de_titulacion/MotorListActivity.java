package com.example.proyecto_de_titulacion;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MotorListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> motores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor_list);

        listView = findViewById(R.id.listViewMotores);
        motores = getIntent().getStringArrayListExtra("motores");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, motores);
        listView.setAdapter(adapter);
    }
}
