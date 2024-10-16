package com.example.proyecto_de_titulacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> motores;
    private ArrayAdapter<String> adapter;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        motores = new ArrayList<>();
        listView = findViewById(R.id.listViewMotores);
        Button btnAgregarMotor = findViewById(R.id.btnAgregarMotor);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, motores);
        listView.setAdapter(adapter);

        btnAgregarMotor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddMotorActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Aquí puedes implementar la navegación a la pantalla de detalle
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String nuevoMotor = data.getStringExtra("motor");
            motores.add(nuevoMotor);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_listar_motores) {
            Intent intent = new Intent(this, MotorListActivity.class);
            intent.putStringArrayListExtra("motores", motores);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
