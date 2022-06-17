package com.example.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "SignupActivity";
    private EditText etEmail;
    private EditText etPassword;
    private EditText etUsername;
    private Button btnSignup;
    private ParseUser currUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currUser = new ParseUser();

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();

                currUser.setEmail(email);
                currUser.setUsername(username);
                currUser.setPassword(password);

                currUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e != null) {
                            Log.e(TAG, "Issue with signup", e);
                            Toast.makeText(SignupActivity.this, "Issue with signup!", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
//                            ParseUser.logInInBackground(username, password, new LogInCallback() {
//                                @Override
//                                public void done(ParseUser user, ParseException e) {
//                                    if (e != null) {
//                                        Log.e(TAG, "Issue with login", e);
//                                        Toast.makeText(SignupActivity.this, "Issue with login!", Toast.LENGTH_SHORT).show();
//                                        return;
//                                    }
//                                    Toast.makeText(SignupActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                                    startActivity(i);
                                    finish();
//                                }
//                            });
                        }
                    }
                });
            }
        });
    }

}
