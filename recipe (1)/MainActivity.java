package com.example.recipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText eName;
    private EditText ePass;
    private Button eLog;
    private TextView tRegister;

    private String Username = "TTC";
    private String Password = "12345";

    boolean isValid = false;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.etName);
        ePass = findViewById(R.id.etPass);
        eLog = findViewById(R.id.button);
        tRegister = findViewById(R.id.textView);

        eLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName = eName.getText().toString();
                String inputPassword = ePass.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the details correctly!", Toast.LENGTH_SHORT).show();
                } else {

                    isValid = validate(inputName, inputPassword);

                    if (!isValid) {

                        counter--;

                        Toast.makeText(MainActivity.this, "Incorrect credentials entered!", Toast.LENGTH_SHORT).show();

                        tRegister.setText("No. of attempts: 5" + counter);

                        if (counter == 0) {
                            eLog.setEnabled(false);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
            }

            private boolean validate(String inputName, String inputPassword) {
                if (inputName.equals(Username) && inputPassword.equals(Password)) {
                    return true;
                }

                return false;
            }

        });
    }}