package com.kaapo.ostoslista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private ItemStorage storage;
    private RecyclerView recyclerView;

    private TextView tarkeaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storage = ItemStorage.getInstance();

        recyclerView = findViewById(R.id.rvItemList);
        tarkeaTextView = findViewById(R.id.tarkeaTextView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ShoppingListAdapter(getApplicationContext(), storage.getItems()));
        setTarkeaTextView();
    }
    protected void setTarkeaTextView() {
        String text = storage.getTarkeaItemsText();
        tarkeaTextView.setText(text);
    }

    public void switchToAddItem(View view) {
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }
}