package com.example.comp2003restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//This part is for declaring the button variables on the page
    private Button btnLogin, btnSignUp, btnFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnFeedback = findViewById(R.id.btnFeedback);
// This part is for the login button on the main page
        if (btnLogin != null) {
            btnLogin.setOnClickListener(v ->
                    startActivity(new Intent(MainActivity.this, LoginActivity.class))
            );
        }
// This part is for the sign up button on the main page
        if (btnSignUp != null) {
            btnSignUp.setOnClickListener(v ->
                    startActivity(new Intent(MainActivity.this, SignupActivity.class))
            );
        }
// This part is for the feedback button on the main page
        if (btnFeedback != null) {
            btnFeedback.setOnClickListener(v ->
                    startActivity(new Intent(MainActivity.this, FeedbackActivity.class))
            );
        }
    }
}






