package com.example.comp2003restaurant;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

// This part is for displaying the restaurant's menu
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// This part is for setting the layout for the screen to "activity_menu.xml"
        setContentView(R.layout.activity_menu);

 // this part is for finding the "Back" button in the layout
        Button btnReturnHome = findViewById(R.id.btnBack);
        btnReturnHome.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, HomePageActivity.class);
            
 // This part is for starting the HomePageActivity
            startActivity(intent);
            finish();
        });
    }
}


