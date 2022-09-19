package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apnuamdavad.ApiHelper.JsonField;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class Regisatation extends AppCompatActivity {

    TextInputEditText u_name,u_email,u_mobile,u_password;

    Button sign_up,btn_signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisatation);

        u_name=findViewById(R.id.u_name);
        u_email=findViewById(R.id.u_email);
        u_mobile=findViewById(R.id.u_mobile);
        u_password=findViewById(R.id.u_password);


        //go to signin page button
        btn_signin = findViewById(R.id.btn_signin);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Regisatation.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //signup button
        sign_up=findViewById(R.id.sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.sign_up:

                        if(checkUserName() && checkEmail() && checkMobileNumber() && checkPassword()){
                            sendSignupRequest();
                            Intent intent=new Intent(Regisatation.this,MainActivity.class);
                            startActivity(intent);
                        }

                        break;
                }

            }
        });
    }


    //Registation
    private void sendSignupRequest() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, WebUrl.KEY_SIGNUP_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseSingupResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params =new HashMap<>();
                params.put(JsonField.KEY_USER_NAME,u_name.getText().toString());
                params.put(JsonField.KEY_USER_EMAIL,u_email.getText().toString());
                params.put(JsonField.KEY_USER_MOBILENO,u_mobile.getText().toString());
                params.put(JsonField.KEY_USER_PASSWORD,u_password.getText().toString());

                return params;
            }
        };



        RequestQueue requestQueue= Volley.newRequestQueue(Regisatation.this);
        requestQueue.add(stringRequest);

    }
    private void parseSingupResponse(String response) {
        Toast.makeText(this, "Registation Successfully....", Toast.LENGTH_SHORT).show();

        Log.d("RESPONSE",response);
    }


    //Validation
    private boolean checkUserName (){
        boolean isUserNameValid = false;
        if (u_name .getText(). toString ().trim().length() <= 0)
            u_name.setError ("Enter Username");
        else {
            isUserNameValid =true;
        }
        return isUserNameValid;
    }
    private boolean checkPassword(){
        boolean isAddresValid = false;
        if (u_password .getText(). toString ().trim().length() <= 0)
            u_password.setError ("Enter Password");
        else {
            isAddresValid =true;
        }
        return isAddresValid;
    }
    private boolean checkMobileNumber() {
        boolean isMobileNumberValid = false;
        if (u_mobile.getText().toString().trim().length() <= 0) {
            u_mobile.setError("Enter Mobile Number");
        }
        else if (u_mobile.getText().toString().trim().length() == 10) {
            isMobileNumberValid = true;
        } else {
            u_mobile.setError("Enter Correct Mobile Number");
        }
        return isMobileNumberValid;
    }
    public boolean checkEmail() {
        boolean isEmailValid = false;
        String emailid = u_email.getText().toString().trim();

        if (u_email.getText().toString().trim().length() <= 0) {
            u_email.setError("Enter Email");
        }
        else if (Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
            isEmailValid = true;
        } else {
            u_email.setError("Enter Correct Email");
        }
        return isEmailValid;
    }


}