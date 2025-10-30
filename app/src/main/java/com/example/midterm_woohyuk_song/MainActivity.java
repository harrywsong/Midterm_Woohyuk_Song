package com.example.midterm_woohyuk_song;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText numberInput;
    Button generateButton;
    Button historyButton;
    ListView tableListView;

    ArrayList<String> tableList;
    ArrayAdapter<String> adapter;

    public static ArrayList<Integer> historyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        numberInput = findViewById(R.id.edit);
        submitButton = findViewById(R.id.button);
        historyButton = findViewById(R.id.historyButton);
        tableListView = findViewById(R.id.listView);

        tableList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tableList);
        tableListView.setAdapter(adapter);

        generateButton.setOnClickListener(v -> {
            String input = numberInput.getText().toString();
            if (!input.isEmpty()) {
                int number = Integer.parseInt(input);
                tableList.clear();
                for (int i = 1; i <= 10; i++) {
                    tableList.add(number + " x " + i + " = " + (number * i));
                }
                adapter.notifyDataSetChanged();
                historyList.add(number);
            }
        });

        historyButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });




    }
}