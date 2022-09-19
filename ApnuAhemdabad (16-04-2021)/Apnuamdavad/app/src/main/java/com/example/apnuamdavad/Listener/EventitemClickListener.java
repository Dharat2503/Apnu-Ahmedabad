package com.example.apnuamdavad.Listener;

import com.example.apnuamdavad.Model.Event;

import java.util.ArrayList;
//create user define method setOnClicked() method and pass Arraylist&Position as parameters
public interface EventitemClickListener {
  public void setOnItemClicked(ArrayList<Event>listEvent,int position);

}
