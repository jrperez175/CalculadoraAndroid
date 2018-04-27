package co.com.ceiba.calculadora;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import co.com.ceiba.calculatordomain.features.calculator.CalculatorDomain;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText operador1 = findViewById(R.id.operador1);
        final EditText operador2 = findViewById(R.id.operador2);
        Button sumar = findViewById(R.id.suma);
        final Button restar = findViewById(R.id.restar);
        Button multiplicar = findViewById(R.id.multiplicar);
        Button dividir = findViewById(R.id.dividir);
        final TextView resultado = findViewById(R.id.resultado);

        final CalculatorDomain domain = new CalculatorDomain();

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(domain.add(Integer.parseInt(operador1.getText().toString()), Integer.parseInt(operador2.getText().toString()))+"");
            }
        });

        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(domain.substract(Integer.parseInt(operador1.getText().toString()), Integer.parseInt(operador2.getText().toString()))+"");
            }
        });

        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(domain.mulplicate(Integer.parseInt(operador1.getText().toString()), Integer.parseInt(operador2.getText().toString()))+"");
            }
        });

        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    resultado.setText(domain.divide(Integer.parseInt(operador1.getText().toString()), Integer.parseInt(operador2.getText().toString())) + "");
                }catch (Exception e){
                    resultado.setText(e.getMessage());
                }
            }
        });
    }

}
