package com.example.comp2003restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ThankYouActivity extends AppCompatActivity {

    private Button btnReturnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        btnReturnHome = findViewById(R.id.btnBack);

        if (btnReturnHome != null) {
            btnReturnHome.setOnClickListener(v -> {
                // This part is for returning the user to the home page
                Intent intent = new Intent(ThankYouActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            });
        }
    }
}


