package khanmr.healthindex;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withSplashTimeOut(2000)
                .withTargetActivity(MainScreen.class)
                .withBackgroundColor(Color.parseColor("#ff6f00"))
                .withAfterLogoText("healthIndex")
                .withLogo(R.mipmap.ico_round);

        config.getAfterLogoTextView().setTextColor(Color.WHITE);

        View easySplash = config.create();
        setContentView(easySplash);
    }
}
