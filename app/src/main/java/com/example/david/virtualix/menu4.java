package com.example.david.virtualix;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class menu4 extends Fragment {

    Calculadora calculadora;
    //Atributos para los elementos graficos de la interfaz de usuario
    TextView textViewRes;
    Button buttonCalcula;
    Spinner spinnerOperation;
    TextView editTextFirst;
    TextView editTextSecond;
    public enum Operaciones{Sumar, Restar, Multiplicar, Dividir}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculadora, container, false);

        // INICIALIZACION DE OBJETOS
        calculadora = new Calculadora();


        // INICIALIZACION DE ELEMENTOS GRAFICOS
        //Asignamos los componentes graficos
        textViewRes = (TextView) view.findViewById(R.id.textViewRes);
        buttonCalcula = (Button) view.findViewById(R.id.buttonCalcula);
        spinnerOperation = (Spinner) view.findViewById(R.id.spinnerOperation);
        editTextFirst = (EditText) view.findViewById(R.id.editTextFirst);
        editTextSecond = (EditText) view.findViewById(R.id.editTextSecond);


        // EVENTOS DE LOS ELEMENTOS GRAFICOS
        // Asignamos el listener al boton (en este caso la propia clase)
        buttonCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.buttonCalcula) {
                    Log.v("Test", "Boton pulsado");
                    Toast.makeText(getActivity(), "Operación realizada", Toast.LENGTH_SHORT).show();
                    textViewRes.setText(calcula());
                }// if
            }
        });

        // CARGA Y/O ACCIONES INICIALES
        loadSpinner();

        return view;
    }

    private void loadSpinner() {
        // Creamos un ArrayAdapter usando el string array y el layout del spinner.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.operationsArray, android.R.layout.simple_spinner_item);
        // Decimos que layaout se usará cuando se se seleccione el spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Se alica el adaptador al spinner
        spinnerOperation.setAdapter(adapter);
    }// loadSpinner



    private String calcula() {
        double op1, op2;
        String value1, value2, res;
        // Obtenemos el valor de los operadores
        value1 = editTextFirst.getText().toString();
        value2 = editTextSecond.getText().toString();
        // Comprobamos que se ha introducido algún valor numérico
        if (value1.matches("") || value2.matches("")) {
            //Mostramos por el LogCat un mensaje
            Log.d("Prueba", spinnerOperation.getSelectedItem().toString());
            // Mostramos un mensaje de notificación al usuario
            Toast.makeText(getActivity(), "Introduce los valores", Toast.LENGTH_SHORT).show();
            res = "Introduce los operadores numéricos";
            return res;
        } else {
            // Obtenemos los valores numéricos de los operaderos
            calculadora.setOperador1(Double.parseDouble(editTextFirst.getText().toString()));
            calculadora.setOperador2(Double.parseDouble(editTextSecond.getText().toString()));
            // Sacamos el tipo de operacién seleccionada por el usuario
            menu4.Operaciones op = menu4.Operaciones.valueOf(spinnerOperation.getSelectedItem().toString());

            switch (op) {
                case Sumar:
                    res = "" + calculadora.suma();
                    break;
                case Restar:
                    res = "" + calculadora.resta();
                    break;
                case Dividir:
                    res = "" + calculadora.divide();
                    break;
                case Multiplicar:
                    res = "" + calculadora.multiplica();
                    break;
                default:
                    res = "Otras operaciones no soportadas";
                    break;
            } //switch
            return res;
        }// if
    }// calcula
}
