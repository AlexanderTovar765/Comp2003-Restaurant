package com.example.comp2003restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        EditText inputFeedback = findViewById(R.id.inputFeedback);
        Button btnSubmitFeedback = findViewById(R.id.btnSubmitFeedback);

        btnSubmitFeedback.setOnClickListener(v -> {
            String feedback = inputFeedback.getText().toString().trim();
            if (feedback.isEmpty()) {
                Toast.makeText(this, "Please enter some feedback before submitting.", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(FeedbackActivity.this, ThankYouActivity.class);
                startActivity(intent);
            }
        });
    }
}

