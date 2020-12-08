
package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teste.BdHelper.DbHelper;

public class Cadastro extends AppCompatActivity {

    private EditText edNome;
    private EditText edEndereco;
    private EditText edEmail;
    private EditText edSenha;
    private Button btnSalvar;
    DbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edNome = (EditText) findViewById(R.id.edNome);
        edEndereco = (EditText) findViewById(R.id.edEndereco);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edSenha = (EditText) findViewById(R.id.edSenha);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        db = new DbHelper(this);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = edNome.getText().toString();
                String endereco = edEndereco.getText().toString();
                String email = edEmail.getText().toString();
                String pass = edSenha.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(Cadastro.this, "Preencha os campos", Toast.LENGTH_LONG).show();
                else {
                    if (pass.equals(pass)) {
                        boolean checkNome = db.checkNome(user);
                        if (checkNome == false) {
                            boolean insert = db.inserir(user, pass, endereco,email);
                            if (insert == true) {
                                Toast.makeText(Cadastro.this, "Registrado com sucesso", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Maps.class);
                                startActivity(intent);}
                            else{
                                Toast.makeText(Cadastro.this, "Falha no Registro", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Cadastro.this, "Usuário já Registrado", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Cadastro.this, "Senha incorreta", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });


    }
}



