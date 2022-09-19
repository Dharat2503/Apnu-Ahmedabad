package com.example.apnuamdavad.Listener;

import com.example.apnuamdavad.Model.Event;
import com.example.apnuamdavad.Model.News;

import java.util.ArrayList;

public interface NewsClickListener {
    public void setOnItemClicked(ArrayList<News> listNews, int position);

}
