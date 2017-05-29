package com.example.david.virtualix;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class menu3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.misnotas, container, false);
    }

    public class notas extends FragmentActivity {
        //Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        private EditText et1,et2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.misnotas);

            et1=(EditText)findViewById(R.id.et1);
            et2=(EditText)findViewById(R.id.et2);
        }

        public void grabar(View v) {
            String nomarchivo=et1.getText().toString();
            nomarchivo=nomarchivo.replace('/','-');
            try {
                OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                        nomarchivo, Activity.MODE_PRIVATE));
                archivo.write(et2.getText().toString());
                archivo.flush();
                archivo.close();
            } catch (IOException e) {
            }
            Toast t = Toast.makeText(this, "Los datos fueron grabados",
                    Toast.LENGTH_SHORT);
            t.show();
            et1.setText("");
            et2.setText("");
        }

        public void recuperar(View v) {
            String nomarchivo=et1.getText().toString();
            nomarchivo=nomarchivo.replace('/','-');
            boolean enco=false;
            String[] archivos = fileList();
            for (int f = 0; f < archivos.length; f++)
                if (nomarchivo.equals(archivos[f]))
                    enco= true;
            if (enco==true) {
                try {
                    InputStreamReader archivo = new InputStreamReader(
                            openFileInput(nomarchivo));
                    BufferedReader br = new BufferedReader(archivo);
                    String linea = br.readLine();
                    String todo = "";
                    while (linea != null) {
                        todo = todo + linea + "\n";
                        linea = br.readLine();
                    }
                    br.close();
                    archivo.close();
                    et2.setText(todo);
                } catch (IOException e) {
                }
            } else
            {
                Toast.makeText(this,"No hay datos grabados para dicha fecha", Toast.LENGTH_LONG).show();
                et2.setText("");
            }
        }
    }
}
