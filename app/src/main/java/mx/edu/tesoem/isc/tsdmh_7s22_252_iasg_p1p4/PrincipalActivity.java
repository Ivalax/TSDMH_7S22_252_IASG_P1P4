package mx.edu.tesoem.isc.tsdmh_7s22_252_iasg_p1p4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrincipalActivity extends AppCompatActivity {
    EditText editNum1, editNum2;
    Spinner spinnerOperacion;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        spinnerOperacion = findViewById(R.id.spinnerOperacion);
        btnCalcular = findViewById(R.id.btnCalcular);

        // Spinner con las operaciones
        String[] operaciones = {"Suma", "Resta", "Multiplicación", "División"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, operaciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOperacion.setAdapter(adapter);

        btnCalcular.setOnClickListener(v -> {
            String num1 = editNum1.getText().toString().trim();
            String num2 = editNum2.getText().toString().trim();
            String operacion = spinnerOperacion.getSelectedItem().toString();

            // Pasar datos a la siguiente pantalla
            Intent intent = new Intent(PrincipalActivity.this, CalculoActivity.class);
            intent.putExtra("num1", num1);
            intent.putExtra("num2", num2);
            intent.putExtra("operacion", operacion);
            startActivity(intent);
        });
    }
}
