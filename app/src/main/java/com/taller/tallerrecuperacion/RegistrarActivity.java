package com.taller.tallerrecuperacion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.taller.tallerrecuperacion.Helpers.SqliteHelper;
import com.taller.tallerrecuperacion.Utilities.Constants;

public class RegistrarActivity extends AppCompatActivity {
    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextProcedencia;
    TextInputEditText textInputEditTextTipo;
    TextInputEditText textInputEditTextingredientes;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);


        textInputEditTextName = (TextInputEditText) findViewById(R.id.id_tv_detail_name);
        textInputEditTextProcedencia = (TextInputEditText) findViewById(R.id.id_tv_detail_procedencia);
        textInputEditTextTipo = (TextInputEditText) findViewById(R.id.id_tv_detail_tipo);
        textInputEditTextingredientes = (TextInputEditText) findViewById(R.id.id_tv_detail_Ingredientes);
        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);

    }


    public void onClickCreateUser(View view){
        String stringName = textInputEditTextName.getText().toString();
        String stringProcedencia = textInputEditTextProcedencia.getText().toString();
        String stringTipo = textInputEditTextTipo.getText().toString();
        String stringIngredientes = textInputEditTextingredientes.getText().toString();

        if (TextUtils.isEmpty(stringName)){
            Toast.makeText(this, "El campo de NOMBRE esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringProcedencia)){
            Toast.makeText(this, "El campo de PROCEDENCIA esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringTipo)){
            Toast.makeText(this, "El campo de TIPO esta vacio", Toast.LENGTH_SHORT).show();

        }else if (TextUtils.isEmpty(stringIngredientes)) {
            Toast.makeText(this, "El campo de INGREDIENTES esta vacio", Toast.LENGTH_SHORT).show();

        } else{
            createUser();
        }
    }

    public void createUser(){
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.TABLA_FIELD_NAME, textInputEditTextName.getText().toString());
        values.put(Constants.TABLA_FIELD_PROCEDENCIA, textInputEditTextProcedencia.getText().toString());
        values.put(Constants.TABLA_FIELD_TIPO, textInputEditTextTipo.getText().toString());
        values.put(Constants.TABLA_FIELD_INGREDIENTES, textInputEditTextingredientes.getText().toString());

        Long idResult = db.insert(Constants.TABLA_NAME_COMIDA, Constants.TABLA_FIELD_ID, values);

        textInputEditTextName.setText("");
        textInputEditTextProcedencia.setText("");
        textInputEditTextTipo.setText("");
        textInputEditTextingredientes.setText("");
        Toast.makeText(this, "comida registrada", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
