package com.example.comp2003restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookTableActivity extends AppCompatActivity {

    private ListView listViewTimes;
    private Button btnConfirm, btnReturnHome;
    private String selectedTime = null;
    private String[] availableTimes = {"5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM", "7:00 PM", "7:30 PM", "8:00 PM"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_table);

        listViewTimes = findViewById(R.id.listViewTimes);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnReturnHome = findViewById(R.id.btnBack);

        // Adapter for available times
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, availableTimes);
        listViewTimes.setAdapter(adapter);
        listViewTimes.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listViewTimes.setOnItemClickListener((parent, view, position, id) -> selectedTime = availableTimes[position]);

        btnConfirm.setOnClickListener(v -> {
            if (selectedTime == null) {
                Toast.makeText(BookTableActivity.this, "Please select a time before confirming.", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(BookTableActivity.this, "Your reservation at " + selectedTime + " has been made.", Toast.LENGTH_SHORT).show();

            // ✅ Redirect to HomePageActivity instead of MainActivity
            Intent intent = new Intent(BookTableActivity.this, HomePageActivity.class);
            startActivity(intent);
            finish();
        });

        btnReturnHome.setOnClickListener(v -> {
            Intent intent = new Intent(BookTableActivity.this, HomePageActivity.class);
            startActivity(intent);
            finish();
        });
    }
}





