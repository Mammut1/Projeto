package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.teste.BdHelper.DbHelper;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {
    private EditText edNome;
    private EditText edEndereco;
    private EditText edEmail;
    private EditText edSenha;
    private Button btn1;
    private Button btn2;
    DbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edNome = (EditText) findViewById(R.id.edNome);
        edEndereco = (EditText) findViewById(R.id.edEndereco);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edSenha = (EditText) findViewById(R.id.edSenha);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1 = (Button) findViewById(R.id.btn1);
        db = new DbHelper(this);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                btn2Activity();
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1Activity();
            }
        });
    }

    private void btn2Activity() { startActivity(new Intent( MainActivity.this, Maps.class));
    }

    private void btn1Activity() {
        startActivity(new Intent(MainActivity.this, Cadastro.class ));
    }

}



