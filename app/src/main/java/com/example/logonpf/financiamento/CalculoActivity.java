package com.example.logonpf.financiamento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CalculoActivity extends AppCompatActivity {

    private TextView txtCalculo;

    private double calculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        txtCalculo = (TextView) findViewById(R.id.txtCalculo);

        Bundle param = getIntent().getExtras();
        double v = param.getDouble("valor");
        int p = param.getInt("parcelas");
        float j = param.getFloat("juros");

        calculo = v * p * j;

        txtCalculo.setText(String.valueOf(calculo));

    }

    @Override
    public void finish() {

        Intent ret = new Intent();
        ret.putExtra("calculo", calculo);
        setResult(RESULT_OK, ret);

        super.finish();
    }
}
