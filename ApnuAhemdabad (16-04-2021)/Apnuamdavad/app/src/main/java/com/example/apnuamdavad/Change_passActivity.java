package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class Change_passActivity extends AppCompatActivity {
    TextInputEditText e_oldpass, e_newpass, e_confirmpass;
    Button save;
    private UserSessionManager userSessionManager;
    ImageButton btn_cpback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        btn_cpback = findViewById(R.id.btn_cpback);
        btn_cpback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        e_oldpass = (TextInputEditText) findViewById(R.id.o_pass);
        e_newpass = (TextInputEditText) findViewById(R.id.n_pass);
        e_confirmpass = (TextInputEditText) findViewById(R.id.c_pass);
        save = (Button) findViewById(R.id.btn_done_password);
        userSessionManager = new UserSessionManager(Change_passActivity.this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkoldPassword() && checknewPassword() && checkconfirmPassword()) {
                    sendchangepassword();
                }
            }
        });
    }


    private void sendchangepassword() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebUrl.KEY_CHANGE_PASS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseChangePasswordResponse(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put(JsonField.KEY_USER_ID, userSessionManager.getUserID());
                params.put(JsonField.KEY_OLD_PASSWORD, e_oldpass.getText().toString());
                params.put(JsonField.KEY_NEW_PASSWORD, e_newpass.getText().toString());
                params.put(JsonField.KEY_CONFIRM_PASSWORD, e_confirmpass.getText().toString());

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Change_passActivity.this);
        requestQueue.add(stringRequest);

    }

    private void parseChangePasswordResponse(String response) {
        Log.d("RESPONSE", response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int flag = jsonObject.optInt(JsonField.FLAG);
            String message = jsonObject.optString(JsonField.MESSAGE);
            if (flag == 1) {
                Toast.makeText(this, "Password change Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Change_passActivity.this, Homepage.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //validation
    private boolean checkoldPassword() {
        boolean isoldpassword = false;
        if (e_oldpass.getText().toString().trim().length() <= 0)
            e_oldpass.setError("Enter Registed old Password");
        else {
            isoldpassword = true;
        }
        return isoldpassword;
    }

    private boolean checknewPassword() {
        boolean isnewpassword = false;
        if (e_newpass.getText().toString().trim().length() <= 0)
            e_newpass.setError("Enter New Password");
        else {
            isnewpassword = true;
        }
        return isnewpassword;
    }

    private boolean checkconfirmPassword() {
        boolean isconfimpassword = false;
        if (e_confirmpass.getText().toString().trim().length() <= 0)
            e_confirmpass.setError("Confirm New Password");
        else {
            isconfimpassword = true;
        }
        return isconfimpassword;
    }

}
