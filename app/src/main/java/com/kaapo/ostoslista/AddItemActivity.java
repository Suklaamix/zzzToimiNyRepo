package com.kaapo.ostoslista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {

    private EditText editTextOstos, editTextExtra;
    private RadioButton radioTarkea;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        editTextOstos = findViewById(R.id.editTextOstos);
        editTextExtra = findViewById(R.id.editTextExtra);
        radioTarkea = findViewById(R.id.radioTarkea);
    }

    public void addItem(View view) {
        String ostos = editTextOstos.getText().toString();
        String extraTxt = editTextExtra.getText().toString();

        Item newItem = new Item(ostos, extraTxt, radioTarkea.isChecked(), id);
        id++;

        ItemStorage s = ItemStorage.getInstance();
        s.addItem(newItem);


        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}