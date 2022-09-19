package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apnuamdavad.Adapter.PlaceAdapter;
import com.example.apnuamdavad.ApiHelper.JsonField;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.example.apnuamdavad.Listener.PlaceDisplayClickListener;
import com.example.apnuamdavad.Listener.PlaceitemClickListener;
import com.example.apnuamdavad.Model.Category;
import com.example.apnuamdavad.Model.Place;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Place_display extends AppCompatActivity implements PlaceDisplayClickListener {

    RecyclerView rvplace;
    ArrayList<Place> listPlaceMaster;
    String id;
    ImageButton btn_pdisplayback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_display);

        rvplace=findViewById(R.id.rvplace);
        btn_pdisplayback=findViewById(R.id.btn_pdisplayback);
        btn_pdisplayback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        id=intent.getStringExtra(JsonField.CATEGORY_ID);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Place_display.this);
        rvplace.setLayoutManager(linearLayoutManager);


        getCategory(id);

    }

    private void getCategory(String id) {
        listPlaceMaster = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebUrl.PLACE_LIST_DISPLAY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseJson(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put(JsonField.CATEGORY_ID, id);

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Place_display.this);
        requestQueue.add(stringRequest);
    }

    private void parseJson(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            int success = jsonObject.optInt(JsonField.FLAG);
            if (success == 1){
                JSONArray jsonArray = jsonObject.optJSONArray(JsonField.PLACE_LIST_ARRAY);
                if (jsonArray.length()>0){
                    for (int i = 0; i<jsonArray.length(); i++){
                        JSONObject objCategory = jsonArray.optJSONObject(i);
                        String pId = objCategory.optString(JsonField.PLACE_ID);
                        String Name = objCategory.optString(JsonField.PLACE_TITLE);
                        String img = objCategory.optString(JsonField.PLACE_IMG_PATH);

                        Place place =new Place();
                        place.setPlace_id(pId);
                        place.setPlace_title(Name);
                        place.setPlace_img_path(img);
                        listPlaceMaster.add(place);
                    }
                    PlaceAdapter placeAdapter = new PlaceAdapter(Place_display.this,listPlaceMaster);
                    placeAdapter.setPlaceDisplayClickListener(Place_display.this);

                    rvplace.setAdapter(placeAdapter);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setOnItemClicked(ArrayList<Place> listPlaceMaster, int position) {
        Intent intent= new Intent(Place_display.this, Place_details.class);
        Place place =listPlaceMaster.get(position);
        String id=place.getPlace_id();
        intent.putExtra(JsonField.PLACE_ID,id);
        startActivity(intent);
    }
}