package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apnuamdavad.Adapter.EventAdapter;
import com.example.apnuamdavad.ApiHelper.JsonField;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.example.apnuamdavad.Listener.EventitemClickListener;
import com.example.apnuamdavad.Model.Event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity implements EventitemClickListener {

  RecyclerView rvevent;
  ArrayList<Event> listEvent;
  ImageButton btn_emainback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        rvevent=findViewById(R.id.rvevent);
        btn_emainback = findViewById(R.id.btn_emainback);
        btn_emainback.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            finish();
          }
        });

      LinearLayoutManager linearLayoutManager=new LinearLayoutManager(EventActivity.this);
      rvevent.setLayoutManager(linearLayoutManager);

      getEvent();
    }

  private void getEvent() {
      listEvent=new ArrayList<>();
    StringRequest stringRequest=new StringRequest(Request.Method.POST, WebUrl.EVENT_TYPE_URL, new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {
            parseJson(response);
      }
    }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
         error.printStackTrace();
      }
    });
    RequestQueue requestQueue= Volley.newRequestQueue(EventActivity.this);
    requestQueue.add(stringRequest);

  }

  private void parseJson(String response) {
    try {
      JSONObject jsonObject=new JSONObject(response);
      int flag=jsonObject.optInt(JsonField.FLAG);
      if (flag==1)
      {
        JSONArray jsonArray=jsonObject.optJSONArray(JsonField.EVENT_TYPE_ARRAY);

        if (jsonArray.length()>0)
        {
          for (int i=0;i<jsonArray.length();i++)
          {
            JSONObject objEvent=jsonArray.optJSONObject(i);
            String eventtypeId=objEvent.getString(JsonField.EVENT_TYPE_ID);
            String eventtypename=objEvent.getString(JsonField.EVENT_TYPE_NAME);

            Event event=new Event();
            event.setEvent_type_id(eventtypeId);
            event.setEvent_type_name(eventtypename);

            listEvent.add(event);

          }
          EventAdapter eventAdapter=new EventAdapter(EventActivity.this,listEvent);

          //call setEventitemClickListener() method of EventAdapter
          eventAdapter.setEventitemClickListener(EventActivity.this);
          rvevent.setAdapter(eventAdapter);
        }
      }

    } catch (JSONException e) {
      e.printStackTrace();
    }


  }

  @Override
  public void setOnItemClicked(ArrayList<Event> listEvent, int position) {
    Intent intent=new Intent(EventActivity.this,Event_masterActivity.class);
    Event event=listEvent.get(position);
    String id=event.getEvent_type_id();
    String name=event.getEvent_type_name();
    intent.putExtra(JsonField.EVENT_TYPE_ID,id);
    intent.putExtra(JsonField.EVENT_TYPE_NAME,name);
    startActivity(intent);

  }
}
