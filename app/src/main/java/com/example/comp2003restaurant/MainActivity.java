package com.example.comp2003restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnSignUp, btnFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnFeedback = findViewById(R.id.btnFeedback);

        if (btnLogin != null) {
            btnLogin.setOnClickListener(v ->
                    startActivity(new Intent(MainActivity.this, LoginActivity.class))
            );
        }

        if (btnSignUp != null) {
            btnSignUp.setOnClickListener(v ->
                    startActivity(new Intent(MainActivity.this, SignupActivity.class))
            );
        }

        if (btnFeedback != null) {
            btnFeedback.setOnClickListener(v ->
                    startActivity(new Intent(MainActivity.this, FeedbackActivity.class))
            );
        }
    }
}






