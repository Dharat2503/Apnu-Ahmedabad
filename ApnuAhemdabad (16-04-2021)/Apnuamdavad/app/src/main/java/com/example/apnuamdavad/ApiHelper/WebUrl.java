package com.example.apnuamdavad.ApiHelper;

public class WebUrl {
  private  static final String IP_ADDRESS="192.168.0.103";
  private static final  String KEY_MAIN_URL="http://"+ IP_ADDRESS+"/Api/";
  public static final  String KEY_PHOTO_PATH_URL="http://"+ IP_ADDRESS+"/Api/imgs/";
  public static final String KEY_SIGNUP_URL = KEY_MAIN_URL + "user_Registation.php";
  public static final String KEY_LOGIN_URL=KEY_MAIN_URL+"user_login.php";
  public static final String KEY_DISPLAY_PROFILE_URL=KEY_MAIN_URL+"display_profile.php";
  public static final String KEY_BUS_ROUTE_URL=KEY_MAIN_URL+"bus-list.php";
  public static final String KEY_EDIT_PROFILE_URL=KEY_MAIN_URL+"edit_profile.php";
  public static final String KEY_FORGOT_PASS_URL=KEY_MAIN_URL+"forgot-password.php";
  public static final String CATEGORY_URL = KEY_MAIN_URL + "display_category.php";
  public static final String EVENT_TYPE_URL = KEY_MAIN_URL + "display_event_type.php";
  public static final String NEWS_URL = KEY_MAIN_URL + "display_news.php";
  public static final String NEWS_DETAILS_URL = KEY_MAIN_URL + "display_news_details.php";
  public static final String PLACE_LIST_DISPLAY = KEY_MAIN_URL + "place.php";
  public static final String EVENT_MASTER_URL=KEY_MAIN_URL+"event-list.php";
  public static final String PLACE_URL=KEY_MAIN_URL+"display_subplace.php";
  public static final String KEY_CHANGE_PASS_URL=KEY_MAIN_URL+"user_changepassword.php";
  public static final String KEY_FEEDBACK_URL=KEY_MAIN_URL+"user_feedback.php";
}

