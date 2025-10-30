package com.example.midterm_woohyuk_song;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Field declarations
    EditText numberInput;
    Button submitButton;
    Button historyButton;
    ListView tableListView;

    ArrayList<String> tableList;
    ArrayAdapter<String> adapter;

    // Static list storing history
    public static ArrayList<Integer> historyList = new ArrayList<>();

    // onCreate method
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

        // Initialize UI components
        numberInput = findViewById(R.id.edit);
        submitButton = findViewById(R.id.button);
        historyButton = findViewById(R.id.historyButton);
        tableListView = findViewById(R.id.list);

        // Initialize list and adapter
        tableList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tableList);
        tableListView.setAdapter(adapter);

        // Button Click listener for submit
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = numberInput.getText().toString();
                if (!input.isEmpty()) {
                    try {
                        int number = Integer.parseInt(input);

                        tableList.clear();

                        for (int i = 1; i <= 10; i++) {
                            int result = number * i;
                            String row = number + " × " + i + " = " + result;
                            tableList.add(row);
                        }

                        adapter.notifyDataSetChanged();

                        if (!historyList.contains(number)) {
                            historyList.add(number);
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Button click listener for history
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        // Item click listener for deletion
        tableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String item = tableList.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you want to delete this row?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tableList.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Deleted: " + item, Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }
}