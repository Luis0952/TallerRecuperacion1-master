package com.taller.tallerrecuperacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.taller.tallerrecuperacion.Helpers.SqliteHelper;

public class InformationActivity extends AppCompatActivity {

    TextView textViewId;
    TextView textViewName;
    TextView textViewProcedencia;
    TextView textViewTipo;
    TextView textViewIngredientes;
    SqliteHelper sqliteHelper;

    Integer idContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);


        textViewId = (TextView) findViewById(R.id.id_tv_item_id2);
        textViewName = (TextView) findViewById(R.id.id_tv_item_name2);
        textViewProcedencia = (TextView) findViewById(R.id.id_tv_item_procedencia2);
        textViewTipo = (TextView) findViewById(R.id.id_tv_item_tipo2);
        textViewIngredientes = (TextView) findViewById(R.id.id_tv_item_ingredientes2);

        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);

       // idContact = Integer.parseInt(getIntent().getExtras().getString("id"));

        textViewId.setText( getIntent().getExtras().getString("id") );
        textViewName.setText( getIntent().getExtras().getString("name") );
        textViewProcedencia.setText( getIntent().getExtras().getString("procedencia") );
        textViewTipo.setText( getIntent().getExtras().getString("tipo") );


        textViewIngredientes.setText( getIntent().getExtras().getString("ingredientes") );

    }


    public void onClickRegresar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
