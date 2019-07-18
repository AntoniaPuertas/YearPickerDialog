package com.example.yearpickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnYear;
    int currentAnyo;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        btnYear = findViewById(R.id.btnYear);

        currentAnyo = Calendar.getInstance().get(Calendar.YEAR);

        btnYear.setText("Año " + currentAnyo);

        btnYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();
            }
        });
    }


    public void mostrarDialogo() {
        final AlertDialog.Builder d = new AlertDialog.Builder(context);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.picker_year, null);
        d.setTitle("Selecciona el año");
        d.setMessage("Año seleccionado");
        d.setView(dialogView);
        final NumberPicker numberPicker = (NumberPicker) dialogView.findViewById(R.id.number_picker);
        numberPicker.setMaxValue(currentAnyo);
        numberPicker.setMinValue(1980);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setValue(currentAnyo);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

            }
        });
        d.setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                currentAnyo = numberPicker.getValue();
                btnYear.setText("Año " + currentAnyo);
            }
        });
        d.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog alertDialog = d.create();
        alertDialog.show();
    }
}
