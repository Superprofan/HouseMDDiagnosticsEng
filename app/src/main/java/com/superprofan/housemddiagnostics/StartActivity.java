package com.superprofan.housemddiagnostics;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    Animation anim;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // parts of the title
        String firstWord, lastWord;
        firstWord = "House MD\n";
        lastWord = "Diagnostics";

        //colors for the first and the second words of the title
        int lastWordColor = ContextCompat.getColor(this,R.color.firstWordColor);
        int firstWordColor = ContextCompat.getColor(this,R.color.lastWordColor);

        //make them different colors
        TextView tvAppName = findViewById(R.id.tvAppName);

        Spannable span = new SpannableString(firstWord + lastWord);

        span.setSpan(new ForegroundColorSpan(firstWordColor), 0, firstWord.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new ForegroundColorSpan(lastWordColor), firstWord.length(),
                firstWord.length()+lastWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvAppName.setText(span);

        imageView=findViewById(R.id.imageView); // Declare an imageView to show the animation.

        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in); // Create the animation.
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        imageView.startAnimation(anim);
    }
}
