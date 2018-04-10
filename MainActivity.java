package com.erikgratz.diceroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.MobileAds;
import java.util.Random;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    public void roll(View view) {
        // gets inputs and converts to strings
        EditText faces = (EditText) findViewById(R.id.diceFaces);
        EditText count = (EditText) findViewById(R.id.diceCount);
        EditText butt = (EditText) findViewById(R.id.diceButt);
        // gets strings and converts to integers
        int f;
        int c;
        int b;
        try {
            f = Integer.parseInt(faces.getText().toString());
        } catch(Exception e){
            f = 0;
        }
        try {
            c = Integer.parseInt(count.getText().toString());
        } catch(Exception e){
            c = 0;
        }
        try {
            b = Integer.parseInt(butt.getText().toString());
        } catch(Exception e){
            b = 0;
        }
        //error reporting to user
        int sum = 0;
        if(f == 0){
            Toast.makeText(getApplicationContext(),"A Die with No Sides?",Toast.LENGTH_SHORT).show();
        }else if(c == 0) {
            Toast.makeText(getApplicationContext(),"Zero Dice?",Toast.LENGTH_SHORT).show();
        } else {


        // The Roll!
        Random rand = new Random();

        for (int i = c; i > 0; i--) {
            int randomint = rand.nextInt(f) + 1;
            sum = sum + randomint;
        }
        sum = sum + b;
        }

        // output section
        TextView output = (TextView) findViewById(R.id.output);
        String st=String.valueOf(sum);
        output.setText(st);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //admob initializer
        MobileAds.initialize(this, "ca-app-pub-8351443780868728~7839423542");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //blurbs!
        Random blurb = new Random();
        int randomBlurb = blurb.nextInt(10);

        TextView blurbView = (TextView) findViewById(R.id.XxX);

        if (randomBlurb == 0) {
            String xt = "Made with love, by Chklt Labs";
            blurbView.setText(xt);
        } else if (randomBlurb == 1) {
            String xt = "Made with the assistance of 2 squirrels and 14 lbs of coffee, by Chklt Labs";
            blurbView.setText(xt);
        } else if (randomBlurb == 2) {
            String xt = "Made under duress, by Chklt Labs";
            blurbView.setText(xt);
        } else if (randomBlurb == 3) {
            String xt = "Made for the enjoyment of Elon Musk, by Chklt Labs";
            blurbView.setText(xt);
        } else if (randomBlurb == 4) {
            String xt = "Made by cramming as many numbers as we could fit in your phone, by Chklt Labs";
            blurbView.setText(xt);
        } else if (randomBlurb == 5) {
            String xt = "Made because Max and Addie love getting cat toys, by Chklt Labs";
            blurbView.setText(xt);
        } else if (randomBlurb == 6) {
            String xt = "Made in Texas, by Chklt Labs";
            blurbView.setText(xt);
        } else if (randomBlurb == 7) {
            String xt = "Made to help finance a wedding ring, by Chklt Labs";
            blurbView.setText(xt);
        } else if (randomBlurb == 8) {
            String xt = "Made in collaboration with Knowledge Fight, by Chklt Labs";
            blurbView.setText(xt);
        } else if (randomBlurb == 9) {
            String xt = "Made by Chklt Labs. Tell your friends!";
            blurbView.setText(xt);
        }


    }
}
