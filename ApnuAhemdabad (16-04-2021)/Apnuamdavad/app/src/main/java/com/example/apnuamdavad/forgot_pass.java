package com.example.apnuamdavad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
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
import com.example.apnuamdavad.ApiHelper.JsonField;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class forgot_pass extends AppCompatActivity {

    EditText email_forgot;
    Button send_forgot_pass_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        send_forgot_pass_email = findViewById(R.id.send_forgot_pass_email);
        email_forgot = findViewById(R.id.email_forgot);

        send_forgot_pass_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkEmail()){
                    sendforgotpassword();
                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sendforgotpassword() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, WebUrl.KEY_FORGOT_PASS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseForgotResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put(JsonField.KEY_USER_EMAIL,email_forgot.getText().toString());
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(forgot_pass.this);
        requestQueue.add(stringRequest);

    }

    private void parseForgotResponse(String response) {
        Log.d("RESPONSE",response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int flag = jsonObject.optInt(JsonField.FLAG);

            if (flag == 1) {
                Intent i = new Intent(forgot_pass.this, MainActivity.class);
                startActivity(i);
                finish();
            }else {
                String Message = jsonObject.optString(JsonField.MESSAGE);
                Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean checkEmail() {
        boolean isEmailValid = false;
        String emailid = email_forgot.getText().toString().trim();

        if (email_forgot.getText().toString().trim().length() <= 0) {
            email_forgot.setError("Enter Email");
        }
        else if (Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
            isEmailValid = true;
        } else {
            email_forgot.setError("Enter Correct Email");
        }
        return isEmailValid;
    }
}
