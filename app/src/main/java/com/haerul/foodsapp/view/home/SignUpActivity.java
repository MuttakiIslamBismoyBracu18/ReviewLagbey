
package com.haerul.foodsapp.view.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.haerul.foodsapp.R;

public class SignUpActivity extends AppCompatActivity {
    private TextView Top;
    private EditText Email;
    private EditText Phone;
    private EditText Password;
    private EditText Cpassword;
    private CheckBox keep;
    private Button Signup;
    private Button Login;
    private int counter=5;


    private void validate (String userName, String userPassword)
    {
        if((userName.equals("abcd@gmail.com")) && (userPassword.equals("1234")))
        {
            Intent intent = new Intent(SignUpActivity.this, ViewPage.class);
            startActivity(intent);
        }
        else
        {
            //Toast.makeText(this, "Wrong Input", Toast.LENGTH_LONG).show();
            counter--;
            Top.setText("No of error Remaining : "+String.valueOf(counter));

            if(counter==0)
            {
                Signup.setEnabled(false);
            }
        }
    }

    private void validate2 ()
    {
        Intent a = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(a);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Top = (TextView) findViewById(R.id.parent);
        Email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        Phone = (EditText) findViewById(R.id.editTextPhone);
        Password = (EditText) findViewById(R.id.editTextTextPassword);
        Cpassword = (EditText) findViewById(R.id.editTextTextPassword2);
        Signup = (Button) findViewById(R.id.button);
        Login = (Button) findViewById(R.id.button2);
        keep = (CheckBox) findViewById(R.id.checkBox);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate2();
            }
        });
    }
}