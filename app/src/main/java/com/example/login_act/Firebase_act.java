package com.example.login_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Models.Clientes;

public class Firebase_act extends AppCompatActivity
{
    private EditText nombreTxt, destinoTxt, promocionTxt;
    private Button guardarBtn, clientesBtn;

    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);

        nombreTxt = (EditText)findViewById(R.id.nombreTxt);
        destinoTxt = (EditText)findViewById(R.id.destinoTxt);
        promocionTxt = (EditText)findViewById(R.id.promocionTxt);
        guardarBtn = (Button)findViewById(R.id.guardarBtn);
        clientesBtn = (Button)findViewById(R.id.clientesBtn);

        InicializarBase();

        guardarBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!nombreTxt.getText().equals(""))
                {
                    Clientes clientes = new Clientes();
                    clientes.setId(UUID.randomUUID().toString());
                    clientes.setNombre(nombreTxt.getText().toString());
                    clientes.setDestino(destinoTxt.getText().toString());
                    clientes.setPromocion(promocionTxt.getText().toString());

                    databaseReference.child("Clientes").child(clientes.getId()).setValue(clientes);

                    Toast.makeText(getBaseContext(), "Se a guardado un cliente", Toast.LENGTH_LONG).show();
                }

                else
                {
                    Toast.makeText(getBaseContext(), "No se a guardado el cliente", Toast.LENGTH_LONG).show();
                }

                Limpiar();
            }
        });
    }

    public void Listado(View view)
    {
        Intent i = new Intent(this, ListadoClientes_act.class);
        startActivity(i);
    }

    public void InicializarBase()
    {
        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
    }

    public void Limpiar()
    {
        nombreTxt.setText("");
        destinoTxt.setText("");
        promocionTxt.setText("");
    }
}