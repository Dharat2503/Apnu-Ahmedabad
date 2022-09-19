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
import com.example.apnuamdavad.Adapter.NewsAdapter;
import com.example.apnuamdavad.ApiHelper.JsonField;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.example.apnuamdavad.Listener.NewsClickListener;
import com.example.apnuamdavad.Model.Category;
import com.example.apnuamdavad.Model.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity implements NewsClickListener {
  RecyclerView rvNews;
  ArrayList<News>listnews;
  ImageButton btn_newsmback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        rvNews=findViewById(R.id.rvNews);
      btn_newsmback=findViewById(R.id.btn_newsmback);
      btn_newsmback.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          finish();
        }
      });

      LinearLayoutManager linearLayoutManager=new LinearLayoutManager(NewsActivity.this);
      rvNews.setLayoutManager(linearLayoutManager);

      getNews();
    }

  private void getNews() {

      listnews= new ArrayList<>();
    StringRequest stringRequest=new StringRequest(Request.Method.POST, WebUrl.NEWS_URL, new Response.Listener<String>() {
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

    RequestQueue requestQueue= Volley.newRequestQueue(NewsActivity.this);
    requestQueue.add(stringRequest);

  }

  private void parseJson(String response) {

    try {
      JSONObject jsonObject = new JSONObject(response);
      int flag=jsonObject.optInt(JsonField.FLAG);
      if(flag==1)
      {
        JSONArray jsonArray=jsonObject.optJSONArray(JsonField.NEWS_ARRAY);
        if (jsonArray.length()>0)
        {
          for (int i=0;i<jsonArray.length();i++) {
            JSONObject objnews=jsonArray.optJSONObject(i);
            String News_id=objnews.getString(JsonField.NEWS_ID);
            String news_title=objnews.getString(JsonField.NEWS_TITLE) ;

            News news=new News();
            news.setNews_id(News_id);
            news.setNews_title(news_title);
            listnews.add(news);

          }

          NewsAdapter newsAdapter= new NewsAdapter(NewsActivity.this,listnews);
          newsAdapter.setNewsClickListener(this);
          rvNews.setAdapter(newsAdapter);

        }
      }

    } catch (JSONException e) {
      e.printStackTrace();
    }


  }

  @Override
  public void setOnItemClicked(ArrayList<News> listNews, int position) {
    Intent intent= new Intent(NewsActivity.this, News_Details.class);
    News news =listnews.get(position);
    String id=news.getNews_id();
    intent.putExtra(JsonField.NEWS_ID,id);
    startActivity(intent);
  }
}
