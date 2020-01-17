package com.example.yixing.bottleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView bottle;
    Button spin;
    Random r;
    int angle;
    boolean restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "YixingQ.//7/22/17", Toast.LENGTH_SHORT).show();

        r = new Random();
        bottle = ((ImageView)findViewById(R.id.bottle));
        spin = ((Button)findViewById(R.id.spin));

        spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (restart) {
                    int temp = angle % 360;
                    RotateAnimation rotate = new RotateAnimation( temp, 360,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    bottle.startAnimation(rotate);
                    restart = false;
                    spin.setText("Spin");

                } else {
                    angle = r.nextInt() + 360;
                    RotateAnimation rotate = new RotateAnimation(0, angle,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(2000);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    bottle.startAnimation(rotate);
                    restart = true;
                    spin.setText("Reset");
                }

            }
        });
    }
}
