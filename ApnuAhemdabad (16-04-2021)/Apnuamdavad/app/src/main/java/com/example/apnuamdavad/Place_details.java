package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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

public class Place_details extends AppCompatActivity {

    ImageView iv1;
    TextView tvName,tvDetails;
    String pid;
    ImageButton btn_placedeback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        iv1 = findViewById(R.id.iv1);
        tvName = findViewById(R.id.tvName);
        btn_placedeback = findViewById(R.id.btn_placedeback);
        btn_placedeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvDetails = findViewById(R.id.tvDetails);


        Intent intent = getIntent();
        pid=intent.getStringExtra(JsonField.PLACE_ID);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebUrl.PLACE_LIST_DISPLAY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseResponse(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put(JsonField.PLACE_ID,pid);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Place_details.this);
        requestQueue.add(stringRequest);

    }

    private void parseResponse(String response) {
        Log.d("T",response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int flag = jsonObject.optInt(JsonField.FLAG);
            if (flag==1){
                JSONArray jsonArray = jsonObject.optJSONArray(JsonField.PLACE_ARRAY);
                if (jsonArray.length()>0){
                    for (int i = 0; i< jsonArray.length();i++){
                        JSONObject jsonObject1= jsonArray.optJSONObject(i);
                        // String packageid = objPackage.getString(JsonField.PACKAGE_ID);
                        String id = jsonObject1.getString(JsonField.PLACE_ID);
                        String name = jsonObject1.getString(JsonField.PLACE_TITLE);
                        String details = jsonObject1.getString(JsonField.PLACE_DETAILS);
                        String img = jsonObject1.getString(JsonField.PLACE_IMG_PATH);

                        Glide.with(Place_details.this).load(WebUrl.KEY_PHOTO_PATH_URL +img).into(iv1);
                        // tvId.setText(packageid);
                        tvName.setText(name);
                        tvDetails.setText(details);


                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    }
