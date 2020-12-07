package com.example.login_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText edTxt, edTxt1;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTxt = (EditText)findViewById(R.id.edTxt);
        edTxt1 = (EditText)findViewById(R.id.edTxt1);
        btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String user = edTxt.getText().toString();
                String pass = edTxt1.getText().toString();

                if (user.equalsIgnoreCase("Android") && pass.equalsIgnoreCase("123"))
                {
                    Intent i = new Intent(getBaseContext(), Menu_act.class);
                    startActivity(i);
                }
                else
                    {
                        Toast.makeText(view.getContext(), "Debes ingresar un usuario y contraseña validos", Toast.LENGTH_LONG).show();
                    }
            }
        });
    }
}