package com.mad.coursework01;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IdentifyCarImageActivity extends AppCompatActivity {
    //Declaring the variables & array
    private final int[] carImgList = {R.drawable.alfa_romeo_01, R.drawable.alfa_romeo_02, R.drawable.alfa_romeo_03, R.drawable.alfa_romeo_04, R.drawable.alfa_romeo_05, R.drawable.audi_01, R.drawable.audi_02, R.drawable.audi_03, R.drawable.audi_04, R.drawable.audi_05, R.drawable.benz_01, R.drawable.benz_02, R.drawable.benz_03, R.drawable.benz_04, R.drawable.benz_05, R.drawable.bmw_01, R.drawable.bmw_02, R.drawable.bmw_03, R.drawable.bmw_04, R.drawable.bmw_05, R.drawable.jaguar_01, R.drawable.jaguar_02, R.drawable.jaguar_03, R.drawable.jaguar_04, R.drawable.jaguar_05, R.drawable.maserati_01, R.drawable.maserati_02, R.drawable.maserati_03, R.drawable.maserati_04, R.drawable.maserati_05};

    private int firstChoice;
    private int secondChoice;
    private int thirdChoice;
    private static int prevFirstChoice = 30;
    private static int prevSecondChoice = 30;
    private static int prevThirdChoice = 30;
    private int findCarName;
    private boolean timerState;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_car_image);

        timer();                        //Calling to timer method
        //Referencing to the image views
        ImageView imgViewOne = findViewById(R.id.carImgViewOne);
        ImageView imgViewTwo = findViewById(R.id.carImgViewTwo);
        ImageView imgViewThree = findViewById(R.id.carImgViewThree);

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

        int[] selectedCarBrandList = new int[]{firstChoice, secondChoice, thirdChoice};
        int randomSelectedCarBrand = (int) (Math.random() * selectedCarBrandList.length);
        findCarName = selectedCarBrandList[randomSelectedCarBrand];     //Selected random chosen car image

        //Set images in image view
        imgViewOne.setImageResource(carImgList[firstChoice]);
        imgViewTwo.setImageResource(carImgList[secondChoice]);
        imgViewThree.setImageResource(carImgList[thirdChoice]);

        TextView carNameView = findViewById(R.id.idnCarImgName);

        //Identify the correct car name
        if (findCarName < 5) {
            carNameView.setText(R.string.car_img_alfa_romeo);
        } else if (findCarName < 10) {
            carNameView.setText(R.string.car_img_audi);
        } else if (findCarName < 15) {
            carNameView.setText(R.string.car_img_benz);
        } else if (findCarName < 20) {
            carNameView.setText(R.string.car_img_bmw);
        } else if (findCarName < 25) {
            carNameView.setText(R.string.car_img_jaguar);
        } else if (findCarName < 30) {
            carNameView.setText(R.string.car_img_maserati);
        }

        Button nextBtn = findViewById(R.id.carImgNextBtn);
        nextBtn.setOnClickListener(event -> toastNotify());
    }

    /*
     *Use to display toast message
     */
    private void toastNotify() {
        Toast notifyMsg = Toast.makeText(this, R.string.car_img_toast, Toast.LENGTH_SHORT);
        notifyMsg.show();
    }

    /*
     *Use to select the answer as image view one
     */
    public void identifyCarImageViewOne(View view) {
        //Check the timer availability
        if (timerState) {
            countDownTimer.cancel();
        }
        ImageView imgViewOne = findViewById(R.id.carImgViewOne);
        ImageView imgViewTwo = findViewById(R.id.carImgViewTwo);
        ImageView imgViewThree = findViewById(R.id.carImgViewThree);
        Animation clickableAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clickable);
        imgViewOne.startAnimation(clickableAnim);
        imgViewOne.setEnabled(false);
        imgViewTwo.setEnabled(false);
        imgViewThree.setEnabled(false);
        result(firstChoice);
        nextBtn();
    }

    /*
     *Use to select the answer as image view two
     */
    public void identifyCarImageViewTwo(View view) {
        //Check the timer availability
        if (timerState) {
            countDownTimer.cancel();
        }
        ImageView imgViewOne = findViewById(R.id.carImgViewOne);
        ImageView imgViewTwo = findViewById(R.id.carImgViewTwo);
        ImageView imgViewThree = findViewById(R.id.carImgViewThree);
        Animation clickableAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clickable);
        imgViewTwo.startAnimation(clickableAnim);
        imgViewOne.setEnabled(false);
        imgViewTwo.setEnabled(false);
        imgViewThree.setEnabled(false);
        result(secondChoice);
        nextBtn();
    }

    /*
     *Use to select the answer as image view three
     */
    public void identifyCarImageViewThree(View view) {
        //Check the timer availability
        if (timerState) {
            countDownTimer.cancel();
        }
        ImageView imgViewOne = findViewById(R.id.carImgViewOne);
        ImageView imgViewTwo = findViewById(R.id.carImgViewTwo);
        ImageView imgViewThree = findViewById(R.id.carImgViewThree);
        Animation clickableAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clickable);
        imgViewThree.startAnimation(clickableAnim);
        imgViewOne.setEnabled(false);
        imgViewTwo.setEnabled(false);
        imgViewThree.setEnabled(false);
        result(thirdChoice);
        nextBtn();
    }


    /*
     *Use to identify the correct answer
     */
    private void result(int choice) {
        //Referencing to the text view
        TextView resultView = findViewById(R.id.carImgResult);
        resultView.setVisibility(View.VISIBLE);

        if (choice == findCarName) {
            resultView.setText(R.string.car_make_result_one);
            resultView.setTextColor(getResources().getColor(R.color.green_700));
        } else {
            resultView.setTextColor(getResources().getColor(R.color.red_700));
            resultView.setText(R.string.car_make_result_two);
        }
    }

    /*
     *Timer option for IdentifyCarImageActivity
     */
    private void timer() {
        //Referencing to the text views
        TextView timerCountView = findViewById(R.id.carImgTimer);
        TextView resultView = findViewById(R.id.carImgResult);

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
                    resultView.setVisibility(View.VISIBLE);
                    resultView.setTextColor(getResources().getColor(R.color.red_700));
                    resultView.setText(R.string.car_make_result_two);
                    nextBtn();
                }
            }.start();
        }
    }

    /*
     *Use to access to the IdentifyCarImageActivity new screen
     */
    private void newScreen() {
        Intent nextCarMake = new Intent(this, IdentifyCarImageActivity.class);
        nextCarMake.putExtra("timer_msg", timerState);
        startActivity(nextCarMake);
    }

    /*
     *Use to change the screen
     */
    private void nextBtn() {
        Button nextBtn = findViewById(R.id.carImgNextBtn);
        nextBtn.setOnClickListener(event -> newScreen());
    }
}