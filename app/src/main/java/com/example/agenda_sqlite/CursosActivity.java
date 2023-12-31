package com.example.agenda_sqlite;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CursosActivity extends AppCompatActivity {

    private RecyclerView recyclerViewContacto;
    private CursosAdaptador contactoAdaptador;

@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contactos);

    recyclerViewContacto=(RecyclerView) findViewById(R.id.recycleContactos);
    recyclerViewContacto.setLayoutManager(new LinearLayoutManager(this));


     DeveloperBD developerBD=new DeveloperBD(getApplicationContext());


    contactoAdaptador=new CursosAdaptador(developerBD.mostrarCursos());
    recyclerViewContacto.setAdapter(contactoAdaptador);
    }


}

