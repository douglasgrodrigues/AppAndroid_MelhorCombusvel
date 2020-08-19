package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina; // Após criar o id, declaramos aqui no inicio do código
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool); //Após declarar no inicio do código, fazemos a referencia dentro do Oncreate
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){
        String precoAlcool = editPrecoAlcool.getText().toString();       //Captura os valores digitados
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if ( camposValidados ){
            Double valorAlcool = Double.parseDouble( precoAlcool );
            Double valorGasolina = Double.parseDouble( precoGasolina );

            Double resultado = valorAlcool / valorGasolina;
            if ( resultado >= 0.7 ){
                textResultado.setText("Melhor opção: Gasolina");
            }else {
                textResultado.setText("Melhor opção: Álcool");
            }



        }else{
            textResultado.setText("Prencha os campos primeiro");
        }

    }

    public Boolean validarCampos( String pAlcool , String pGasolina){

        Boolean camposValidados = true;

        if ( pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }else if ( pGasolina == null || pGasolina.equals("") ){
            camposValidados = false;
        }

        return camposValidados;
    }


}
