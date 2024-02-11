package com.ugb.calculadora_proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView num;
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalc = findViewById(R.id.btnCalcular);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num = findViewById(R.id.num1);
                double num1 = Double.parseDouble(num.getText().toString());

                num = findViewById(R.id.num2);
                double num2 = Double.parseDouble(num.getText().toString());

                double respuesta = 0;

                RadioGroup opt = findViewById(R.id.radioOpciones);

                int checkedRadioButtonId = opt.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.suma) {
                    respuesta = num1 + num2;
                } else if (checkedRadioButtonId == R.id.btnRESTA) {
                    respuesta = num1 - num2;
                } else if (checkedRadioButtonId == R.id.btnMULTI) {
                    respuesta = num1 * num2;
                } else if (checkedRadioButtonId == R.id.btnDIV) {
                    respuesta = num1 / num2;
                } else if (checkedRadioButtonId == R.id.btnPERCENT) {
                    respuesta = num1 - (num1 * (num2/100));
                } else if (checkedRadioButtonId == R.id.btnEXPO) {
                    respuesta = Math.pow(num1,num2);
                } else if (checkedRadioButtonId == R.id.btnFACTO) {
                    double factorial = 1;
                    for (int i = 1; i <= num1; i++) {
                        factorial *= i;
                        respuesta = factorial;
                    }
                } else if (checkedRadioButtonId == R.id.btnRAIZ) {
                    respuesta = Math.round(Math.pow(num1, 1.0 / num2));
                }

                num = findViewById(R.id.lblRespuesta);
                num.setText("Respuesta: " + respuesta);
            }
        });
    }
}
