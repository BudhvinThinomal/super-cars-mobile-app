package com.mad.coursework01;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class IdentifyCarMakeActivity extends AppCompatActivity {
    //Declaring the variables & array
    private final int[] carImgList = {R.drawable.alfa_romeo_01, R.drawable.alfa_romeo_02, R.drawable.alfa_romeo_03, R.drawable.alfa_romeo_04, R.drawable.alfa_romeo_05, R.drawable.audi_01, R.drawable.audi_02, R.drawable.audi_03, R.drawable.audi_04, R.drawable.audi_05, R.drawable.benz_01, R.drawable.benz_02, R.drawable.benz_03, R.drawable.benz_04, R.drawable.benz_05, R.drawable.bmw_01, R.drawable.bmw_02, R.drawable.bmw_03, R.drawable.bmw_04, R.drawable.bmw_05, R.drawable.jaguar_01, R.drawable.jaguar_02, R.drawable.jaguar_03, R.drawable.jaguar_04, R.drawable.jaguar_05, R.drawable.maserati_01, R.drawable.maserati_02, R.drawable.maserati_03, R.drawable.maserati_04, R.drawable.maserati_05};

    private int randomCarImgPosition;
    private static int randomCarImgPrevPosition = 30;
    private boolean timerState;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_car_make);

        timer();                            //Calling to timer method
        //Referencing to the image view
        ImageView imgView = findViewById(R.id.carMakeImgView);
        //Generating random numbers
        while (true) {
            randomCarImgPosition = (int) (Math.random() * carImgList.length);
            if (randomCarImgPosition != randomCarImgPrevPosition) {
                randomCarImgPrevPosition = randomCarImgPosition;
                break;
            }
        }
        imgView.setImageResource(carImgList[randomCarImgPosition]);
    }

    /*
     *Use to identify car name
     */
    public void identify(View view) {
        //Referencing to the spinner
        Spinner chosenName = findViewById(R.id.carMakeSpinner);
        String identifyChosenName = chosenName.getSelectedItem().toString().toUpperCase();
        //Referencing to the text view
        TextView resultView = findViewById(R.id.carMakeResult);
        chosenName.setEnabled(false);
        //Referencing to the identify button
        Button identifyBtn = findViewById(R.id.carMakeIdentifyBtn);
        //Check the timer availability
        if (timerState) {
            countDownTimer.cancel();
        }

        switch (identifyChosenName) {            //Switch case for options
            case "\t\t\t\t\t\t\tALFA ROMEO\t\t\t":
                if (randomCarImgPosition < 5) {
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.green_700));
                    resultView.setText(R.string.car_make_result_one);
                } else {
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.red_700));
                    resultView.setText(R.string.car_make_result_two);
                    correctCarName(randomCarImgPosition);
                }
                break;
            case "\t\t\t\t\t\t\t\t\t\t AUDI":
                if (randomCarImgPosition >= 5 && randomCarImgPosition < 10) {
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.green_700));
                    resultView.setText(R.string.car_make_result_one);
                } else {
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.red_700));
                    resultView.setText(R.string.car_make_result_two);
                    correctCarName(randomCarImgPosition);
                }
                break;
            case "\t\t\t\t\t MERCEDES BENZ":
                if (randomCarImgPosition >= 10 && randomCarImgPosition < 15) {
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.green_700));
                    resultView.setText(R.string.car_make_result_one);
                } else {
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.red_700));
                    resultView.setText(R.string.car_make_result_two);
                    correctCarName(randomCarImgPosition);
                }
                break;
            case "\t\t\t\t\t\t\t\t\t\t BMW":
                if (randomCarImgPosition >= 15 && randomCarImgPosition < 20) {
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.green_700));
                    resultView.setText(R.string.car_make_result_one);
                } else {
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.red_700));
                    resultView.setText(R.string.car_make_result_two);
                    correctCarName(randomCarImgPosition);
                }
                break;
            case "\t\t\t\t\t\t\t\t\t JAGUAR":
                if (randomCarImgPosition >= 20 && randomCarImgPosition < 25) {
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.green_700));
                    resultView.setText(R.string.car_make_result_one);
                } else {
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.red_700));
                    resultView.setText(R.string.car_make_result_two);
                    correctCarName(randomCarImgPosition);
                }
                break;
            case "\t\t\t\t\t\t\t\t\tMASERATI":
                if (randomCarImgPosition >= 25 && randomCarImgPosition < 30) {
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.green_700));
                    resultView.setText(R.string.car_make_result_one);
                } else {
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.red_700));
                    resultView.setText(R.string.car_make_result_two);
                    correctCarName(randomCarImgPosition);
                }
                break;
        }
        identifyBtn.setText(R.string.car_make_next_btn);
        identifyBtn.setOnClickListener(event -> newScreen());
    }

    /*
     *Use to display correct result
     */
    private void correctCarName(int randomCarImgPosition) {
        //Referencing to the text view
        TextView correctAnsView = findViewById(R.id.carMakeCorrectAns);
        correctAnsView.setVisibility(View.VISIBLE);
        if (randomCarImgPosition < 5) {
            correctAnsView.setText(R.string.car_make_alfa_romeo);
        } else if (randomCarImgPosition < 10) {
            correctAnsView.setText(R.string.car_make_audi);
        } else if (randomCarImgPosition < 15) {
            correctAnsView.setText(R.string.car_make_benz);
        } else if (randomCarImgPosition < 20) {
            correctAnsView.setText(R.string.car_make_bmw);
        } else if (randomCarImgPosition < 25) {
            correctAnsView.setText(R.string.car_make_jaguar);
        } else if (randomCarImgPosition < 30) {
            correctAnsView.setText(R.string.car_make_maserati);
        }
    }

    /*
     *Timer option for IdentifyCarMakeActivity
     */
    private void timer() {
        TextView timerCountView = findViewById(R.id.carMakeTimer);
        Button identifyBtn = findViewById(R.id.carMakeIdentifyBtn);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            timerState = extras.getBoolean("timer_msg");
        }

        //countDown
        if (timerState) {
            countDownTimer = new CountDownTimer(21000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    timerCountView.setText(String.valueOf(millisUntilFinished / 1000));
                }

                @Override
                public void onFinish() {
                    timerCountView.setText(R.string.time_finish);
                    identifyBtn.performClick();
                }
            }.start();
        }
    }

    /*
     *Use to access to the IdentifyCarMakeActivity new screen
     */
    private void newScreen() {
        Intent nextCarMake = new Intent(this, IdentifyCarMakeActivity.class);
        nextCarMake.putExtra("timer_msg", timerState);
        startActivity(nextCarMake);
    }


}