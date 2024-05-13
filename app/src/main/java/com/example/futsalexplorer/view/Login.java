package com.example.futsalexplorer.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.futsalexplorer.MainActivity;
import com.example.futsalexplorer.R;
import com.example.futsalexplorer.Utilities.ApiClient;

public class Login extends AppCompatActivity {

    Button Move;

    private EditText username, pass;
    TextView newuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);

        Button bttn = findViewById(R.id.Move);
        bttn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkCredentials();

                ApiClient clientApi = new ApiClient();
                clientApi.loginuser(username.getText().toString(),pass.getText().toString() , Login.this); // Changed from registerUser to reg
              // Fixed reference to LoginActivity
            }
        });

        TextView newuser = findViewById(R.id.newuser);
        newuser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }

    private void checkCredentials() {
        String usernameText = username.getText().toString();
        String password = pass.getText().toString();

        if (usernameText.isEmpty() || usernameText.length() < 3) {
            showError(username, "Username invalid!");
        } else if (password.isEmpty() || password.length() < 3) {
            showError(pass, "Password must be at least 8 characters or more");
        } else {
            // Credentials are valid
        }
    }

    private void showError(EditText input, String message) {
        input.setError(message);
        input.requestFocus();
    }

    private void showSuccessToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }


}
