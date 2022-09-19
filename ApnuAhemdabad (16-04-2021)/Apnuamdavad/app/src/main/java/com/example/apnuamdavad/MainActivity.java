package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apnuamdavad.ApiHelper.JsonField;
import com.example.apnuamdavad.ApiHelper.WebUrl;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextInputEditText login_email,login_password;
    Button btn_login,btn_forgotpassword;
    TextView btn_registation;
    UserSessionManager userSessionManager;
    TextView tvskip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvskip = findViewById(R.id.tvskip);
        tvskip.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this,Homepage.class);
            startActivity(intent);
            finish();
          }
        });

        userSessionManager=new UserSessionManager(MainActivity.this);

      login_email=findViewById(R.id.login_email);
      login_password=findViewById(R.id.login_password);
      btn_forgotpassword=findViewById(R.id.btn_forgotpassword);

      btn_forgotpassword.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Intent intent=new Intent(MainActivity.this,forgot_pass.class);
          startActivity(intent);
        }
      });
      btn_login=findViewById(R.id.btn_login);
      btn_registation=findViewById(R.id.btn_registation);

      btn_registation.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Intent intent = new Intent(MainActivity.this,Regisatation.class);
          startActivity(intent);
        }
      });

      btn_login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            //create Function
            sendLoginRequest();
          }
        });

    }

  private void sendLoginRequest() {
    StringRequest stringRequest=new StringRequest(Request.Method.POST, WebUrl.KEY_LOGIN_URL, new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {
        parseLoginResponse(response);

      }
    }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
      }
    }){
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        //create object of map
        Map<String,String>params=new HashMap<>();

        params.put(JsonField.KEY_USER_EMAIL,login_email.getText().toString());
        params.put(JsonField.KEY_USER_PASSWORD,login_password.getText().toString());
        return params;
      }
    };
    RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
    requestQueue.add(stringRequest);
  }

  private void parseLoginResponse(String response) {
    try {
      JSONObject jsonObject=new JSONObject(response);
      if (jsonObject.has(JsonField.FLAG))
      {
        int flag=jsonObject.optInt(JsonField.FLAG);
        if (flag==1)
        {
          Log.d("Tag","Login Success");
          JSONObject jsonArray=jsonObject.optJSONObject(JsonField.USER_LOGIN_ARRAY);
          Log.d("RESPONSE",JsonField.USER_LOGIN_ARRAY);

          String userID= jsonArray.optString(JsonField.KEY_USER_ID);
          String userName= jsonArray.optString(JsonField.KEY_USER_NAME);
          String userEmail= jsonArray.optString(JsonField.KEY_USER_EMAIL);
          String userMobile=jsonArray.optString(JsonField.KEY_USER_MOBILENO);

          userSessionManager.setLoginStatus();

          userSessionManager.setUserDetails(userID,userName,userEmail,userMobile);

          Intent intent=new Intent(MainActivity.this,Homepage.class);
          finish();
          startActivity(intent);
          Toast.makeText(getApplicationContext(), "WELCOME..", Toast.LENGTH_SHORT).show();
        }
        else {
          Toast.makeText(this, "Invalid UserName or Password", Toast.LENGTH_SHORT).show();
        }
      }


    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
}
