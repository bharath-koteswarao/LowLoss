package com.myartsonline.bharath.lowloss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    Button loginButton;
    String username,password;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton=(Button)findViewById(R.id.loginButton);
        et1=(EditText)findViewById(R.id.usernameEt);
        et2=(EditText)findViewById(R.id.passwordEt);
    }

    public void signIn(View view) {
        loginButton.setText("SIGNING IN");
        username=et1.getText().toString();
        password=et2.getText().toString();
        final RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(Request.Method.POST, "http://bharath.myartsonline.com/c2c/userValidation.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("1"))
                        {
                            startActivity(new Intent(Login.this,MainActivity.class));
                        }
                        else {
                            Toast.makeText(Login.this, "You are not registered user", Toast.LENGTH_SHORT).show();
                            loginButton.setText("SIGN IN");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this, "You should have an internet connection", Toast.LENGTH_SHORT).show();
                        loginButton.setText("SIGN IN");
                        queue.stop();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put("username",username);
                map.put("password",password);
                return map;
            }
        };
        queue.add(request);
    }
}
