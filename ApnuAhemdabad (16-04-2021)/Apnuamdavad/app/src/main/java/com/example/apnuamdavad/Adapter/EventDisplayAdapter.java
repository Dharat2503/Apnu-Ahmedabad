package com.example.apnuamdavad.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.example.apnuamdavad.Listener.EventClickListener;
import com.example.apnuamdavad.Listener.EventitemClickListener;
import com.example.apnuamdavad.Model.Event;
import com.example.apnuamdavad.Model.EventDetails;
import com.example.apnuamdavad.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class EventDisplayAdapter extends RecyclerView.Adapter<EventDisplayAdapter.ViewHolder> {

    Context context;

    public EventDisplayAdapter(Context context, ArrayList<EventDetails> listeventDetails) {
        this.context = context;
        this.listeventDetails = listeventDetails;
    }

    ArrayList<EventDetails> listeventDetails;
    //Create object of EventitemClickListener interface
    EventClickListener eventClickListener;

    public EventClickListener getEventClickListener() {
        return eventClickListener;
    }

    public void setEventClickListener(EventClickListener eventClickListener) {
        this.eventClickListener = eventClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.eventdisplay_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EventDetails event = listeventDetails.get(position);
        String name = event.getEvent_name();
        holder.e_name.setText(name);
        String location = event.getEvent_location();
        holder.e_loc.setText(location);
        Glide.with(context).load(WebUrl.KEY_PHOTO_PATH_URL+event.getEvent_photo_path()).into(holder.e_img);

        //add setOnClickListener() of ViewHolder to set onclick event of holder's component
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //iitialize getEventitemClickListener() method to EventitemClickListener() interface
                EventClickListener listener = getEventClickListener();
                //Now call setOnitemClicked() method of Categoryitemclicklistner interface
                //Pass arraylist object&position of item as parameters
                listener.setOnItemClicked(listeventDetails, position);


            }
        });

    }

    @Override
    public int getItemCount() {
        return listeventDetails.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView e_name,e_loc;
        CircleImageView e_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            e_name = itemView.findViewById(R.id.e_name);
            e_loc = itemView.findViewById(R.id.e_loc);
            e_img = itemView.findViewById(R.id.e_img);
        }
    }
}
