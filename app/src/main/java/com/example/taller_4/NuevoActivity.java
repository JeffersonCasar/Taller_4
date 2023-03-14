package com.example.taller_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taller_4.DB.DbContactos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtNombre, txtApellido, txtCodigo;
    Button btnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtCodigo = findViewById(R.id.txtCodigo);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                long id = dbContactos.insertarContactos(txtNombre.getText().toString(), txtApellido.getText().toString(), txtCodigo.getText().length());

                if ( id >0){
                    Toast.makeText(NuevoActivity.this, "El registro se guardo", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else{
                    Toast.makeText(NuevoActivity.this, "No se guardo el dregistro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCodigo.setText("");
    }
}