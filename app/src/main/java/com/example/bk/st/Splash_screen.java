package com.example.bk.st;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Splash_screen extends AppCompatActivity {

    LinearLayout layUp,layDown;
    ImageView img1;
    Animation up,down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        layUp=(LinearLayout)findViewById(R.id.upLayout);
        layDown=(LinearLayout)findViewById(R.id.downLayout);
        img1 = (ImageView)findViewById(R.id.splash_logo);

        up= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.upaniamtion);
        down= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downanimation);
        layUp.setAnimation(up);
        layDown.setAnimation(down);

        up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                finishAffinity();
                startActivity(i);
                //startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}
