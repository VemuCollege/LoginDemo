package com.mani.loginappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText etUserName,etPassword;
    Button btnLogin,btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etUserPassword);

        btnCancel = findViewById(R.id.btnCancel);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnLogin) {

            String userName = etUserName.getText().toString();
            String password = etPassword.getText().toString();

            if (userName.isEmpty()){
                Toast.makeText(MainActivity.this,"Please Enter UserName",Toast.LENGTH_SHORT).show();
            } else if (password.isEmpty()){
                Toast.makeText(MainActivity.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
            } else {
                 // Logic

                if (userName.equals("Mani") && password.equals("Mani")) {

                    Intent intent = new Intent(MainActivity.this,SuccessActivity.class);
                    startActivity(intent);


                }else {
                    Intent intent = new Intent(MainActivity.this,FailureActivity.class);
                    startActivity(intent);

                }
            }





        } else if (v.getId() == R.id.btnCancel) {

            etUserName.setText("");
            etPassword.setText("");
        }
    }
}