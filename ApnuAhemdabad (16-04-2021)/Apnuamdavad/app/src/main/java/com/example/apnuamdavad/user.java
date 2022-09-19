package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apnuamdavad.ApiHelper.JsonField;
import com.example.apnuamdavad.ApiHelper.WebUrl;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class user extends AppCompatActivity implements View.OnClickListener {
  EditText et1,et2,et3,et4;
  TextView tv1,tv2;
  Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);



        et1=findViewById(R.id.et1);
      et2=findViewById(R.id.et2);
      et3=findViewById(R.id.et3);
      et4=findViewById(R.id.et4);
      tv1=findViewById(R.id.tv1);
      tv2=findViewById(R.id.tv2);
      btn1=findViewById(R.id.btn1);

      btn1.setOnClickListener(this);

    }

  @Override
  public void onClick(View v) {

      switch(v.getId()){
        case R.id.btn1:

          if (checkName() && checkmail() && checkPassword() && checkMobileno()){

            //Toast.makeText(this, "Validation Complete...", Toast.LENGTH_SHORT).show();

            sendSignupRequest();
             Intent intent = new Intent(user.this,welcome.class);
             startActivity(intent);

          }

          break;

      }

  }
   //call API

  private void sendSignupRequest() {

    StringRequest stringRequest = new StringRequest(Request.Method.POST, WebUrl.KEY_SIGNUP_URL, new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {
        parseSignupResponse(response);
        //call API response

      }
    }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
      }
    }){

      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String,String> params=new HashMap<>();

        params.put(JsonField.KEY_USER_NAME,et1.getText().toString());
        params.put(JsonField.KEY_USER_EMAIL,et2.getText().toString());
        params.put(JsonField.KEY_USER_PASSWORD,et3.getText().toString());
        params.put(JsonField.KEY_USER_MOBILENO,et4.getText().toString());

        return  params;
      }
    };

    RequestQueue requestQueue= Volley.newRequestQueue(user.this);
    requestQueue.add(stringRequest);

  }

  private void parseSignupResponse(String response) {

      Log.d("RESPONSE",response);

  }

  //validation

  private boolean checkName(){

    boolean isNameValid=false;

    if (et1.getText().toString().trim().length()<=0){

     et1.setError("Enter The Name");

    }
    else{

      isNameValid=true;
    }

    return isNameValid;
  }

  private boolean checkmail(){
    boolean isemailValid=false;

    String emailid = et2.getText().toString().trim();

    if (et2.getText().toString().trim().length()<=0){

      et2.setError("Enter The EmailId");

    }

    else if (Patterns.EMAIL_ADDRESS.matcher(emailid).matches()){

      isemailValid=true;
    }

    else {
      et2.setError("Enter The Correct Email");
    }

    return isemailValid;

  }

  public boolean checkPassword() {
    boolean isPasswordValid = false;
    final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$^&=]).{7,}$";
    if (et3.getText().toString().trim().length() <= 0){
      et3.setError("Enter Password");
    }
    else if (Pattern.compile(PASSWORD_PATTERN).matcher(et3.getText().toString().trim()).matches()){
      isPasswordValid=true;
    }
    else{
      et3.setError("Enter at least one digit,one lower case letter or one upper case letter,one special\n" +
        "character and length must be 7");
    }
    return isPasswordValid;
  }

  private boolean checkMobileno(){
    boolean isNumberValid = false;

    if (et4.getText().toString().trim().length() <= 0) {
      et4.setError("Enter Mobile Number");
    }
    else if (et4.getText().toString().trim().length() == 10) {
      isNumberValid = true;
    }
    else{
      et4.setError("Enter valid Number");
    }

    return isNumberValid;

  }



}
