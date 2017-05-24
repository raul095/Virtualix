package com.example.david.virtualix;

import android.os.Bundle;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
        //Asignamos el listener al boton (en este caso la propia clase)
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
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.operationsArray, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerOperation.setAdapter(adapter);
    }// loadSpinner

    private String calcula() {
        double op1, op2;
        String value1, value2, res;
        //Obtenemos el valor de los operadores
        value1 = editTextFirst.getText().toString();
        value2 = editTextSecond.getText().toString();
        //Comprobamos que se ha introducido algun valor numerico
        if (value1.matches("") || value2.matches("")) {
            //Mostramos por el LogCat un mensaje
            Log.d("Prueba", spinnerOperation.getSelectedItem().toString());
            //Mostramos un mensaje vol�til en forma de Toast al usuario
            Toast.makeText(getActivity(), "Introduce los valores", Toast.LENGTH_SHORT).show();
            res = "Introduce los operadores numéricos";
            return res;
        } else {
            //Obtenemos los valores numericos de los operaderos
            calculadora.setOperador1(Double.parseDouble(editTextFirst.getText().toString()));
            calculadora.setOperador2(Double.parseDouble(editTextSecond.getText().toString()));
            //Sacamos el tipo de operacion seleccionada por el usuario
            MainActivity.Operaciones op = MainActivity.Operaciones.valueOf(spinnerOperation.getSelectedItem().toString());

            switch (op) {
                case Suma:
                    res = "" + calculadora.suma();
                    break;
                case Resta:
                    res = "" + calculadora.resta();
                    break;
                case Divide:
                    res = "" + calculadora.divide();
                    break;
                case Multiplica:
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
