package com.example.othmanechafak201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ajouter extends AppCompatActivity {

    EditText e1,e2,e3;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);

        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        db=new MyDatabase(this);



    }

    public void annuler(View view) {
        finish();
    }

    public void enregistrer(View view) {
        Societe p = new Societe();

        p.setRaison_sociale(e1.getText().toString());
        p.setSecteur(e2.getText().toString());
        p.setNbemploye(Integer.valueOf(e3.getText().toString()));

        if(MyDatabase.addsociete(db.getWritableDatabase(),p)==-1)
            Toast.makeText(this, "Insertion echoue", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Insertion reussie", Toast.LENGTH_SHORT).show();
    }
}