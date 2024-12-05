package com.example.calculadoraequacaosegundograu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText valor1;
    private Button calcular;
    private TextView valorx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Resposta), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        valor1 = findViewById(R.id.valor1);

        valorx1 = findViewById(R.id.valorx1);

        calcular = findViewById(R.id.calcular);
        calcular.setOnClickListener(op -> calc());
    }

    public void calc(){
        double a = Float.parseFloat(valor1.getText().toString());

        if (a == (int) a && a>1 && a<=1000) {

            int valor = (int) a;
            String velorBinario = Integer.toBinaryString(valor);
            valorx1.setText("Numero Convertido para binario: "+velorBinario);

        } else {
            valorx1.setText("Por favor, digite um valor maior que 1 e menor ou igual a 1000.");
        }
    }

}