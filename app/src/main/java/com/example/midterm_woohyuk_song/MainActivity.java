package com.example.midterm_woohyuk_song;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText numberInput;
    private Button submitButton;
    private Button historyButton;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> multiplicationTableList;
    public static ArrayList<Integer> historyList = new ArrayList<>();
    private int currentNumber = -1;

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
        listView = findViewById(R.id.listView);
    }
}