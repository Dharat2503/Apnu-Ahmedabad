package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

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
import com.example.apnuamdavad.Model.Place;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Place_master extends AppCompatActivity {

  RecyclerView rvplace;
  ArrayList<Place> listPlaceMaster;
  private String id,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        rvplace=findViewById(R.id.rvplace);

      Intent intent=getIntent();
      id=intent.getStringExtra(JsonField.CATEGORY_ID);
      name=intent.getStringExtra(JsonField.CATEGORY_NAME);

      LinearLayoutManager linearLayoutManager=new LinearLayoutManager(Place_master.this);
      rvplace.setLayoutManager((linearLayoutManager));

      getPlace(id);

    }

  private void getPlace(String id)
  {

      listPlaceMaster =new ArrayList<>();
    StringRequest stringRequest=new StringRequest(Request.Method.POST, WebUrl.PLACE_URL, new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {

          parseJson(response.toString());

      }
    }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
          error.printStackTrace();

      }
    })
    {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String,String>map=new HashMap<>();
        map.put(JsonField.CATEGORY_ID,id);

        return map;
      }
    };

    RequestQueue requestQueue= Volley.newRequestQueue(Place_master.this);
    requestQueue.add(stringRequest);

  }

  private void parseJson(String toString) {
    try {
      JSONObject jsonObject =new JSONObject(toString);
      int success=jsonObject.optInt(JsonField.FLAG);
      if (success==1)
      {
        JSONArray jsonArray=jsonObject.optJSONArray(JsonField.PLACE_ARRAY);
          if (jsonArray.length()>0)
          {
            for (int i=0;i<jsonArray.length();i++)
            {
              JSONObject objplace=jsonArray.optJSONObject(i);
              String Place_id=objplace.optString(JsonField.PLACE_ID);
              String Place_title=objplace.optString(JsonField.PLACE_TITLE);
              String Category_id=objplace.optString(JsonField.CATEGORY_ID);
              String Place_details=objplace.optString(JsonField.PLACE_DETAILS);
              String Place_img_path=objplace.optString(JsonField.PLACE_IMG_PATH);


              Place placeMaster =new Place();
              placeMaster.setPlace_title(Place_title);
              placeMaster.setCategory_id(Category_id);
              placeMaster.setPlace_details(Place_details);
              placeMaster.setPlace_img_path(Place_img_path);
              listPlaceMaster.add(placeMaster);
            }
            PlaceAdapter placeAdapter=new PlaceAdapter(Place_master.this, listPlaceMaster);
            rvplace.setAdapter(placeAdapter);
          }
      }

    } catch (JSONException e) {
      e.printStackTrace();
    }


  }
}
