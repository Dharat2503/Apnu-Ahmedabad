package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.apnuamdavad.ApiHelper.JsonField;
import com.example.apnuamdavad.ApiHelper.WebUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Profile extends AppCompatActivity {

    TextView btn_profile_edit, btn_changepassword;
    TextView tvuser, tvemail, tvmobile;
    UserSessionManager userSessionManager;
    ImageButton btn_pfback;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        userSessionManager = new UserSessionManager(this);

        tvuser = (TextView) findViewById(R.id.tvuser);
        btn_pfback = findViewById(R.id.btn_pfback);
        btn_pfback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvemail = (TextView) findViewById(R.id.tvemail);
        tvmobile = (TextView) findViewById(R.id.tvmobile);
        btn_changepassword = findViewById(R.id.btn_changepassword);
        btn_profile_edit = findViewById(R.id.btn_profile_edit);

        String n=tvuser.getText().toString();
        String m=tvmobile.getText().toString();

        btn_profile_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Profile_update.class);
                intent.putExtra("NAME",n);
                intent.putExtra("PHONE",m);
                startActivity(intent);
            }
        });

        btn_changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Change_passActivity.class);
                startActivity(intent);
            }
        });

        //get all value from usersessionManager
        userSessionManager = new UserSessionManager(this);
        id = userSessionManager.getUserID();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebUrl.KEY_DISPLAY_PROFILE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseResponse(response.toString());
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
                params.put(JsonField.KEY_USER_ID, id);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Profile.this);
        requestQueue.add(stringRequest);


    }

    private void parseResponse(String response) {
        Log.d("T", response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int flag = jsonObject.optInt(JsonField.FLAG);
            if (flag == 1) {
                JSONArray jsonArray = jsonObject.optJSONArray(JsonField.PROFILE_ARRAY);
                if (jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.optJSONObject(i);
                        // String packageid = objPackage.getString(JsonField.PACKAGE_ID);
                        String name = jsonObject1.getString(JsonField.KEY_USER_NAME);
                        String email = jsonObject1.getString(JsonField.KEY_USER_EMAIL);
                        String mob = jsonObject1.getString(JsonField.KEY_USER_MOBILENO);

                        // tvId.setText(packageid);
                        tvuser.setText(name);
                        tvemail.setText(email);
                        tvmobile.setText(mob);


                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
