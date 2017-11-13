package com.taller.tallerrecuperacion;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.taller.tallerrecuperacion.Adapters.ComidaAdapter;
import com.taller.tallerrecuperacion.Helpers.SqliteHelper;
import com.taller.tallerrecuperacion.Models.ComidaModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewContacts;
  ComidaAdapter contactAdapter;
    List<ComidaModel> contactList = new ArrayList<>();
        SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewContacts = (RecyclerView) findViewById(R.id.id_rv_contacts);
        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewContacts.setLayoutManager(linearLayoutManager);
        listContacts();
    }


    public void onClickShowWindowRegister(View view){
        Intent intent = new Intent(this, RegistrarActivity.class);
        startActivity(intent);
    }



    public void listContacts(){
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select id,name,procedencia,tipo,ingredientes from comida order by id desc", null);

        while (cursor.moveToNext()){
            ComidaModel contact = new ComidaModel();
            contact.setId(cursor.getInt(0));
            contact.setName(cursor.getString(1));
            contact.setProcedencia(cursor.getString(2));
           contact.setTipo(cursor.getString(3));
            contact.setIngredientes(cursor.getString(4));
            contactList.add(contact);
        }

        cursor.close();

        if (contactList.size() != 0){
            processData();
        }else{
            Toast.makeText(this, "Lista vacia", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData(){
        contactAdapter = new ComidaAdapter(contactList, getApplicationContext());
        recyclerViewContacts.setAdapter(contactAdapter);
    }

}
