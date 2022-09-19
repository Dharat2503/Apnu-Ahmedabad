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
import com.example.apnuamdavad.Adapter.EventDisplayAdapter;
import com.example.apnuamdavad.Adapter.SubeventAdapter;
import com.example.apnuamdavad.ApiHelper.JsonField;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.example.apnuamdavad.Listener.EventClickListener;
import com.example.apnuamdavad.Model.Category;
import com.example.apnuamdavad.Model.EventDetails;
import com.example.apnuamdavad.Model.Subevent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Event_masterActivity extends AppCompatActivity implements EventClickListener {

    RecyclerView rveventmaster;
    ArrayList<EventDetails> listeventDetails;
    private String id;
    private String name;
    ImageButton btn_main3back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_master);
        rveventmaster = findViewById(R.id.rveventmaster);

        btn_main3back = findViewById(R.id.btn_main3back);
        btn_main3back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //get event_type_id & event type name from EventActivity
        Intent intent = getIntent();
        id = intent.getStringExtra(JsonField.EVENT_TYPE_ID);
        name = intent.getStringExtra(JsonField.EVENT_TYPE_NAME);

        //Set layout using setLayoutManager()
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Event_masterActivity.this);
        rveventmaster.setLayoutManager(linearLayoutManager);

        getSubevent(id);

    }

    private void getSubevent(String id) {

        listeventDetails = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebUrl.EVENT_MASTER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                parseJson(response.toString());

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                //create object of hash map
                Map<String, String> map = new HashMap<>();
                map.put(JsonField.EVENT_TYPE_ID, id);
                return map;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Event_masterActivity.this);
        requestQueue.add(stringRequest);
    }

    private void parseJson(String s) {

        try {
            JSONObject jsonObject = new JSONObject(s);
            int success = jsonObject.optInt(JsonField.FLAG);
            if (success == 1) {
                JSONArray jsonArray = jsonObject.optJSONArray(JsonField.EVENT_MASTER_ARRAY);
                if (jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject objEvent = jsonArray.optJSONObject(i);
                        String Event_id = objEvent.optString(JsonField.EVENT_ID);
                        String Event_name = objEvent.optString(JsonField.EVENT_NAME);
                        String Event_location = objEvent.optString(JsonField.EVENT_LOCATION);
                        String img = objEvent.optString(JsonField.EVENT_PHOTO_PATH);

                        EventDetails eventDetails = new EventDetails();
                        eventDetails.setEvent_id(Event_id);
                        eventDetails.setEvent_name(Event_name);
                        eventDetails.setEvent_location(Event_location);
                        eventDetails.setEvent_photo_path(img);
                        listeventDetails.add(eventDetails);
                    }

                    EventDisplayAdapter eventDisplayAdapter = new EventDisplayAdapter(Event_masterActivity.this, listeventDetails);
                    eventDisplayAdapter.setEventClickListener(this);
                    rveventmaster.setAdapter(eventDisplayAdapter);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setOnItemClicked(ArrayList<EventDetails> listeventDetails, int position) {
        Intent intent = new Intent(Event_masterActivity.this, com.example.apnuamdavad.EventDetails.class);
        EventDetails eventDetails = listeventDetails.get(position);
        String id = eventDetails.getEvent_id();
        intent.putExtra(JsonField.EVENT_ID, id);
        startActivity(intent);
    }
}
