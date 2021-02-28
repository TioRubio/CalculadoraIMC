package com.ifsc.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImcActivity extends AppCompatActivity {
    String nome;
    Double peso, altura;
    TextView tvNome, tvPeso, tvAltura, tvImc;
    DecimalFormat decimalFormat = new DecimalFormat("##,###,###,##0.00");
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Bundle bundle = getIntent().getExtras();
        nome = bundle.getString("nome");
        peso = bundle.getDouble("peso");
        altura = bundle.getDouble("altura");

        tvNome = findViewById(R.id.tvNome);
        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvImc = findViewById(R.id.tvImc);
        textResult = findViewById(R.id.textResult);

    }

    @Override
    protected void onStart() {
        super.onStart();
        tvNome.setText(nome);
        tvAltura.setText(altura.toString());
        tvPeso.setText(peso.toString());
        tvImc.setText(decimalFormat.format(calculaIMC(peso, altura)));

    }

    public Double calculaIMC(Double peso, Double altura) {
        Double imc = peso / (altura * altura);
        if (imc <= 18.5){
           textResult.setText("abaixo do peso");
        }else if(imc >= 18.6 && imc <= 24.9){
            textResult.setText("com o peso ideal");
        }else if(imc >= 25.0 && imc <= 29.9){
            textResult.setText("levemente acima do peso");
        }else if(imc >= 30.0 && imc <= 34.9){
            textResult.setText("obesidade, grau 1");
        }else if(imc >= 35.0 && imc <= 39.9){
            textResult.setText("obesidade, grau II (severa)");
        }else if(imc >= 40.0){
            textResult.setText("Obesidade, grau 3 (mórbida)");
        }
        return imc;
    }


}