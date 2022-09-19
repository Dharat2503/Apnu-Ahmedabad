package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apnuamdavad.Adapter.CategoryAdapter;
import com.example.apnuamdavad.ApiHelper.JsonField;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.example.apnuamdavad.Listener.PlaceitemClickListener;
import com.example.apnuamdavad.Model.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity  implements PlaceitemClickListener {

  RecyclerView rvCategory;
  ArrayList<Category> listCategory;
  ImageButton btn_cback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        rvCategory=findViewById(R.id.rvcategory);
        btn_cback = findViewById(R.id.btn_cback);
        btn_cback.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            finish();
          }
        });

      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CategoryActivity.this);
      rvCategory.setLayoutManager(linearLayoutManager);


      getCategory();
    }

  private void getCategory() {
      listCategory=new ArrayList<>();
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

    RequestQueue requestQueue= Volley.newRequestQueue(CategoryActivity.this);
    requestQueue.add(stringRequest);


  }

  private void parseJson(String response) {
    try {
      JSONObject jsonObject=new JSONObject(response);
      int flag=jsonObject.optInt(JsonField.FLAG);
      if (flag==1)
      {
        JSONArray jsonArray=jsonObject.optJSONArray(JsonField.CATEGORY1_DISPLAY_ARRAY);
        if (jsonArray.length()>0)
        {
            for (int i=0;i<jsonArray.length();i++)
            {
                JSONObject objCategory=jsonArray.optJSONObject(i);
                  String categoryId=objCategory.getString(JsonField.CATEGORY_ID);
                  String categoryName=objCategory.getString(JsonField.CATEGORY_NAME);
                  String categoryPhoto_path=objCategory.getString(JsonField.CATEGORY_PHOTO_PATH);

                  Category category =new Category();
                  category.setCategory_id(categoryId);
                  category.setCategory_name(categoryName);
                  category.setCategory_photo_path(categoryPhoto_path);

                  listCategory.add(category);


            }

          CategoryAdapter categoryAdapter = new CategoryAdapter(CategoryActivity.this,listCategory);
          categoryAdapter.setPlaceitemClickListener(CategoryActivity.this);
            rvCategory.setAdapter(categoryAdapter);

        }
      }

    } catch (JSONException e) {
      e.printStackTrace();
    }


  }

  @Override
  public void setOnItemClicked(ArrayList<Category> listCategory, int position)
  {
    Intent intent= new Intent(CategoryActivity.this, Place_display.class);
    Category category =listCategory.get(position);
    String id=category.getCategory_id();
    intent.putExtra(JsonField.CATEGORY_ID,id);
    startActivity(intent);


  }
}
