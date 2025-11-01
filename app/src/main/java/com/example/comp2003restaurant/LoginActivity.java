package com.example.comp2003restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

  private EditText etUsernameOrEmail, etPassword;
  private Button btnLogin, btnReturnMain;
  private DBHelper db;

  @Override // for bypassing the superclass
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    db = new DBHelper(this);

    // This part is for the helper methods, which will look for the multiple possible names in the code securely
    etUsernameOrEmail = findEditTextSafe("inputUsername", "usernameInput", "inputEmail", "emailInput", "etUsername");
    etPassword = findEditTextSafe("inputPassword", "passwordInput", "etPassword");
    btnLogin = findButtonSafe("btnLogin", "loginButton", "buttonLogin");
    btnReturnMain = findButtonSafe("btnReturnMain", "returnMainButton", "buttonReturnMain");

    if (btnLogin != null) {
      btnLogin.setOnClickListener(v -> {
        String user = etUsernameOrEmail != null ? etUsernameOrEmail.getText().toString().trim() : "";
        String pass = etPassword != null ? etPassword.getText().toString().trim() : "";

        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
          Toast.makeText(LoginActivity.this, "Please enter your username/email and password.", Toast.LENGTH_SHORT).show();
          return;
        }

        boolean valid = db.checkUser(user, pass);
        if (valid) {
          Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
          Log.d("LoginActivity", "Redirecting to HomePageActivity...");

          // This part is for sending the user to the HomePageActivity after they login successfully
          Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
          intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);
          finish();
        } else {
          Toast.makeText(LoginActivity.this, "Invalid username or password.", Toast.LENGTH_SHORT).show();
        }
      });
    }

    if (btnReturnMain != null) {
      btnReturnMain.setOnClickListener(v -> {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
      });
    }
  }

  // This part is for finding the EditText XML without caring what it’s named in the files
  private EditText findEditTextSafe(String... possibleNames) {
    for (String name : possibleNames) {
      int id = getResources().getIdentifier(name, "id", getPackageName());
      if (id != 0) {
        View v = findViewById(id);
        if (v instanceof EditText) return (EditText) v;
      }
    }
    return null;
  }

  // This part is for finding the Buttons, no matter what they’re named in the XML
  private Button findButtonSafe(String... possibleNames) {
    for (String name : possibleNames) {
      int id = getResources().getIdentifier(name, "id", getPackageName());
      if (id != 0) {
        View v = findViewById(id);
        if (v instanceof Button) return (Button) v;
      }
    }
    return null;
  }
}



