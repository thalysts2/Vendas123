package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainUser extends Activity {

    private Button buttonConsultar;
    private Button buttonIncluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);

        buttonConsultar = (Button)findViewById(R.id.buttonConsultar);
        buttonIncluir = (Button)findViewById(R.id.buttonIncluir);

        buttonIncluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainUser.this,CadastroActivity.class);
                startActivity(intent);
            }
        });

        buttonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainUser.this,ConsultaActivity.class);
                startActivity(intent);
            }
        });
    }
}