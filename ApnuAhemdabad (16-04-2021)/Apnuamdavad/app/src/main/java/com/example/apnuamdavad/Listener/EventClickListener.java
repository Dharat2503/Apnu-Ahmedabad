package com.example.apnuamdavad.Listener;

import com.example.apnuamdavad.Model.Event;
import com.example.apnuamdavad.Model.EventDetails;

import java.util.ArrayList;

public interface EventClickListener {
    public void setOnItemClicked(ArrayList<EventDetails> listeventDetails, int position);

}
