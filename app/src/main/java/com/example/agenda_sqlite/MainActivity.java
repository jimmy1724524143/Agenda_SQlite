package com.example.agenda_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre,txtTelefono,txtCorreo;
    Button btnAgregar,btnMostrar,btnBuscar,btnEditar,btneEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre=(EditText) findViewById(R.id.txtNombre);
        txtTelefono=(EditText) findViewById(R.id.txtTelefono);
        txtCorreo=(EditText) findViewById(R.id.txtCorreo);

        btnAgregar=(Button) findViewById(R.id.btnAgregar);
        btnMostrar=(Button) findViewById(R.id.btnMostrar);
        btnBuscar=(Button) findViewById(R.id.btnBuscar);
        btnEditar=(Button) findViewById(R.id.btnEditar);
        btneEliminar=(Button) findViewById(R.id.btnEliminar);


        final DeveloperBD developerBD=new DeveloperBD(getApplicationContext());

        btnAgregar.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!txtNombre.getText().toString().isEmpty()) {

                    developerBD.agregarContactos(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreo.getText().toString());
                    Toast.makeText(getApplicationContext(), "SE AGREGO CORRECTAMENTE", Toast.LENGTH_SHORT).show();

                    txtNombre.setText("");
                    txtTelefono.setText("");
                    txtCorreo.setText("");

                } else {

                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

            }
            }
        });




        btnMostrar.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarCursos=new Intent(getApplicationContext(),CursosActivity.class);
                startActivity(mostrarCursos);

            }
        });



        btnBuscar.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CursosModelos cursos=new CursosModelos() ;
                developerBD.buscarCursos(cursos,txtNombre.getText().toString());
                txtTelefono.setText(cursos.getTelefono() );
                txtCorreo.setText(cursos.getCorreo());


            }
        });


        btnEditar.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
            developerBD.editarCurso(txtNombre.getText().toString(),txtTelefono.getText().toString(),txtCorreo.getText().toString());

                Toast.makeText(getApplicationContext(),"SE MODIFICO CORRECTAMENTE",Toast.LENGTH_SHORT).show();




            }
        });




        btneEliminar.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                developerBD.eliminarCurso(txtNombre.getText().toString());

                Toast.makeText(getApplicationContext(),"ELIMINADO CORRECTAMENTE",Toast.LENGTH_SHORT).show();



            }
        });




    }
}