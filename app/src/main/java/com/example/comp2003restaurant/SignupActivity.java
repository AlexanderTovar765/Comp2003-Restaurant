package com.example.comp2003restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View; // ✅ Added this import
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * SignupActivity: stores user with DBHelper.addUser(...) then opens LoginActivity.
 * It looks up multiple possible IDs so it works even if XML names differ slightly.
 */
public class SignupActivity extends AppCompatActivity {

    private EditText etEmail, etUsername, etPassword;
    private Button btnCreate;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = new DBHelper(this);

        // Try multiple possible ID names
        etEmail = findEditTextSafe("emailInput", "inputEmail");
        etUsername = findEditTextSafe("usernameInput", "inputUsername");
        etPassword = findEditTextSafe("passwordInput", "inputPassword");
        btnCreate = findButtonSafe("createAccountButton", "btnCreateAccount", "btn_create_account", "createAccount");

        if (btnCreate != null) {
            btnCreate.setOnClickListener(v -> {
                String email = etEmail != null ? etEmail.getText().toString().trim() : "";
                String username = etUsername != null ? etUsername.getText().toString().trim() : "";
                String password = etPassword != null ? etPassword.getText().toString().trim() : "";

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(SignupActivity.this, "Please complete all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // ✅ Use the final DBHelper method
                boolean added = db.addUser(email, username, password);

                if (added) {
                    Toast.makeText(SignupActivity.this, "Account created! Please log in.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(SignupActivity.this, "Unable to create account (maybe email already exists).", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // ---- Helper methods ----
    private EditText findEditTextSafe(String... names) {
        for (String n : names) {
            int id = getResources().getIdentifier(n, "id", getPackageName());
            if (id != 0) {
                View v = findViewById(id);
                if (v instanceof EditText) return (EditText) v;
            }
        }
        return null;
    }

    private Button findButtonSafe(String... names) {
        for (String n : names) {
            int id = getResources().getIdentifier(n, "id", getPackageName());
            if (id != 0) {
                View v = findViewById(id);
                if (v instanceof Button) return (Button) v;
            }
        }
        return null;
    }
}




