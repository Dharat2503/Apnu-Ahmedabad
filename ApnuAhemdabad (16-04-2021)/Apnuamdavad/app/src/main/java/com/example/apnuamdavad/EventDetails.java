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

public class EventDetails extends AppCompatActivity {

    ImageView edetails_img;
    TextView tveDetails,tveName,tveloc;
    String id;

    ImageButton btn_main2back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        edetails_img = findViewById(R.id.edetails_img);
        tveDetails = findViewById(R.id.tveDetails);
        btn_main2back = findViewById(R.id.btn_main2back);
        btn_main2back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tveName = findViewById(R.id.tveName);
        tveloc = findViewById(R.id.tveloc);

        Intent intent = getIntent();
        id=intent.getStringExtra(JsonField.EVENT_ID);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebUrl.EVENT_MASTER_URL, new Response.Listener<String>() {
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
                params.put(JsonField.EVENT_ID,id);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(EventDetails.this);
        requestQueue.add(stringRequest);

    }

    private void parseResponse(String response) {
        Log.d("T",response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int flag = jsonObject.optInt(JsonField.FLAG);
            if (flag==1){
                JSONArray jsonArray = jsonObject.optJSONArray(JsonField.EVENT_MASTER_ARRAY);
                if (jsonArray.length()>0){
                    for (int i = 0; i< jsonArray.length();i++){
                        JSONObject jsonObject1= jsonArray.optJSONObject(i);
                        // String packageid = objPackage.getString(JsonField.PACKAGE_ID);
                        String id = jsonObject1.getString(JsonField.EVENT_ID);
                        String name = jsonObject1.getString(JsonField.EVENT_NAME);
                        String loc = jsonObject1.getString(JsonField.EVENT_LOCATION);
                        String details = jsonObject1.getString(JsonField.EVENT_DETAILS);
                        String img = jsonObject1.getString(JsonField.EVENT_PHOTO_PATH);

                        Glide.with(EventDetails.this).load(WebUrl.KEY_PHOTO_PATH_URL +img).into(edetails_img);
                        // tvId.setText(packageid);
                        tveName.setText(name);
                        tveDetails.setText(details);
                        tveloc.setText(loc);


                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}