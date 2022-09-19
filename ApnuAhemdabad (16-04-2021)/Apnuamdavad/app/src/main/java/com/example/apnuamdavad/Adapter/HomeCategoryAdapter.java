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

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder>{

    Context context;

    ArrayList<Category> listCategory;

    PlaceitemClickListener placeitemClickListener;

    public PlaceitemClickListener getPlaceitemClickListener() {
        return placeitemClickListener;
    }

    public void setPlaceitemClickListener(PlaceitemClickListener placeitemClickListener) {
        this.placeitemClickListener = placeitemClickListener;
    }

    public HomeCategoryAdapter(Context context, ArrayList<Category> listCategory) {
        this.context = context;
        this.listCategory = listCategory;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view =LayoutInflater.from(context).inflate(R.layout.home_page_category_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category=listCategory.get(position);

        String name =category.getCategory_name();
        holder.c_title.setText(name);

        Glide.with(context).load(WebUrl.KEY_PHOTO_PATH_URL+category.getCategory_photo_path()).into(holder.c_img);
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



    public class ViewHolder extends RecyclerView.ViewHolder {

    CircleImageView c_img;
    TextView c_title;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        c_img = itemView.findViewById(R.id.c_img);
        c_title = itemView.findViewById(R.id.c_title);
    }
}



}
