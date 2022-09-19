package com.example.apnuamdavad.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apnuamdavad.Listener.EventitemClickListener;
import com.example.apnuamdavad.Model.Event;
import com.example.apnuamdavad.R;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

  Context context;
  ArrayList<Event> listEvent;
//Create object of EventitemClickListener interface
EventitemClickListener eventitemClickListener;

  //add get EventitemClickListener() method
  public EventitemClickListener getEventitemClickListener() {
    return eventitemClickListener;
  }

  //add setEventitemClickListener() method and pass EventitemClickListener interface as a parameter
  public void setEventitemClickListener(EventitemClickListener eventitemClickListener) {
    this.eventitemClickListener = eventitemClickListener;
  }

  public EventAdapter(Context context, ArrayList<Event> listEvent) {
    this.context = context;
    this.listEvent = listEvent;

  }


  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    context=parent.getContext();
    View view=LayoutInflater.from(context).inflate(R.layout.event_row_item,parent,false);

    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Event event=listEvent.get(position);
    String name=event.getEvent_type_name();
    holder.tv1.setText(name);

    //add setOnClickListener() of ViewHolder to set onclick event of holder's component
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

          //iitialize getEventitemClickListener() method to EventitemClickListener() interface
        EventitemClickListener listener=getEventitemClickListener();
        //Now call setOnitemClicked() method of Categoryitemclicklistner interface
        //Pass arraylist object&position of item as parameters
        listener.setOnItemClicked(listEvent,position);



      }
    });

  }

  @Override
  public int getItemCount() {
    return listEvent.size();
  }


  public class ViewHolder extends RecyclerView.ViewHolder{
    TextView tv1;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);

      tv1=itemView.findViewById(R.id.tv1);
    }
  }
}
