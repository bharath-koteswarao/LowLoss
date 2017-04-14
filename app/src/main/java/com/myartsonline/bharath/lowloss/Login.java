package com.myartsonline.bharath.lowloss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton=(Button)findViewById(R.id.loginButton);
    }

    public void signIn(View view) {
        loginButton.setText("SIGNING IN");
        startActivity(new Intent(this,MainActivity.class));
    }
}
