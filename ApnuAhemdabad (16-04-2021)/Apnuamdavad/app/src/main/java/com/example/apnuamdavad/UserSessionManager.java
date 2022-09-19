package com.example.apnuamdavad;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.apnuamdavad.ApiHelper.JsonField;

public class UserSessionManager {

  //define key
  private  static  final  String MY_PREF="user_pref";
  private  static  final  String IS_LOGIN="is_login";

  Context mContext;
  SharedPreferences mSharedPreferences;

  private  final SharedPreferences.Editor mEditor;

  public UserSessionManager(Context mContext) {
    this.mContext = mContext;
    mSharedPreferences=mContext.getSharedPreferences(MY_PREF,Context.MODE_PRIVATE);
    mEditor=mSharedPreferences.edit();
  }

  public void setLoginStatus()
  {
    mEditor.putBoolean(IS_LOGIN,true).commit();
  }

  public boolean getLoginStatus()
  {
    return mSharedPreferences.getBoolean(IS_LOGIN,false);

  }

  public  void setUserDetails(String strUserId,String strUserName,String strUserEmail,String strUserNo)
  {
    mEditor.putString(JsonField.KEY_USER_ID,strUserId);
    mEditor.putString(JsonField.KEY_USER_NAME,strUserName);
    mEditor.putString(JsonField.KEY_USER_EMAIL,strUserEmail);
    mEditor.putString(JsonField.KEY_USER_MOBILENO,strUserNo);
    mEditor.commit();

  }
  public void logout()
  {
    mEditor.remove(JsonField.KEY_USER_ID);
    mEditor.remove(JsonField.KEY_USER_NAME);
    mEditor.remove(JsonField.KEY_USER_EMAIL);
    mEditor.remove(JsonField.KEY_USER_MOBILENO);
    mEditor.remove(IS_LOGIN);
    mEditor.commit();
  }

  public String getUserID()
  {
    return mSharedPreferences.getString(JsonField.KEY_USER_ID,"");
  }

  public String getusername(){
    SharedPreferences sharedPreferences=mContext.getSharedPreferences(MY_PREF,Context.MODE_PRIVATE);
    return sharedPreferences.getString(JsonField.KEY_USER_NAME,null);
  }

  public String getemail(){
    SharedPreferences sharedPreferences=mContext.getSharedPreferences(MY_PREF,Context.MODE_PRIVATE);
    return sharedPreferences.getString(JsonField.KEY_USER_EMAIL,null);
  }

  public String getmobile(){
    SharedPreferences sharedPreferences=mContext.getSharedPreferences(MY_PREF,Context.MODE_PRIVATE);
    return sharedPreferences.getString(JsonField.KEY_USER_MOBILENO,null);
  }

}

