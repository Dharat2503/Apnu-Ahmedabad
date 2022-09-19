package com.example.apnuamdavad.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.example.apnuamdavad.Listener.NewsClickListener;
import com.example.apnuamdavad.Listener.PlaceitemClickListener;
import com.example.apnuamdavad.Model.News;
import com.example.apnuamdavad.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
  Context context;
  ArrayList<News> listNews;

  NewsClickListener newsClickListener;

  public NewsClickListener getNewsClickListener() {
    return newsClickListener;
  }

  public void setNewsClickListener(NewsClickListener newsClickListener) {
    this.newsClickListener = newsClickListener;
  }

  public NewsAdapter(Context context, ArrayList<News> listNews) {
    this.context = context;
    this.listNews = listNews;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    context=parent.getContext();
    View view=LayoutInflater.from(context).inflate(R.layout.news_row_item,parent,false);
    return new ViewHolder(view);

  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    News news=listNews.get(position);
    String title=news.getNews_title();
    holder.tv1.setText(title);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        NewsClickListener listener=getNewsClickListener();
        listener.setOnItemClicked(listNews,position);
      }
    });



  }

  @Override
  public int getItemCount() {
    return listNews.size();
  }


  public  class ViewHolder extends  RecyclerView.ViewHolder{
    TextView tv1;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);

      tv1=itemView.findViewById(R.id.tv1);


    }
  }
}
