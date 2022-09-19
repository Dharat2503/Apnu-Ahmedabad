package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Profile_update extends AppCompatActivity {

    TextInputEditText update_name, update_mobile;
    Button btn_update_profile;
    String userid;
    UserSessionManager userSessionManager;
    String username, usermobile;
    ImageButton btn_pfupdateback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);

        update_name = findViewById(R.id.update_name);
        update_mobile = findViewById(R.id.update_mobile);
        btn_update_profile = findViewById(R.id.btn_update_profile);
        btn_pfupdateback = findViewById(R.id.btn_pfupdateback);
        btn_pfupdateback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        userSessionManager = new UserSessionManager(this);
        userid = userSessionManager.getUserID();


        btn_update_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkUserName() && checkMobileNumber()) {
                    getUpdateProfile(userid);
                    Intent i = new Intent(Profile_update.this, Homepage.class);
                    startActivity(i);
                    finish();
                }
            }
        });

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
                params.put(JsonField.KEY_USER_ID, userid);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Profile_update.this);
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
                        String mob = jsonObject1.getString(JsonField.KEY_USER_MOBILENO);

                        // tvId.setText(packageid);
                        update_name.setText(name);
                        update_mobile.setText(mob);


                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void getUpdateProfile(String userid) {
        username = update_name.getText().toString().trim();
        usermobile = update_mobile.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebUrl.KEY_EDIT_PROFILE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parsseUpdateResponser(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put(JsonField.KEY_USER_ID, userid);
                map.put(JsonField.KEY_USER_NAME, username);
                map.put(JsonField.KEY_USER_MOBILENO, usermobile);
                return map;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(Profile_update.this);
        requestQueue.add(stringRequest);

    }

    private void parsseUpdateResponser(String response) {
        Log.d("Response", response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.has(JsonField.FLAG)) {
                int flag = jsonObject.optInt(JsonField.FLAG);
                if (flag == 1) {
                    Intent i = new Intent(Profile_update.this, Homepage.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(this, "Please Try Again Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean checkUserName() {
        boolean isUserNameValid = false;
        if (update_name.getText().toString().trim().length() <= 0)
            update_name.setError("Enter Username");
        else {
            isUserNameValid = true;
        }
        return isUserNameValid;
    }

    private boolean checkMobileNumber() {
        boolean isMobileNumberValid = false;
        if (update_mobile.getText().toString().trim().length() <= 0) {
            update_mobile.setError("Enter Mobile Number");
        } else if (update_mobile.getText().toString().trim().length() == 10) {
            isMobileNumberValid = true;
        } else {
            update_mobile.setError("Enter Correct Mobile Number");
        }
        return isMobileNumberValid;
    }

}