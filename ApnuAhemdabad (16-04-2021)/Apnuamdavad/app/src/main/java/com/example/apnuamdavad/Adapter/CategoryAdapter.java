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
import com.example.apnuamdavad.Listener.PlaceitemClickListener;
import com.example.apnuamdavad.Model.Category;
import com.example.apnuamdavad.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewHolder> {
  Context context;

  ArrayList<Category> listCategory;

  PlaceitemClickListener placeitemClickListener;

  public PlaceitemClickListener getPlaceitemClickListener() {
    return placeitemClickListener;
  }

  public void setPlaceitemClickListener(PlaceitemClickListener placeitemClickListener) {
    this.placeitemClickListener = placeitemClickListener;
  }

  public CategoryAdapter(Context context, ArrayList<Category> listCategory) {
    this.context = context;
    this.listCategory = listCategory;
  }




  @NonNull
  @Override
  public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    context=parent.getContext();
    View view =LayoutInflater.from(context).inflate(R.layout.category_row_item,parent,false);

    return new viewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    Category category=listCategory.get(position);

    String name =category.getCategory_name();
    holder.tv1.setText(name);

    Glide.with(context).load(WebUrl.KEY_PHOTO_PATH_URL+category.getCategory_photo_path()).into(holder.img1);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        PlaceitemClickListener listener=getPlaceitemClickListener();
        listener.setOnItemClicked(listCategory,position);
      }
    });

  }

  @Override
  public int getItemCount() {
    return listCategory.size();
  }


  public class viewHolder extends RecyclerView.ViewHolder {
    ImageView img1;
    TextView tv1;

      public viewHolder(@NonNull View itemView) {
        super(itemView);

        img1=itemView.findViewById(R.id.img1);
        tv1=itemView.findViewById(R.id.tv1);
      }
    }


}

