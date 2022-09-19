package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

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
import java.util.StringJoiner;

public class Feedback_master extends AppCompatActivity implements View.OnClickListener {
    EditText etFDesc;
    Button btnSubmit;
    UserSessionManager userSessionManager;
    String uid;
    ImageButton btn_fbback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        etFDesc = findViewById(R.id.etFDesc);
        btn_fbback = findViewById(R.id.btn_fbback);
        btn_fbback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnSubmit = findViewById(R.id.btnSubmit);
        userSessionManager = new UserSessionManager(this);
        uid = userSessionManager.getUserID();

        btnSubmit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        sendFeedbackRequest(uid);
        Intent intent = new Intent(Feedback_master.this, Thankyou_Activity.class);
        startActivity(intent);
        finish();
    }


    private void sendFeedbackRequest(String uid) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebUrl.KEY_FEEDBACK_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseFeedbackResponse(response);
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
                params.put(JsonField.KEY_USER_ID,uid);
                params.put(JsonField.KEY_FEEDBACK_DETAILS, etFDesc.getText().toString());
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Feedback_master.this);
        requestQueue.add(stringRequest);
    }

    private void parseFeedbackResponse(String response) {
        Log.d("RESPONSE", response);
    }
}

