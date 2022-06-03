package com.example.othmanechafak201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class all extends AppCompatActivity {
    ListView liste;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        liste=findViewById(R.id.ls);
        db=new MyDatabase(this);
        ArrayList<Societe> e =MyDatabase.getall(db.getReadableDatabase());
        ArrayList<HashMap<String,Object>> h = new ArrayList<>();
        for(Societe soc : e){
            HashMap<String,Object> b =new HashMap<>();
            b.put("raison",soc.getRaison_sociale());
            b.put("nb_employe",soc.getNbemploye());
            h.add(b);
        }
        String[] from = {"raison","nb_employe"};
        int [] to ={R.id.traison,R.id.tnombredemploye};
        SimpleAdapter b = new SimpleAdapter(this,h,R.layout.societe,from,to);
        liste.setAdapter(b);
    }
}