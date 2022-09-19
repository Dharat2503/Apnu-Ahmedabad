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

public class News_Details extends AppCompatActivity {

    TextView news_details,news_name;
    ImageView n_image;
    String id;
    ImageButton btn_newsdetailback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__details);

        news_name = findViewById(R.id.news_name);
        btn_newsdetailback = findViewById(R.id.btn_newsdetailback);
        btn_newsdetailback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        news_details = findViewById(R.id.news_details);
        n_image =findViewById(R.id.n_image);

        Intent intent=getIntent();
        id=intent.getStringExtra(JsonField.NEWS_ID);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebUrl.NEWS_DETAILS_URL, new Response.Listener<String>() {
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
                params.put(JsonField.NEWS_ID,id);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(News_Details.this);
        requestQueue.add(stringRequest);


    }

    private void parseResponse(String response) {
        Log.d("T",response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int flag = jsonObject.optInt(JsonField.FLAG);
            if (flag==1){
                JSONArray jsonArray = jsonObject.optJSONArray(JsonField.NEWS_DETAILS_ARRAY);
                if (jsonArray.length()>0){
                    for (int i = 0; i< jsonArray.length();i++){
                        JSONObject jsonObject1= jsonArray.optJSONObject(i);
                        // String packageid = objPackage.getString(JsonField.PACKAGE_ID);
                        String id = jsonObject1.getString(JsonField.NEWS_ID);
                        String name = jsonObject1.getString(JsonField.NEWS_TITLE);
                        String details = jsonObject1.getString(JsonField.NEWS_DETAILS);
                        String img = jsonObject1.getString(JsonField.NEWS_PHOTO);

                        Glide.with(News_Details.this).load(WebUrl.KEY_PHOTO_PATH_URL +img).into(n_image);
                        // tvId.setText(packageid);
                        news_name.setText(name);
                        news_details.setText(details);


                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    }
