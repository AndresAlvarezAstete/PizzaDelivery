package com.example.login_act;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Models.Clientes;

public class ListadoClientes_act extends AppCompatActivity
{
    private ListView list;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    private ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();

    Clientes clienteSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes_act);

        list = (ListView)findViewById(R.id.list);

        IniciarBase();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                clienteSelected = (Clientes) parent.getItemAtPosition(position);
            }
        });

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                for (DataSnapshot op: snapshot.getChildren())
                {
                    Clientes client = op.getValue(Clientes.class);

                    listaClientes.add(client);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listaClientes);
                    list.setAdapter(adapt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
    }

    public void Eliminar(View view)
    {
        Clientes client = new Clientes();
        client.setId(clienteSelected.getId());
        databaseReference.child("Clientes").child(client.getId()).removeValue();
        Toast.makeText(getBaseContext(), "Se ha eliminado un cliente", Toast.LENGTH_LONG).show();
    }

    public void IniciarBase()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}