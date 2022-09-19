package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apnuamdavad.Adapter.BusrouteAdapter;
import com.example.apnuamdavad.Adapter.CategoryAdapter;
import com.example.apnuamdavad.ApiHelper.JsonField;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.example.apnuamdavad.Model.BusRoute;
import com.example.apnuamdavad.Model.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class bus_route extends AppCompatActivity {

    RecyclerView rvbusroute;
    ArrayList<BusRoute> listbusroute;
    ImageButton btn_busback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_route);

        rvbusroute=findViewById(R.id.rvbusroute);
        btn_busback = findViewById(R.id.btn_busback);
        btn_busback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bus_route.this);
        rvbusroute.setLayoutManager(linearLayoutManager);


        getRoute();
    }

    private void getRoute() {
        listbusroute=new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebUrl.KEY_BUS_ROUTE_URL, new Response.Listener<String>() {
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

        RequestQueue requestQueue= Volley.newRequestQueue(bus_route.this);
        requestQueue.add(stringRequest);

    }

    private void parseJson(String response) {
        try {
            JSONObject jsonObject=new JSONObject(response);
            int flag=jsonObject.optInt(JsonField.FLAG);
            if (flag==1)
            {
                JSONArray jsonArray=jsonObject.optJSONArray(JsonField.ROUTE_ARRAY);
                if (jsonArray.length()>0)
                {
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject objCategory=jsonArray.optJSONObject(i);
                        String busno=objCategory.getString(JsonField.BUS_NO);
                        String sourcetitle=objCategory.getString(JsonField.SOURCE_TITLE);
                        String destianationtitle=objCategory.getString(JsonField.DESTINATION_TITLE);

                        String sourceLatitude = objCategory.getString(JsonField.SOURCE_LAT);
                        String sourceLongitude = objCategory.getString(JsonField.SOURCE_LONG);

                        String destinationLatitude = objCategory.getString(JsonField.DESTINATION_LAT);
                        String destinationLongitude = objCategory.getString(JsonField.DESTINATION_LONG);

                        BusRoute busRoute =new BusRoute();
                        busRoute.setBus_no(busno);
                        busRoute.setSource_title(sourcetitle);
                        busRoute.setDestination_title(destianationtitle);

                        busRoute.setSource_lat(sourceLatitude);
                        busRoute.setSource_long(sourceLongitude);

                        busRoute.setDestination_lat(destinationLatitude);
                        busRoute.setDestination_long(destinationLongitude);

                        listbusroute.add(busRoute);


                    }

                    BusrouteAdapter busrouteAdapter = new BusrouteAdapter(bus_route.this,listbusroute);
                    rvbusroute.setAdapter(busrouteAdapter);

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}