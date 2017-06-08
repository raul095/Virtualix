package com.example.david.virtualix;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class menu3 extends Fragment {

    private EditText et1,et2;
    private Button btn1,btn2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.misnotas, container, false);

        // Asignación de elementos
        et1=(EditText)view.findViewById(R.id.et1);
        et2=(EditText)view.findViewById(R.id.et2);
        btn1=(Button)view.findViewById(R.id.button);
        btn2=(Button)view.findViewById(R.id.button2);


        // Actividades de los botones o acciones
        // GUARDAR
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomarchivo=et1.getText().toString();
                nomarchivo=nomarchivo.replace('/','-');
                try {
                    FileOutputStream fos = getActivity().openFileOutput(nomarchivo, Activity.MODE_PRIVATE);
                    OutputStreamWriter archivo = new OutputStreamWriter(fos);
                    archivo.write(et2.getText().toString());
                    archivo.flush();
                    archivo.close();
                } catch (IOException e) {
                }
                Toast t = Toast.makeText(getActivity(), "La nota ha sido guardada correctamente ",Toast.LENGTH_SHORT);
                t.show();
                et1.setText("");
                et2.setText("");
            }
        });

        // RECUPERAR
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomarchivo=et1.getText().toString();
                nomarchivo=nomarchivo.replace('/','-');
                boolean enco=false;
                String[] archivos = getActivity().fileList();
                for (int f = 0; f < archivos.length; f++)
                    if (nomarchivo.equals(archivos[f]))
                        enco= true;
                if (enco==true) {
                    try {
                        InputStreamReader archivo = new InputStreamReader(getActivity().openFileInput(nomarchivo));
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
                    Toast.makeText(getActivity(),"No hay notas guardadas con ese título", Toast.LENGTH_LONG).show();
                    et2.setText("");
                }
            }
        });

        return view;
    }




}
