package mx.edu.tesoem.isc.tsdmh_7s22_252_iasg_p1p4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculoActivity extends AppCompatActivity {
    TextView textOperacion, textNum1, textNum2, textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        textOperacion = findViewById(R.id.textOperacion);
        textNum1 = findViewById(R.id.textNum1);
        textNum2 = findViewById(R.id.textNum2);
        textResultado = findViewById(R.id.textResultado);

        // Recibir datos
        String num1Str = getIntent().getStringExtra("num1");
        String num2Str = getIntent().getStringExtra("num2");
        String operacion = getIntent().getStringExtra("operacion");

        textOperacion.setText("Operación: " + operacion);
        textNum1.setText("Número 1: " + num1Str);
        textNum2.setText("Número 2: " + num2Str);

        // Calcular resultado
        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double resultado = 0;

            switch (operacion) {
                case "Suma": resultado = num1 + num2; break;
                case "Resta": resultado = num1 - num2; break;
                case "Multiplicación": resultado = num1 * num2; break;
                case "División":
                    if (num2 == 0) {
                        textResultado.setText("Error: división entre 0");
                        return;
                    } else {
                        resultado = num1 / num2;
                    }
                    break;
            }

            textResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            textResultado.setText("Ingresa números válidos");
        }
    }
}
