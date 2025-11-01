package com.example.comp2003restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity {

    private Button btnViewMenu, btnBookTable, btnFeedback, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // This part is for initializing the buttons for the page
        btnViewMenu = findViewById(R.id.btnViewMenu);
        btnBookTable = findViewById(R.id.btnBookTable);
        btnFeedback = findViewById(R.id.btnFeedback);
        btnLogout = findViewById(R.id.btnLogout);

        if (btnViewMenu != null) {
            btnViewMenu.setOnClickListener(v ->
                    startActivity(new Intent(HomePageActivity.this, MenuActivity.class))
            );
        }

        if (btnBookTable != null) {
            btnBookTable.setOnClickListener(v ->
                    startActivity(new Intent(HomePageActivity.this, BookTableActivity.class))
            );
        }

        if (btnFeedback != null) {
            btnFeedback.setOnClickListener(v ->
                    startActivity(new Intent(HomePageActivity.this, FeedbackActivity.class))
            );
        }

        if (btnLogout != null) {
            btnLogout.setOnClickListener(v -> {
                Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            });
        }
    }
}



