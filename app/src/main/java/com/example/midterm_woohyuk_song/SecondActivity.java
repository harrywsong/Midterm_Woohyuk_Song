package com.example.midterm_woohyuk_song;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    // Field declaration
    ListView historyListView;

    // onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        // Initialize layout
        historyListView = findViewById(R.id.historyListView);

        // Set up adapter with history data from MainActivity
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.historyList);
        historyListView.setAdapter(adapter);
    }
}
