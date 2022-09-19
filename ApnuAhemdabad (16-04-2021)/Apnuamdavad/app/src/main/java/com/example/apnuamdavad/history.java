package com.example.apnuamdavad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class history extends AppCompatActivity {

  Animation fade_in,fade_out;
  ViewFlipper viewFlipper;


  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    viewFlipper = (ViewFlipper) this.findViewById(R.id.bgflipper1);
    fade_in = AnimationUtils.loadAnimation(this,
      android.R.anim.fade_in);
    fade_out = AnimationUtils.loadAnimation(this,
      android.R.anim.fade_out);

    viewFlipper.setInAnimation(fade_in);
    viewFlipper.setOutAnimation(fade_out);

    viewFlipper.setAutoStart(true);
    viewFlipper.setFlipInterval(5000);
    viewFlipper.startFlipping();

  }
}
