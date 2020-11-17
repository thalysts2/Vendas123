package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextSenha;
    private Button buttonExcluir;
    private Button buttonSalvar;
    private Button buttonCancelar;

    private final Usuario usuario = new Usuario(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editTextNome = (EditText)findViewById(R.id.editTextNome);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextSenha = (EditText)findViewById(R.id.editTextSenha);
        buttonExcluir = (Button)findViewById(R.id.buttonExcluir);
        buttonCancelar = (Button)findViewById(R.id.buttonCancelar);
        buttonSalvar = (Button)findViewById(R.id.buttonSalvar);

        buttonExcluir.setOnClickListener(this);
        buttonSalvar.setOnClickListener(this);
        buttonCancelar.setOnClickListener(this);

        if (getIntent().getExtras() != null){
            setTitle(getString(R.string.titulo_editando));
            int codigo = getIntent().getExtras().getInt("usuario");
            usuario.carregaUsuarioPeloCodigo(codigo);

            if (usuario.getAvatar() != null)
                editTextNome.setText(usuario.getNome().toString());
            editTextEmail.setText(usuario.getEmail().toString());
            editTextSenha.setText(usuario.getSenha().toString());
        }else{
            setTitle(getString(R.string.titulo_incluindo));
        }

        buttonExcluir.setEnabled(true);
        if (usuario.getCodigo() == -1)
            buttonExcluir.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCancelar : {
                finish();
                break;
            }
            case R.id.buttonExcluir : {
                usuario.excluir();
                finish();
                break;
            }
            case R.id.buttonSalvar :{
                boolean valido = true;
                usuario.setNome(editTextNome.getText().toString().trim());
                usuario.setEmail(editTextEmail.getText().toString().trim().toLowerCase());
                usuario.setSenha(editTextSenha.getText().toString().trim());


                if (usuario.getNome().equals("")){
                    editTextNome.setError(getString(R.string.obrigatorio));
                    valido = false;
                }
                if (usuario.getEmail().equals("")){
                    editTextEmail.setError(getString(R.string.obrigatorio));
                    valido = false;
                }

                if (usuario.getSenha().equals("")){
                    editTextSenha.setError(getString(R.string.obrigatorio));
                    valido = false;
                }



                if (valido){
                    usuario.salvar();
                    finish();
                }
                break;
            }
        }
    }
}
