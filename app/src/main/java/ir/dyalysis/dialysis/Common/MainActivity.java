package ir.dyalysis.dialysis.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import ir.dyalysis.dialysis.Activity.HomeActivity;
import ir.dyalysis.dialysis.R;

public class MainActivity extends AppCompatActivity
{
    //variables
    private static int TIME_SPLASH = 2000;
    ScaleAnimation scaleAnimation;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Hooks
        imageView = findViewById(R.id.splashLogo);

        //Set animation
        scaleAnimation = new ScaleAnimation(0, 1f, 1f, 1f,
                Animation.RELATIVE_TO_SELF, (float) 0.5, Animation.RELATIVE_TO_SELF, (float) 0.5);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);
        imageView.setAnimation(scaleAnimation);

        //Set Timer to go to next activity
        new Handler().postDelayed(() ->
        {
            Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(homeIntent);
            finish();
        }, TIME_SPLASH);
    }
}
