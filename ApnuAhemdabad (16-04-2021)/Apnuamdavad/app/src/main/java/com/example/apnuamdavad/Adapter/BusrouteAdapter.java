package com.example.apnuamdavad.Adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.example.apnuamdavad.Listener.PlaceitemClickListener;
import com.example.apnuamdavad.Model.BusRoute;
import com.example.apnuamdavad.Model.Category;
import com.example.apnuamdavad.R;

import java.util.ArrayList;
import java.util.Locale;

public class BusrouteAdapter extends RecyclerView.Adapter<BusrouteAdapter.viewHolder> {
    Context context;

    ArrayList<BusRoute> listbusroute;


    public BusrouteAdapter(Context context, ArrayList<BusRoute> listbusroute) {
        this.context = context;
        this.listbusroute = listbusroute;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.bus_route_row, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        BusRoute busRoute = listbusroute.get(position);

        String bno = busRoute.getBus_no();
        holder.tv_bus_no.setText(bno);

        String stitle = busRoute.getSource_title();
        holder.tv_source.setText(stitle);

        String dtitle = busRoute.getDestination_title();
        holder.tv_destination.setText(dtitle);


        holder.btn_show_route_in_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/maps?saddr="+busRoute.getSource_lat()+","+busRoute.getSource_long()+"&daddr="+busRoute.getDestination_lat()+","+busRoute.getDestination_long();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    try {
                        Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        context.startActivity(unrestrictedIntent);
                    } catch (ActivityNotFoundException innerEx) {
                        Toast.makeText(context, "Please install a maps application", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return listbusroute.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tv_bus_no, tv_destination, tv_source;
        Button btn_show_route_in_maps;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tv_source = itemView.findViewById(R.id.tv_source);
            tv_destination = itemView.findViewById(R.id.tv_destination);
            tv_bus_no = itemView.findViewById(R.id.tv_bus_no);
            btn_show_route_in_maps = itemView.findViewById(R.id.btn_show_route_in_maps);
        }
    }


}

