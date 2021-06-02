package com.example.logonpf.financiamento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private EditText edtValor;
    private EditText edtParcelas;
    private EditText edtJuros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        edtValor = (EditText) findViewById(R.id.edtValor);
        edtParcelas = (EditText) findViewById(R.id.edtParcelas);
        edtJuros = (EditText) findViewById(R.id.edtJuros);

    }

    public void calcular(View v) {

        // ler valores informados pelo usuario
        double valor = Double.parseDouble(edtValor.getText().toString());
        int parcelas = Integer.parseInt(edtParcelas.getText().toString());
        float juros = Float.parseFloat(edtJuros.getText().toString());

        // passagem dos valores lidos para CalculoActivity
        Intent i = new Intent(this, CalculoActivity.class);

        i.putExtra("valor", valor);
        i.putExtra("parcelas", parcelas);
        i.putExtra("juros", juros);

        startActivityForResult(i,0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            double ret = data.getExtras().getDouble("calculo");
            Toast.makeText(this, "Juros: " + ret, Toast.LENGTH_LONG).show();
        }

    }
}
