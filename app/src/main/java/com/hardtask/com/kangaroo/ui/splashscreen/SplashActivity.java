package com.hardtask.com.kangaroo.ui.splashscreen;

import android.content.Intent;
import android.os.Handler;

import com.daimajia.androidanimations.library.Techniques;
import com.hardtask.com.kangaroo.R;
import com.hardtask.com.kangaroo.ui.mainscreen.MainActivity;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashActivity extends AwesomeSplash {

    private final int SPLASH_DISPLAY_LENGTH = 6000;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
//
//

//    }

    @Override
    public void initSplash(ConfigSplash configSplash) {
        //for background from bottom to upper
        configSplash.setBackgroundColor(R.color.splashActivity1); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(4000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //customize logo
        configSplash.setLogoSplash(R.drawable.logo); //or any other drawable
        configSplash.setAnimLogoSplashDuration(2000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.StandUp);

        //for title
        configSplash.setTitleSplash("Animal House");
        configSplash.setTitleTextColor(R.color.colorAccent);
        configSplash.setTitleTextSize(30f); //float value
        configSplash.setAnimTitleDuration(3000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
//        configSplash.setTitleFont(); //provide string to your font located in assets/fonts/
    }

    @Override
    public void animationsFinished() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }


}
