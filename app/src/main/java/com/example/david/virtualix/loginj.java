package com.example.david.virtualix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginj extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button boton = (Button) findViewById(R.id.login);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = ((EditText) findViewById(R.id.id)).getText().toString();
                String contraseña = ((EditText) findViewById(R.id.pass)).getText().toString();
                if (usuario.equals("admin") && contraseña.equals("admin"))
                {
                    Intent nuevoform  = new Intent(loginj.this, index.class);
                    startActivity(nuevoform);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Usuario incorrecto", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
