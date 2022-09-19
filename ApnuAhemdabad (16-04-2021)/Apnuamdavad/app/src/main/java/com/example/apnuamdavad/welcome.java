package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apnuamdavad.Model.Event;

public class welcome extends AppCompatActivity {
  UserSessionManager userSessionManager;
  TextView tv,tv1,tv2,tv3,tv4,tv5,tv6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        userSessionManager =new UserSessionManager(welcome.this);
        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);
      tv2=findViewById(R.id.tv2);
      tv3=findViewById(R.id.tv3);
      tv4=findViewById(R.id.tv4);
      tv5=findViewById(R.id.tv5);
      tv6=findViewById(R.id.tv6);

        if (userSessionManager.getLoginStatus())
        {
          Toast.makeText(this, "Welcome User", Toast.LENGTH_SHORT).show();
        }
        else
        {
          Intent intent=new Intent(welcome.this,MainActivity.class);
          startActivity(intent);
        }
        tv.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            userSessionManager.logout();
            Intent intent=new Intent(welcome.this,MainActivity.class);
            startActivity(intent);
          }


        });

        tv1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent=new Intent(welcome.this,CategoryActivity.class);
            startActivity(intent);
          }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent=new Intent(welcome.this, EventActivity.class);
            startActivity(intent);
          }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            Intent intent=new Intent(welcome.this, Feedback_master.class);
            startActivity(intent);

          }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent=new Intent(welcome.this, history.class);
            startActivity(intent);
          }
        });

        tv5.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent=new Intent(welcome.this, NewsActivity.class);
            startActivity(intent);
          }
        });

        tv6.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent=new Intent(welcome.this, Change_passActivity.class);
            startActivity(intent);
          }
        });


    }
}
