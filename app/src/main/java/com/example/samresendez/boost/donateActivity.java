package com.example.samresendez.boost;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class donateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button boostButton = (Button) findViewById(R.id.boostDatShit);
        final ImageView rocket = (ImageView) findViewById(R.id.rocketShip);
        rocket.setImageDrawable(getResources().getDrawable(R.mipmap.boostrocket,getTheme()));




        boostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ImageView iV = (ImageView) findViewById(R.id.rocketShip);

                TranslateAnimation animation = new TranslateAnimation(0,0,0,-1000);
                animation.setDuration(2000);
                animation.setFillAfter(true);
                iV.setAnimation(animation);

                //Start Runnable for animating
                final Handler handler = new Handler();

                final Runnable r = new Runnable() {
                    Random rando = new Random();
                    public void run() {
                        int z = (rando.nextInt(10)+1) % 3;
                        if(z==0) {
                            iV.setImageResource(0);
                            iV.setImageDrawable(getResources().getDrawable(R.mipmap.boostrocketone,getTheme()));

                        }
                        else if(z==1) {
                            iV.setImageResource(0);
                            iV.setImageDrawable(getResources().getDrawable(R.mipmap.boostrockettwo,getTheme()));
                        }
                        else if(z==2) {
                            iV.setImageResource(0);
                            iV.setImageDrawable(getResources().getDrawable(R.mipmap.boostrocketthree,getTheme()));
                        }
                        handler.postDelayed(this, 50);
                    }
                };



                handler.postDelayed(r, 50);

                //TODO: Make some donations team!

                Context context = getApplicationContext();
                EditText priceView = (EditText) findViewById(R.id.numberValueText);
                String price = priceView.getText().toString();
                if(price.equals("")) {
                    price = "0.0";
                }
                CharSequence text = "You boosted " + price + " dollars!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
