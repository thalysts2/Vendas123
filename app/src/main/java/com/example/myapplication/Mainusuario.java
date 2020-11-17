package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mainusuario extends AppCompatActivity {
    private Button buttonConsultar;
    private Button buttonIncluir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
        buttonConsultar = (Button)findViewById(R.id.buttonConsultar);
        buttonIncluir = (Button)findViewById(R.id.buttonIncluir);

        buttonIncluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainusuario.this,CadastroActivity.class);
                startActivity(intent);
            }
        });

        buttonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainusuario.this,ConsultaActivity.class);
                startActivity(intent);
            }
        });
    }
}

