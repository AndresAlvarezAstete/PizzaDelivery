package com.example.login_act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import Clases.Datos;

public class Promociones_act extends AppCompatActivity
{
    private Spinner spin;
    private EditText editTxt, editTxt1;
    private Button button;
    private TextView viewTxt, viewTxt1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        spin = (Spinner)findViewById(R.id.spin);
        editTxt = (EditText)findViewById(R.id.editTxt);
        editTxt1 = (EditText)findViewById(R.id.editTxt1);
        button = (Button)findViewById(R.id.button);
        viewTxt = (TextView)findViewById(R.id.viewTxt);
        viewTxt1 = (TextView)findViewById(R.id.viewTxt1);

        ArrayList<String> listaClientes = (ArrayList<String>)getIntent().getSerializableExtra("listaClientes");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        spin.setAdapter(adapt);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Datos datos = new Datos();
                String clientes = spin.getSelectedItem().toString();
                String promociones = editTxt.getText().toString();

                int envio = 0;
                envio = Integer.parseInt(editTxt1.getText().toString());
                DecimalFormat formatea = new DecimalFormat("###,###.##");
                boolean flag = false;

                if (clientes == "" && promociones == "" && envio == 0)
                {
                    Toast.makeText(view.getContext(), "Debes ingresar datos válidos", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (clientes.equals("Ramiro") && (promociones.equalsIgnoreCase("Pizza Promo")))
                    {
                        viewTxt.setText("Estimado Ramiro el final según promoción y envío es:");
                        viewTxt1.setText("$" + (formatea.format(datos.getPizzaPromo() + envio)));
                        flag = true;
                    }

                    if (clientes.equals("Ramiro") && (promociones.equalsIgnoreCase("Master Pizza")))
                    {
                        viewTxt.setText("Estimado Ramiro el final según promoción y envío es:");
                        viewTxt1.setText("$" + (formatea.format(datos.getMasterPizza() + envio)));
                        flag = true;
                    }

                    if (clientes.equals("Ramiro") && (promociones.equalsIgnoreCase("Pizza Max")))
                    {
                        viewTxt.setText("Estimado Ramiro el final según promoción y envío es:");
                        viewTxt1.setText("$" + (formatea.format(datos.getPizzaMax() + envio)));
                        flag = true;
                    }

                    if (clientes.equals("Rosa") && (promociones.equalsIgnoreCase("Pizza Promo")))
                    {
                        viewTxt.setText("Estimada Rosa el final según promoción y envío es:");
                        viewTxt1.setText("$" + (formatea.format(datos.getPizzaPromo() + envio)));
                        flag = true;
                    }

                    if (clientes.equals("Rosa") && (promociones.equalsIgnoreCase("Master Pizza")))
                    {
                        viewTxt.setText("Estimada Rosa el final según promoción y envío es:");
                        viewTxt1.setText("$" + (formatea.format(datos.getMasterPizza() + envio)));
                        flag = true;
                    }

                    if (clientes.equals("Rosa") && (promociones.equalsIgnoreCase("Pizza Max")))
                    {
                        viewTxt.setText("Estimada Rosa el final según promoción y envío es:");
                        viewTxt1.setText("$" + (formatea.format(datos.getPizzaMax() + envio)));
                        flag = true;
                    }

                    if (clientes.equals("Robert") && (promociones.equalsIgnoreCase("Pizza Promo")))
                    {
                        viewTxt.setText("Estimado Robert el final según promoción y envío es:");
                        viewTxt1.setText("$" + (formatea.format(datos.getPizzaPromo() + envio)));
                        flag = true;
                    }

                    if (clientes.equals("Robert") && (promociones.equalsIgnoreCase("Master Pizza")))
                    {
                        viewTxt.setText("Estimado Robert el final según promoción y envío es:");
                        viewTxt1.setText("$" + (formatea.format(datos.getMasterPizza() + envio)));
                        flag = true;
                    }

                    if (clientes.equals("Robert") && (promociones.equalsIgnoreCase("Pizza Max")))
                    {
                        viewTxt.setText("Estimado Robert el final según promoción y envío es:");
                        viewTxt1.setText("$" + (formatea.format(datos.getPizzaMax() + envio)));
                        flag = true;
                    }

                    if(!flag)
                    {
                        Toast.makeText(view.getContext(), "Debes ingresar datos válidos", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}