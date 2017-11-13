package com.taller.tallerrecuperacion.Utilities;

/**
 * Created by Luis Eduardo on 13/11/2017.
 */

public class Constants {

    public static final String TABLA_NAME_COMIDA = "comida";
    public static final String TABLA_FIELD_ID = "id";
    public static final String TABLA_FIELD_NAME = "name";
    public static final String TABLA_FIELD_PROCEDENCIA = "procedencia";
    public static final String TABLA_FIELD_TIPO = "tipo";
    public static final String TABLA_FIELD_INGREDIENTES = "ingredientes";
    public static final String CREATE_TABLE_COMIDA =
            "CREATE TABLE "+ TABLA_NAME_COMIDA+" ("+
                    TABLA_FIELD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_NAME+" TEXT, "+
                    TABLA_FIELD_PROCEDENCIA+" TEXT, "+
                    TABLA_FIELD_TIPO+" TEXT, "+
                TABLA_FIELD_INGREDIENTES+" TEXT)";

}
