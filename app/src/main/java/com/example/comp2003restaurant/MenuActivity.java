package com.example.comp2003restaurant;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnReturnHome = findViewById(R.id.btnBack);
        btnReturnHome.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, HomePageActivity.class);
            startActivity(intent);
            finish();
        });
    }
}


