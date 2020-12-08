package com.example.teste.BdHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String NOME_BD = "db";
    private static final int VERSAO_BD = 1;


    public DbHelper(Context ctx) {
        super(ctx, NOME_BD, null, VERSAO_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table usuario(_id integer primary key autoincrement, nome text not null,endereco text not null, email text not null, senha text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("drop table usuario;");
    }

    public boolean inserir(String nome, String endereco, String email, String senha) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", nome);
        contentValues.put("endereco", endereco);
        contentValues.put("email", email);
        contentValues.put("senha", senha);
        long result = db.insert("Usuario", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public boolean checkNome(String nome) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from usuario where nome = ?", new String[]{nome});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkEndereco(String nome, String endereco) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from usuario where nome= ? and endereco= ?", new String[]{nome, endereco});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public boolean checkEmail(String nome, String endereco, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from usuario where nome= ? and endereco = ? and email = ?", new String[]{nome, endereco, email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkEmail(String nome, String endereco, String email, String senha) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from usuario where nome= ? and endereco = ? and email = ? and senha = ?", new String[]{nome, endereco, email, senha});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}