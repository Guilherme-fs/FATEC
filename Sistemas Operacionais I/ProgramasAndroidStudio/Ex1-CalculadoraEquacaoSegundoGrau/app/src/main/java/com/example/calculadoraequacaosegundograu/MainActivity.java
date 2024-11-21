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
    private EditText valor2;
    private EditText valor3;
    private Button calcular;
    private TextView valorx1;
    private TextView valorx2;

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
        valor2 = findViewById(R.id.valor2);
        valor3 = findViewById(R.id.valor3);

        valorx1 = findViewById(R.id.valorx1);
        valorx2 = findViewById(R.id.valorx2);

        calcular = findViewById(R.id.calcular);
        calcular.setOnClickListener(op -> calc());
    }

    public void calc(){
        double a = Float.parseFloat(valor1.getText().toString());
        double b = Float.parseFloat(valor2.getText().toString());
        double c = Float.parseFloat(valor3.getText().toString());

        Controller controller = new Controller(a, b, c);

        if (controller.calcularDelta() >= 0) {

            //Exibindo resultado dentro da textView
            valorx1.setText("x1 = " + controller.calcularx1());
            valorx2.setText("x2 = " + controller.calcularx2());

        } else {
            valorx1.setText("Delta não possui raiz!");
            //System.exit(0);
        }
    }

}