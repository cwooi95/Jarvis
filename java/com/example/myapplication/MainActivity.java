package com.example.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Intent;

public class MainActivity extends Activity {
    Button loginButton, cancelButton;
    EditText textUsername, textPassword;

    TextView textWarning;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.button1);
        textUsername = (EditText) findViewById(R.id.editText1);
        textPassword = (EditText) findViewById(R.id.editText2);

        cancelButton = (Button) findViewById(R.id.button2);
        textWarning = (TextView) findViewById(R.id.textView4);
        textWarning.setVisibility(View.GONE);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                if (textUsername.getText().toString().equals("admin") && textPassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent activity2Intent = new Intent(getApplicationContext(),OwnerPage.class);
                    startActivity(activity2Intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();

                    textWarning.setVisibility(View.VISIBLE);
                    textWarning.setBackgroundColor(Color.RED);
                    counter--;
                    textWarning.setText(Integer.toString(counter));

                    if (counter == 0) {
                        loginButton.setEnabled(false);
                    }
                }

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
                                        }
        );

    }


}
