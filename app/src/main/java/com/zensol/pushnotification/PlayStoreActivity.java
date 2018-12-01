package com.zensol.pushnotification;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlayStoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_store);

        final  int DSIPLAY_LENGH = 1000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Zensol+Techs&hl=en_US"));
                try{
                    startActivity(intent);
                }
                catch(Exception e){
                    intent.setData(Uri.parse("https://play.google.com/store"));
                }


            }
        }, DSIPLAY_LENGH);

    }
}
