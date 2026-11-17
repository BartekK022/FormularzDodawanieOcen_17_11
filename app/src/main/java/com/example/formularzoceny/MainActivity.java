package com.example.formularzoceny;

import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBarOcena;
    Spinner spinnerPrzedmioty1, SpinnerPrzedmioty2;
    CheckBox checkBoxCzyLiczycDoSredniej;
    EditText editTextWagaOceny;
    Button buttonDodaj, buttonWypisz;
    ListView listViewOceny;
    ArrayList<String>arrayListOceny = new ArrayList<>();
    ArrayAdapter<String> arrayAdapterOceny;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        arrayListOceny.add("6, matematyka, 5");


        seekBarOcena = findViewById(R.id.seekBar);
        spinnerPrzedmioty1 = findViewById(R.id.spinner);
        SpinnerPrzedmioty2 = findViewById(R.id.spinner2);
        checkBoxCzyLiczycDoSredniej = findViewById(R.id.checkBox);
        editTextWagaOceny = findViewById(R.id.editTextNumber);
        buttonDodaj = findViewById(R.id.button);
        buttonWypisz = findViewById(R.id.button2);
        listViewOceny = findViewById(R.id.listView);

        buttonDodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int ocena = seekBarOcena.getProgress();
                        String przedmiot = spinnerPrzedmioty1.getSelectedItem().toString();
                        String wagaOceny = editTextWagaOceny.getText().toString();
                        if(checkBoxCzyLiczycDoSredniej.isChecked()) {
                            wagaOceny = wagaOceny;
                        }  else {
                            wagaOceny = "0";
                        }
                        String tresc = "ocena"

                        arrayListOceny.add("Ocena: " + ocena + ", przedmiot: " + przedmiot + ", waga: " + wagaOceny);
                        arrayAdapterOceny.notifyDataSetChanged();


                        editTextWagaOceny.setText("");
                        seekBarOcena.setProgress(1);
                        spinnerPrzedmioty1.setSelection(0);
                        checkBoxCzyLiczycDoSredniej.setChecked(false);
                    }
                }
        );


        buttonWypisz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        arrayAdapterOceny = new ArrayAdapter<>(MainActivity.this,
                                android.R.layout.simple_list_item_1);
                        listViewOceny.setAdapter(arrayAdapterOceny);
                    }
                }
        );


    }
}