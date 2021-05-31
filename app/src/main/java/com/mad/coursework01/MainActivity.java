package com.mad.coursework01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    //Declaring the variables
    private boolean timerState;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);   //Customize action bar
        getSupportActionBar().setCustomView(R.layout.activity_customize_action_bar);

        timer = findViewById(R.id.mainPageSwitch);                              //Timer
        timer.setOnCheckedChangeListener((buttonView, isChecked) -> timerState = isChecked);
    }

    /*
     *Use to access to the identifyCarMakeView activity
     */
    public void identifyCarMakeView(View view) {
        Intent carMakeIntent = new Intent(this, IdentifyCarMakeActivity.class);
        carMakeIntent.putExtra("timer_msg", timerState);
        startActivity(carMakeIntent);
    }

    /*
     *Use to access to the carHintView activity
     */
    public void carHintView(View view) {
        Intent carHintIntent = new Intent(this, CarHintsActivity.class);
        carHintIntent.putExtra("timer_msg", timerState);
        startActivity(carHintIntent);
    }

    /*
     *Use to access to the identifyCarImageView activity
     */
    public void identifyCarImageView(View view) {
        Intent carImageIntent = new Intent(this, IdentifyCarImageActivity.class);
        carImageIntent.putExtra("timer_msg", timerState);
        startActivity(carImageIntent);
    }

    /*
     *Use to access to the advancedLevelView activity
     */
    public void advancedLevelView(View view) {
        Intent advancedLevelIntent = new Intent(this, AdvancedLevelActivity.class);
        advancedLevelIntent.putExtra("timer_msg", timerState);
        startActivity(advancedLevelIntent);
    }
}