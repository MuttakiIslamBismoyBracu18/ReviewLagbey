
package com.haerul.foodsapp.view.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.haerul.foodsapp.R;

public class LoginActivity extends AppCompatActivity {
    private Button Login;
    private EditText mailLog;
    private EditText passLog;
    int counter = 5;
    private TextView top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mailLog = (EditText) findViewById(R.id.mailLog);
        passLog = (EditText) findViewById(R.id.passLog);
        Login = (Button) findViewById(R.id.button3);
        top = (TextView) findViewById(R.id.Top2);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate3(mailLog.getText().toString(), passLog.getText().toString());
            }
        });
    }

    private void validate3(String userName, String userPassword) {
        if ((userName.equals("abcd@gmail.com")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(LoginActivity.this, ViewPage.class);
            startActivity(intent);
        } else {
            //Toast.makeText(this, "Wrong Input", Toast.LENGTH_LONG).show();
            counter--;
            top.setText("No of error Remaining : " + String.valueOf(counter));

            if (counter == 0) {
                Login.setEnabled(false);
            }
        }
    }
}