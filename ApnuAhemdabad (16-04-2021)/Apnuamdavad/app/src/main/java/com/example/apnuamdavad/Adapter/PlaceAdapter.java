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
import com.example.apnuamdavad.Listener.PlaceDisplayClickListener;
import com.example.apnuamdavad.Listener.PlaceitemClickListener;
import com.example.apnuamdavad.Model.Place;
import com.example.apnuamdavad.Place_master;
import com.example.apnuamdavad.R;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    Context context;
    ArrayList<Place> listPlaceMaster;
    PlaceDisplayClickListener placeDisplayClickListener;

    public void setPlaceDisplayClickListener(PlaceDisplayClickListener placeDisplayClickListener) {
        this.placeDisplayClickListener = placeDisplayClickListener;
    }

    public PlaceDisplayClickListener getPlaceDisplayClickListener() {
        return placeDisplayClickListener;
    }

    public PlaceAdapter(Context context, ArrayList<Place> listPlaceMaster) {
        this.context = context;
        this.listPlaceMaster = listPlaceMaster;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View pView = LayoutInflater.from(context).inflate(R.layout.place_row_list, parent, false);
        return new ViewHolder(pView);



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Place placeMaster = listPlaceMaster.get(position);
        String name = placeMaster.getPlace_title();

        holder.pname.setText(name);

        Glide.with(context).load(WebUrl.KEY_PHOTO_PATH_URL + placeMaster.getPlace_img_path()).into(holder.p_image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaceDisplayClickListener placeDisplayClickListener=getPlaceDisplayClickListener();
                placeDisplayClickListener.setOnItemClicked(listPlaceMaster,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listPlaceMaster.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView p_image;
        TextView pname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pname = itemView.findViewById(R.id.pname);
            p_image = itemView.findViewById(R.id.p_image);
        }
    }
}
