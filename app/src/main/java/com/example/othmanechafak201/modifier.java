package com.example.othmanechafak201;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class modifier extends AppCompatActivity {
    Spinner sp;
    MyDatabase db;
    EditText ed1,ed2,ed3;
    ArrayList<Societe> soc;
    ArrayAdapter n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);
        sp=findViewById(R.id.sp);
        ed1=findViewById(R.id.e1);
        soc= MyDatabase.getall(db.getReadableDatabase());
        ed2=findViewById(R.id.e2);
        ed3=findViewById(R.id.e3);
        db=new MyDatabase(this);
        ArrayList<Societe> a =MyDatabase.getall(db.getReadableDatabase());
        ArrayList<String> societe =new ArrayList<>();
        for(Societe s : a){
            societe.add(s.getId()+"-"+s.getRaison_sociale());
        }
        n = new ArrayAdapter(this,R.layout.activity_modifier,societe);
        sp.setAdapter(n);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Societe p = soc.get(i);
                ed1.setText(p.getRaison_sociale());
                ed2.setText(p.getSecteur());
                ed3.setText(String.format("%f",p.getNbemploye()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void modifier(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(modifier.this);
        alert.setTitle("Modifier produit");
        alert.setMessage("Voulez-vous modifier ce produit ?");
        alert.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Societe e = soc.get(sp.getSelectedItemPosition());

                e.setRaison_sociale(ed1.getText().toString());
                e.setSecteur(ed2.getText().toString());
                e.setNbemploye(Integer.valueOf(ed3.getText().toString()));

                if(MyDatabase.update_societe(db.getWritableDatabase(),e)==-1)
                    Toast.makeText(modifier.this, "Modification echoue", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(modifier.this, "Modification reussie", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(modifier.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }

    public void supprimer(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(modifier.this);
        alert.setTitle("Suppression societe");
        alert.setMessage("Voulez-vous supprimer cette societe ?");

        alert.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Societe s = soc.get(sp.getSelectedItemPosition());

                if(MyDatabase.delete_societe(db.getWritableDatabase(),s.getId())==-1)
                    Toast.makeText(modifier.this, "suppression echoue", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(modifier.this, "Suppression reussie", Toast.LENGTH_SHORT).show();
                    n.remove(s.getId() + " - " + s.getRaison_sociale());
                }
            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(modifier.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}