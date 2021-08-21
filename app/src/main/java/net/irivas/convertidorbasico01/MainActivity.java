package net.irivas.convertidorbasico01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String [] opciones = {"Kilometros a Metros", "Metros a Kilometros", "Metros a Centimetros",
                            "Centimetros a Metros", "Metros a Pies", "Pies a Metros"};
    Spinner objSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objSpinner = (Spinner)findViewById(R.id.listaConversion);
        ArrayAdapter<String> elAdaptador = new
                ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,opciones);
        objSpinner.setAdapter(elAdaptador);

        Button elBoton  = (Button) findViewById(R.id.btnCalcular);
        elBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int opcionSeleccionada;
                opcionSeleccionada = objSpinner.getSelectedItemPosition();
                EditText objCantidad = (EditText)findViewById(R.id.txtCantidad);
                TextView objLabel= (TextView)findViewById(R.id.lblResultados);
                Double cantidad = 0.0, resultado = 0.0;
                cantidad = Double.parseDouble(objCantidad.getText().toString());
                String abreviatura="";
                switch (opcionSeleccionada){
                    case 0: //Kilometros a metros
                        resultado = cantidad * 1000;
                        abreviatura = "MTs";
                        break;
                    case 1: //Metros a Kilometros
                        resultado = cantidad / 1000;
                        abreviatura = "KMs";
                        break;
                    case 2: //Metros a Centimetros
                        resultado = cantidad * 100;
                        abreviatura = "CMs";
                        break;
                    case 3: //Centimetros a Metros
                        resultado = cantidad / 100;
                        abreviatura = "MTs";
                        break;
                    case 4: //Metros a Pies
                        resultado = cantidad *  3.281;
                        abreviatura = "FTs";
                        break;
                    case 5: //Pies a Metros
                        resultado = cantidad / 3.281;
                        abreviatura = "MTs";
                        break;
                }
                objLabel.setText("Resultado: "+resultado.toString()+abreviatura);
            }
        });


    }
}