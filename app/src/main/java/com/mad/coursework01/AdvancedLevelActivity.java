package com.mad.coursework01;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdvancedLevelActivity extends AppCompatActivity {
    //Declaring the variables & array
    private final int[] carImgList = {R.drawable.alfa_romeo_01, R.drawable.alfa_romeo_02, R.drawable.alfa_romeo_03, R.drawable.alfa_romeo_04, R.drawable.alfa_romeo_05, R.drawable.audi_01, R.drawable.audi_02, R.drawable.audi_03, R.drawable.audi_04, R.drawable.audi_05, R.drawable.benz_01, R.drawable.benz_02, R.drawable.benz_03, R.drawable.benz_04, R.drawable.benz_05, R.drawable.bmw_01, R.drawable.bmw_02, R.drawable.bmw_03, R.drawable.bmw_04, R.drawable.bmw_05, R.drawable.jaguar_01, R.drawable.jaguar_02, R.drawable.jaguar_03, R.drawable.jaguar_04, R.drawable.jaguar_05, R.drawable.maserati_01, R.drawable.maserati_02, R.drawable.maserati_03, R.drawable.maserati_04, R.drawable.maserati_05};

    private int firstChoice;
    private int secondChoice;
    private int thirdChoice;
    private static int prevFirstChoice = 30;
    private static int prevSecondChoice = 30;
    private static int prevThirdChoice = 30;
    private int attempt;
    private boolean timerState;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);

        timer();                        //Calling to timer method
        //Referencing to the image views
        ImageView imgViewOne = findViewById(R.id.advancedLevelViewOne);
        ImageView imgViewTwo = findViewById(R.id.advancedLevelViewTwo);
        ImageView imgViewThree = findViewById(R.id.advancedLevelViewThree);

        //Generating random numbers
        int randomCarBrandOne = (int) (Math.random() * 6);
        int randomCarBrandTwo;
        do {
            randomCarBrandTwo = (int) (Math.random() * 6);
        } while (randomCarBrandOne == randomCarBrandTwo);
        int randomCarBrandThree;
        do {
            randomCarBrandThree = (int) (Math.random() * 6);
        } while (randomCarBrandOne == randomCarBrandThree || randomCarBrandTwo == randomCarBrandThree);


        do {
            switch (randomCarBrandOne) {            //Switch case for options
                case 0:
                    firstChoice = (int) (Math.random() * 5);
                    break;
                case 1:
                    firstChoice = (int) (Math.random() * (10 - 5) + 5);
                    break;
                case 2:
                    firstChoice = (int) (Math.random() * (15 - 10) + 10);
                    break;
                case 3:
                    firstChoice = (int) (Math.random() * (20 - 15) + 15);
                    break;
                case 4:
                    firstChoice = (int) (Math.random() * (25 - 20) + 20);
                    break;
                case 5:
                    firstChoice = (int) (Math.random() * (30 - 25) + 25);
                    break;
            }
        } while ((prevFirstChoice == firstChoice) || (prevSecondChoice == firstChoice) || (prevThirdChoice == firstChoice));

        do {
            switch (randomCarBrandTwo) {                //Switch case for options
                case 0:
                    secondChoice = (int) (Math.random() * 5);
                    break;
                case 1:
                    secondChoice = (int) (Math.random() * (10 - 5) + 5);
                    break;
                case 2:
                    secondChoice = (int) (Math.random() * (15 - 10) + 10);
                    break;
                case 3:
                    secondChoice = (int) (Math.random() * (20 - 15) + 15);
                    break;
                case 4:
                    secondChoice = (int) (Math.random() * (25 - 20) + 20);
                    break;
                case 5:
                    secondChoice = (int) (Math.random() * (30 - 25) + 25);
                    break;
            }
        } while ((prevFirstChoice == secondChoice) || (prevSecondChoice == secondChoice) || (prevThirdChoice == secondChoice));

        do {
            switch (randomCarBrandThree) {                  //Switch case for options
                case 0:
                    thirdChoice = (int) (Math.random() * 5);
                    break;
                case 1:
                    thirdChoice = (int) (Math.random() * (10 - 5) + 5);
                    break;
                case 2:
                    thirdChoice = (int) (Math.random() * (15 - 10) + 10);
                    break;
                case 3:
                    thirdChoice = (int) (Math.random() * (20 - 15) + 15);
                    break;
                case 4:
                    thirdChoice = (int) (Math.random() * (25 - 20) + 20);
                    break;
                case 5:
                    thirdChoice = (int) (Math.random() * (30 - 25) + 25);
                    break;
            }
        } while ((prevFirstChoice == thirdChoice) || (prevSecondChoice == thirdChoice) || (prevThirdChoice == thirdChoice));
        prevFirstChoice = firstChoice;
        prevSecondChoice = secondChoice;
        prevThirdChoice = thirdChoice;

        imgViewOne.setImageResource(carImgList[firstChoice]);
        imgViewTwo.setImageResource(carImgList[secondChoice]);
        imgViewThree.setImageResource(carImgList[thirdChoice]);
    }

    /*
     *Use to identify submit answers
     */
    public void submitAnswer(View view) {
        //Referencing to the edit text views
        EditText textBoxOne = findViewById(R.id.editTextCarNameOne);
        String editTextBoxOne = textBoxOne.getText().toString().toUpperCase();

        EditText textBoxTwo = findViewById(R.id.editTextCarNameTwo);
        String editTextBoxTwo = textBoxTwo.getText().toString().toUpperCase();

        EditText textBoxThree = findViewById(R.id.editTextCarNameThree);
        String editTextBoxThree = textBoxThree.getText().toString().toUpperCase();

        String findCarNameOne = null;
        String findCarNameTwo = null;
        String findCarNameThree = null;
        int score = 0;
        attempt++;
        //Referencing to the views & submit button
        Button submitBtn = findViewById(R.id.advancedLevelSubmitBtn);
        TextView resultView = findViewById(R.id.advancedLevelResult);
        TextView correctAnsViewOne = findViewById(R.id.correctAnsOne);
        TextView correctAnsViewTwo = findViewById(R.id.correctAnsTwo);
        TextView correctAnsViewThree = findViewById(R.id.correctAnsThree);
        TextView pointsView = findViewById(R.id.advancedLevelScore);

        //Identify the correct car name
        if (firstChoice < 5) {
            findCarNameOne = "ALFA ROMEO";
        } else if (firstChoice < 10) {
            findCarNameOne = "AUDI";
        } else if (firstChoice < 15) {
            findCarNameOne = "MERCEDES BENZ";
        } else if (firstChoice < 20) {
            findCarNameOne = "BMW";
        } else if (firstChoice < 25) {
            findCarNameOne = "JAGUAR";
        } else if (firstChoice < 30) {
            findCarNameOne = "MASERATI";
        }

        if (secondChoice < 5) {
            findCarNameTwo = "ALFA ROMEO";
        } else if (secondChoice < 10) {
            findCarNameTwo = "AUDI";
        } else if (secondChoice < 15) {
            findCarNameTwo = "MERCEDES BENZ";
        } else if (secondChoice < 20) {
            findCarNameTwo = "BMW";
        } else if (secondChoice < 25) {
            findCarNameTwo = "JAGUAR";
        } else if (secondChoice < 30) {
            findCarNameTwo = "MASERATI";
        }

        if (thirdChoice < 5) {
            findCarNameThree = "ALFA ROMEO";
        } else if (thirdChoice < 10) {
            findCarNameThree = "AUDI";
        } else if (thirdChoice < 15) {
            findCarNameThree = "MERCEDES BENZ";
        } else if (thirdChoice < 20) {
            findCarNameThree = "BMW";
        } else if (thirdChoice < 25) {
            findCarNameThree = "JAGUAR";
        } else if (thirdChoice < 30) {
            findCarNameThree = "MASERATI";
        }

        //Check the timer availability
        if (timerState && !(attempt == 3)) {
            countDownTimer.cancel();
            countDownTimer.start();
        }

        //Checking for correct car names
        if (findCarNameOne.equals(editTextBoxOne)) {
            textBoxOne.setEnabled(false);
            textBoxOne.setTextColor(getResources().getColor(R.color.black));
            textBoxOne.setTypeface(textBoxOne.getTypeface(), Typeface.BOLD);
            textBoxOne.setBackgroundColor(getResources().getColor(R.color.green_700));
            score++;
        } else {
            textBoxOne.setHintTextColor(getResources().getColor(R.color.red_700));
            textBoxOne.setTypeface(textBoxOne.getTypeface(), Typeface.BOLD);
            textBoxOne.setTextColor(getResources().getColor(R.color.red_700));
        }

        if (findCarNameTwo.equals(editTextBoxTwo)) {
            textBoxTwo.setEnabled(false);
            textBoxTwo.setTextColor(getResources().getColor(R.color.black));
            textBoxTwo.setTypeface(textBoxTwo.getTypeface(), Typeface.BOLD);
            textBoxTwo.setBackgroundColor(getResources().getColor(R.color.green_700));
            score++;
        } else {
            textBoxTwo.setHintTextColor(getResources().getColor(R.color.red_700));
            textBoxTwo.setTypeface(textBoxTwo.getTypeface(), Typeface.BOLD);
            textBoxTwo.setTextColor(getResources().getColor(R.color.red_700));
        }

        if (findCarNameThree.equals(editTextBoxThree)) {
            textBoxThree.setEnabled(false);
            textBoxThree.setTextColor(getResources().getColor(R.color.black));
            textBoxThree.setTypeface(textBoxThree.getTypeface(), Typeface.BOLD);
            textBoxThree.setBackgroundColor(getResources().getColor(R.color.green_700));
            score++;
        } else {
            textBoxThree.setHintTextColor(getResources().getColor(R.color.red_700));
            textBoxThree.setTypeface(textBoxThree.getTypeface(), Typeface.BOLD);
            textBoxThree.setTextColor(getResources().getColor(R.color.red_700));
        }

        if (score == 3) {
            submitBtn.setText(R.string.car_make_next_btn);
            submitBtn.setOnClickListener(event -> newScreen());
            resultView.setVisibility(View.VISIBLE);
            resultView.setTextColor(getResources().getColor(R.color.green_700));
            resultView.setText(R.string.car_make_result_one);

            //Check the timer availability
            if (timerState) {
                countDownTimer.cancel();
            }
        } else if (attempt == 3) {
            submitBtn.setText(R.string.car_make_next_btn);
            submitBtn.setOnClickListener(event -> newScreen());
            resultView.setVisibility(View.VISIBLE);
            resultView.setTextColor(getResources().getColor(R.color.red_700));
            resultView.setText(R.string.car_make_result_two);

            if (!findCarNameOne.equals(editTextBoxOne)) {
                textBoxOne.setEnabled(false);
                String tempCarNameOne = getString(R.string.advanced_level_correct_ans) + " " + findCarNameOne;
                correctAnsViewOne.setVisibility(View.VISIBLE);
                correctAnsViewOne.setText(tempCarNameOne);
            }
            if (!findCarNameTwo.equals(editTextBoxTwo)) {
                textBoxTwo.setEnabled(false);
                String tempCarNameTwo = getString(R.string.advanced_level_correct_ans) + " " + findCarNameTwo;
                correctAnsViewTwo.setVisibility(View.VISIBLE);
                correctAnsViewTwo.setText(tempCarNameTwo);
            }
            if (!findCarNameThree.equals(editTextBoxThree)) {
                textBoxThree.setEnabled(false);
                String tempCarNameThree = getString(R.string.advanced_level_correct_ans) + " " + findCarNameThree;
                correctAnsViewThree.setVisibility(View.VISIBLE);
                correctAnsViewThree.setText(tempCarNameThree);
            }

            //Check the timer availability
            if (timerState) {
                countDownTimer.cancel();
            }
        }

        String points = getString(R.string.advanced_level_dynamic_points) + " " + score;
        pointsView.setText(points);
    }

    /*
     *Timer option for IdentifyCarImageActivity
     */
    private void timer() {
        //Referencing to the text views
        TextView timerCountView = findViewById(R.id.advancedLevelTimer);
        Button submitBtn = findViewById(R.id.advancedLevelSubmitBtn);

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
                    submitBtn.performClick();
                }
            }.start();
        }
    }

    /*
     *Use to access to the AdvancedLevelActivity new screen
     */
    private void newScreen() {
        Intent nextCarMake = new Intent(this, AdvancedLevelActivity.class);
        nextCarMake.putExtra("timer_msg", timerState);
        startActivity(nextCarMake);
    }
}