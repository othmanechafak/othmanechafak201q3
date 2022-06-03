package com.example.othmanechafak201;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper{

    public static String DB_NAME="societes.db";
    public static String TABLE_NAME="societe";
    public static String COL1="id";
    public static String COL2="Raison_social";
    public static String COL3="secteur_activite";
    public static String COL4=" nb_employe";
    public MyDatabase(Context c){
        super(  c,DB_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public static long addsociete(SQLiteDatabase sqLiteDatabase,Societe s ){
        ContentValues c =new ContentValues();
        c.put(COL2,s.getRaison_sociale());
        c.put(COL3,s.getSecteur());
        c.put(COL4,s.getNbemploye());

        return  sqLiteDatabase.insert(TABLE_NAME,null,c);
    }
    public static   long update_societe(SQLiteDatabase sqLiteDatabase,Societe s){
        ContentValues c =new ContentValues();
        c.put(COL2,s.getRaison_sociale());
        c.put(COL3,s.getSecteur());
        c.put(COL4,s.getNbemploye());
        return sqLiteDatabase.update(TABLE_NAME,c,"id"+s.getId(),null);

    }
    public static long delete_societe(SQLiteDatabase sqLiteDatabase,int i){
        return sqLiteDatabase.delete(TABLE_NAME,"id="+i,null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public static ArrayList<Societe> getall(SQLiteDatabase sqLiteDatabase){
        ArrayList<Societe> societes =new ArrayList<>();
        Cursor c =sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        while (c.moveToNext()){
            Societe soc=new Societe();
            soc.setId(c.getInt(0));
            soc.setRaison_sociale(c.getString(1));
            soc.setSecteur(c.getString(2));
            soc.setNbemploye(c.getInt(3));
            societes.add(soc);
        }
        return societes;
    }
    public  static Societe getOneSociete(SQLiteDatabase sqLiteDatabase,int i){
        Societe s=null;
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+"WHERE id="+i,null);
        while(c.moveToNext()){
            s=new Societe();
            s.setId(c.getInt(0));
            s.setRaison_sociale(c.getString(1));
            s.setSecteur(c.getString(2));
            s.setNbemploye(c.getInt(3));

        }
        return s;

    }
}
