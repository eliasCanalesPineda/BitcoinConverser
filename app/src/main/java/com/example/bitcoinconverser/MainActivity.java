package com.example.bitcoinconverser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private EditText bitcoinEditText;
    private TextView resultTextView;
    Button convertButton;

    Spinner Lista;
    String[] MyLista ={"Dólares", "Lempiras", "Quetzales", "Córdobas", "Cólones Costarricenses"};

    private static final double DOLLAR_EXCHANGE_RATE = 1.0;
    private static final double LEMPIRA_EXCHANGE_RATE = 24.63;
    private static final double QUETZAL_EXCHANGE_RATE = 7.84;
    private static final double CORDOBA_EXCHANGE_RATE = 36.52;
    private static final double COLON_EXCHANGE_RATE = 578.51;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lista = findViewById(R.id.ListaConer);
        bitcoinEditText = findViewById(R.id.amountEditText);
        resultTextView = findViewById(R.id.resultTextView);
        convertButton = findViewById(R.id.convertButton);
        ArrayAdapter<String> Predator = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,MyLista);
        Lista.setAdapter(Predator);
        convertButton = findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calcular();
            }
        });
    }
    public void Calcular(){
        String bitcoinPriceString = bitcoinEditText.getText().toString();

        if (bitcoinPriceString.isEmpty()){
            Toast.makeText(MainActivity.this, "Ingrese el precio y la cantidad de Bitcoin", Toast.LENGTH_SHORT).show();
        } else {
            double bitcoinPrice = Double.parseDouble(bitcoinPriceString);
            double dollarAmount = bitcoinPrice * DOLLAR_EXCHANGE_RATE;
            double lempiraAmount = bitcoinPrice * LEMPIRA_EXCHANGE_RATE;
            double quetzalAmount = bitcoinPrice * QUETZAL_EXCHANGE_RATE;
            double cordobaAmount = bitcoinPrice *  CORDOBA_EXCHANGE_RATE;
            double colonAmount1 = bitcoinPrice *  COLON_EXCHANGE_RATE;

            String resultString; //= "Dollars: " + dollarAmount + "\n" +
                    //"Lempiras: " + lempiraAmount + "\n" +
                    //"Quetzales: " + quetzalAmount + "\n" +
                    //"Córdobas: " + cordobaAmount + "\n" +
                    //"Colones: " + colonAmount;
            resultString = Lista.getSelectedItem().toString();
            if(resultString.equals("Dólares")){
                resultTextView.setText(""+dollarAmount);
            } else if (resultString.equals("Lempiras")) {
                resultTextView.setText(""+lempiraAmount);
            } else if (resultString.equals("Quetzales")) {
                resultTextView.setText(""+quetzalAmount);
            } else if (resultString.equals("Córdobas")) {
                resultTextView.setText(""+cordobaAmount);
            } else if (resultString.equals("Cólones Costarricenses")) {
                resultTextView.setText(""+colonAmount1);
            }
        }
    }
}
