package com.example.rick.animationapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout rlSlide = findViewById(R.id.rlSlide);
        final TextView txvTitle = findViewById(R.id.txvTitle);

        Animation myAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.spin_in);
        rlSlide.setAnimation(myAnimation);

        myAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Animation combo = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
                txvTitle.setAnimation(combo);
                txvTitle.setAlpha(1.0F);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
