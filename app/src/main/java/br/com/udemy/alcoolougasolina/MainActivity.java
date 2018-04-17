package br.com.udemy.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String RESULT_GASOLINA = "Melhor usar Gasolina!";
    public static final String RESULT_ALCOOL = "Melhor usar Alcool!";
    public static final String CAMPOS_VAZIOS = "Falta digitar os campos";
    EditText precoAlcool;
    EditText precogasolina;
    TextView resultado;
    Button botaoResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

        getPreencherCampos();

    }

    private void inicializarComponentes() {
        precoAlcool = findViewById(R.id.main_edit_preco_alcool);
        precogasolina = findViewById(R.id.main_edit_preco_gasolina);
        botaoResult = findViewById(R.id.main_button_calc);
        resultado = findViewById(R.id.main_text_result);
    }

    private void getPreencherCampos() {
        botaoResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String precoAlcoolText = precoAlcool.getText().toString();
                String precoGasolinaText = precogasolina.getText().toString();
                calcularValor(precoAlcoolText, precoGasolinaText);
            }

        });
    }

    private void calcularValor(String pAlcool, String pGasolina) {
        if (validarCampos(pAlcool, pGasolina)) {
            Double valorAlcool = Double.parseDouble(pAlcool);
            Double valorGasolina = Double.parseDouble(pGasolina);
            Double resultadoDouble = valorAlcool / valorGasolina;

            if (resultadoDouble >= 0.7) {
                resultado.setText(RESULT_GASOLINA);
            } else {
                resultado.setText(RESULT_ALCOOL);
            }

        } else {
            resultado.setText(CAMPOS_VAZIOS);
        }
    }

    private boolean validarCampos(String precoAlcoolText, String precoGasolinaText) {
        boolean camposValidados = true;

        if (precoAlcoolText == null || precoAlcoolText.equals("")) {
            camposValidados = false;
        } else if (precoGasolinaText == null || precoGasolinaText.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }
}
