package com.example.futsalexplorer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.futsalexplorer.R;
import com.example.futsalexplorer.Utilities.ApiClient;
import com.example.futsalexplorer.model.ReqRegister;

public class Register extends AppCompatActivity {

    private EditText reguser, email, password, number;
    private Button bttn;

    TextView newlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reguser = findViewById(R.id.reguser);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        number = findViewById(R.id.number);

        bttn = findViewById(R.id.loginButton);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkCredentials();


            }
        });

        TextView newlogin = findViewById(R.id.newlogin);
        newlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }

    private void checkCredentials() {
        String username = reguser.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        String phoneNumber = number.getText().toString();

        if (username.isEmpty() || username.length() < 3) {
            showError(reguser, "Username invalid!");
        } else if (!userEmail.contains("@")) {
            showError(email, "Email is not valid");
        } else if (userPassword.isEmpty() || userPassword.length() < 8) {
            showError(password, "Password must be at least 8 characters long");
        } else {
            // All credentials are valid, proceed with registration
          //  ReqRegister registerRequest = new ReqRegister(username, userEmail, userPassword, phoneNumber);
            ApiClient apiClient = new ApiClient();
            apiClient.registerUser(reguser.getText().toString(), email.getText().toString(), password.getText().toString(), number.getText().toString());

            showSuccessToast("Data has been saved successfully!");
            startActivity(new Intent(Register.this, Login.class));
        }
    }

    private void showError(EditText input, String errorMessage) {
        input.setError(errorMessage);
        input.requestFocus();
    }
    private void showSuccessToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}
