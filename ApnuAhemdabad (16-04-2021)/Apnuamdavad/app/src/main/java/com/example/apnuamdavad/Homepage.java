package com.example.apnuamdavad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apnuamdavad.Adapter.CategoryAdapter;
import com.example.apnuamdavad.Adapter.HomeCategoryAdapter;
import com.example.apnuamdavad.ApiHelper.JsonField;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.example.apnuamdavad.Listener.PlaceitemClickListener;
import com.example.apnuamdavad.Model.Category;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity implements PlaceitemClickListener,NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    //navigation Drawer
    LinearLayout contentView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;

    ViewFlipper viewFlipper1;

    RecyclerView rvhomecategory;
    ArrayList<Category> listCategory;

    Button btn_view_cart;
    UserSessionManager userSessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        userSessionManager = new UserSessionManager(this);


        viewFlipper1 = findViewById(R.id.slider);
        viewFlipper1.setFlipInterval(3000);
        viewFlipper1.startFlipping();

        contentView = findViewById(R.id.content1);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        menuIcon = findViewById(R.id.menu_icon);
        btn_view_cart = findViewById(R.id.btn_logout);

        if (userSessionManager.getLoginStatus()) {

           btn_view_cart.setVisibility(View.VISIBLE);

           btn_view_cart.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   userSessionManager.logout();
                   Intent intent=new Intent(Homepage.this,MainActivity.class);
                   startActivity(intent);
                   finish();
               }
           });
        } else {

        }

        navigationDrawer();

        rvhomecategory = (RecyclerView) findViewById(R.id.rvhomecategory);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Homepage.this, 3);
        rvhomecategory.setLayoutManager(gridLayoutManager);


        getCategory();


    }

    private void getCategory() {
        listCategory = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebUrl.CATEGORY_URL, new Response.Listener<String>() {
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

        RequestQueue requestQueue = Volley.newRequestQueue(Homepage.this);
        requestQueue.add(stringRequest);

    }

    private void parseJson(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            int flag = jsonObject.optInt(JsonField.FLAG);
            if (flag == 1) {
                JSONArray jsonArray = jsonObject.optJSONArray(JsonField.CATEGORY1_DISPLAY_ARRAY);
                if (jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject objCategory = jsonArray.optJSONObject(i);
                        String categoryId = objCategory.getString(JsonField.CATEGORY_ID);
                        String categoryName = objCategory.getString(JsonField.CATEGORY_NAME);
                        String categoryPhoto_path = objCategory.getString(JsonField.CATEGORY_PHOTO_PATH);

                        Category category = new Category();
                        category.setCategory_id(categoryId);
                        category.setCategory_name(categoryName);
                        category.setCategory_photo_path(categoryPhoto_path);

                        listCategory.add(category);

                    }

                    HomeCategoryAdapter categoryAdapter = new HomeCategoryAdapter(Homepage.this, listCategory);
                    categoryAdapter.setPlaceitemClickListener(this);
                    rvhomecategory.setAdapter(categoryAdapter);

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    //navigation drawer Function
    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

//         View header = navigationView.getHeaderView(0);
//
//        if (userSessionManager.getLoginStutus()) {
//
//            name = (TextView) header.findViewById(R.id.user_name);
//
//            name.setText(userSessionManager.getusername());
//
//        } else {
//            name = (TextView) header.findViewById(R.id.user_name);
//
//            name.setText("Keep Shopping Login");
//        }


        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(Homepage.this, Homepage.class);
                startActivity(intent);
                finish();
                break;


            case R.id.nav_category:
                Intent intent9 = new Intent(Homepage.this, CategoryActivity.class);
                startActivity(intent9);
                break;

            case R.id.nav_bus_route:
                Intent in = new Intent(Homepage.this, bus_route.class);
                startActivity(in);
                break;

            case R.id.nav_event:
                Intent intent4 = new Intent(Homepage.this, EventActivity.class);
                startActivity(intent4);
                break;

            case R.id.nav_profile:
                if (userSessionManager.getLoginStatus()) {
                    Intent intent1 = new Intent(Homepage.this, Profile.class);
                    startActivity(intent1);
                    break;
                } else {
                    Intent intent1 = new Intent(Homepage.this, MainActivity.class);
                    startActivity(intent1);
                    break;
                }


            case R.id.nav_news:
                Intent intent2 = new Intent(Homepage.this, NewsActivity.class);
                startActivity(intent2);
                break;

            case R.id.nav_Feedback:
                Intent intent5 = new Intent(Homepage.this, Feedback_master.class);
                startActivity(intent5);
                break;

            case R.id.nav_ContactUs:
                Intent intent6 = new Intent(Homepage.this, Contact_us.class);
                startActivity(intent6);
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void setOnItemClicked(ArrayList<Category> listCategory, int position) {
        Intent intent= new Intent(Homepage.this, Place_display.class);
        Category category =listCategory.get(position);
        String id=category.getCategory_id();
        intent.putExtra(JsonField.CATEGORY_ID,id);
        startActivity(intent);

    }
}
