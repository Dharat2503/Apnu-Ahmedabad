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
import com.example.apnuamdavad.Model.Subevent;
import com.example.apnuamdavad.R;

import java.util.ArrayList;

public class SubeventAdapter extends RecyclerView.Adapter<SubeventAdapter.ViewHolder> {

  Context context;
  ArrayList<Subevent>listSubevnt;

  public SubeventAdapter(Context context, ArrayList<Subevent> listSubevnt) {
    this.context = context;
    this.listSubevnt = listSubevnt;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    context = parent.getContext();
    View mView= LayoutInflater.from(context).inflate(R.layout.event_master_row_item,parent,false);
    return new ViewHolder(mView);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    Subevent subevent=listSubevnt.get(position);
    String name=subevent.getEvent_name();
    String location=subevent.getEvent_location();
    String deatils=subevent.getEvent_details();

    holder.ename.setText(name);
    holder.elocation.setText(location);
    holder.edetails.setText(deatils);

    Glide.with(context).load(WebUrl.KEY_PHOTO_PATH_URL+subevent.getEvent_photo_path()).into(holder.evimg);


  }

  @Override
  public int getItemCount() {
    return listSubevnt.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder{

    ImageView evimg;
    TextView ename,elocation,edetails;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      evimg=itemView.findViewById(R.id.evimg);
      ename=itemView.findViewById(R.id.ename);
      elocation=itemView.findViewById(R.id.elocation);
      edetails=itemView.findViewById(R.id.edetails);
    }
  }

}
