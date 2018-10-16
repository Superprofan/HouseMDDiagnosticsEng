package com.superprofan.housemddiagnostics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvResult = findViewById(R.id.tvResult);
        final ImageView ivResult = findViewById(R.id.ivResult);

        final MKEditText mkEditText = findViewById(R.id.houseButton);
        mkEditText.showRightIcon();

        mkEditText.setIconClickListener(new MKEditText.IconClickListener() {
            @Override
            public void onClick() {
                String userInput = mkEditText.getText().toString();

                if (userInput.toLowerCase().equals("lupus") || userInput.toLowerCase().equals("волчанка")) {
                    tvResult.setText(R.string.lupus);
                    ivResult.setImageResource(R.drawable.houselupus);
                } else if(userInput.length() == 0){
                    tvResult.setText(R.string.shvabra);
                    ivResult.setImageResource(R.drawable.housemop);
                }else if(userInput.length()>50){
                    tvResult.setText(R.string.vorchanka);
                    ivResult.setImageResource(R.drawable.housevorchanka);
                }else if(userInput.length()>0 && userInput.length()<11){
                    tvResult.setText(R.string.molchanka);
                    ivResult.setImageResource(R.drawable.housemolchanka);
                }else{
                    tvResult.setText(R.string.shonibudelez);
                    ivResult.setImageResource(R.drawable.housedefault);
                }
            }
        });
    }
}
