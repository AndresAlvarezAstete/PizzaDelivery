package com.example.login_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity
{
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        video = (VideoView)findViewById(R.id.video);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);

        MediaController media = new MediaController(this);
        video.setMediaController(media);
    }

    public void Promociones(View view)
    {
        Lista();
    }

    public void Clientes(View view)
    {
        Intent i = new Intent(this, Firebase_act.class);
        startActivity(i);
    }

    public void Lista()
    {
        ArrayList<String> clientes = new ArrayList<String>();

        clientes.add("Seleccione Cliente");
        clientes.add("Ramiro");
        clientes.add("Rosa");
        clientes.add("Robert");

        Intent i = new Intent(this, Promociones_act.class);
        i.putExtra("listaClientes", clientes);
        startActivity(i);
    }
}