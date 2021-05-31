package com.mad.coursework01;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CarHintsActivity extends AppCompatActivity {
    //Declaring the variables & array
    private final int[] carImgList = {R.drawable.alfa_romeo_01, R.drawable.alfa_romeo_02, R.drawable.alfa_romeo_03, R.drawable.alfa_romeo_04, R.drawable.alfa_romeo_05, R.drawable.audi_01, R.drawable.audi_02, R.drawable.audi_03, R.drawable.audi_04, R.drawable.audi_05, R.drawable.benz_01, R.drawable.benz_02, R.drawable.benz_03, R.drawable.benz_04, R.drawable.benz_05, R.drawable.bmw_01, R.drawable.bmw_02, R.drawable.bmw_03, R.drawable.bmw_04, R.drawable.bmw_05, R.drawable.jaguar_01, R.drawable.jaguar_02, R.drawable.jaguar_03, R.drawable.jaguar_04, R.drawable.jaguar_05, R.drawable.maserati_01, R.drawable.maserati_02, R.drawable.maserati_03, R.drawable.maserati_04, R.drawable.maserati_05};

    private static int randomCarImgPrevPosition = 30;
    private String findCarName = null;
    private final String[] alfaCharacterList = {"__ ", "__ ", "__ ", "__ ", " ", "__ ", "__ ", "__ ", "__ ", "__"};
    private final String[] audiCharacterList = {"__ ", "__ ", "__ ", "__"};
    private final String[] benzCharacterList = {"_ ", "_ ", "_ ", "_ ", "_ ", "_ ", "_ ", "_ ", " ", "_ ", "_ ", "_ ", "_"};
    private final String[] bmwCharacterList = {"__ ", "__ ", "__"};
    private final String[] jaguarCharacterList = {"__ ", "__ ", "__ ", "__ ", "__ ", "__"};
    private final String[] maseratiCharacterList = {"__ ", "__ ", "__ ", "__ ", "__ ", "__ ", "__ ", "__"};
    private int attempt;
    private boolean timerState;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_hints);

        timer();                        //Calling to timer method
        //Referencing to the image view
        ImageView imgView = findViewById(R.id.carHintsImgView);
        TextView blankView = findViewById(R.id.carHintsBlankDisplay);
        StringBuilder tempBlankDisplay = new StringBuilder();

        //Generating random numbers
        int randomCarImgPosition;

        while (true) {
            randomCarImgPosition = (int) (Math.random() * carImgList.length);
            if (randomCarImgPosition != randomCarImgPrevPosition) {
                randomCarImgPrevPosition = randomCarImgPosition;
                break;
            }
        }
        imgView.setImageResource(carImgList[randomCarImgPosition]);

        //Identify the correct car name
        if (randomCarImgPosition < 5) {
            findCarName = "ALFA ROMEO";
            for (String s : alfaCharacterList) {
                tempBlankDisplay.append(s);
            }
        } else if (randomCarImgPosition < 10) {
            findCarName = "AUDI";
            for (String s : audiCharacterList) {
                tempBlankDisplay.append(s);
            }
        } else if (randomCarImgPosition < 15) {
            findCarName = "MERCEDES BENZ";
            for (String s : benzCharacterList) {
                tempBlankDisplay.append(s);
            }
        } else if (randomCarImgPosition < 20) {
            findCarName = "BMW";
            for (String s : bmwCharacterList) {
                tempBlankDisplay.append(s);
            }
        } else if (randomCarImgPosition < 25) {
            findCarName = "JAGUAR";
            for (String s : jaguarCharacterList) {
                tempBlankDisplay.append(s);
            }
        } else if (randomCarImgPosition < 30) {
            findCarName = "MASERATI";
            for (String s : maseratiCharacterList) {
                tempBlankDisplay.append(s);
            }
        }

        blankView.setText(tempBlankDisplay.toString());

    }

    /*
     *Use to identify corresponding character
     */
    public void characterCheck(View view) {
        //Referencing to the edit text view
        EditText characterBox = findViewById(R.id.carHintsEditText);
        String editCharacterBox = characterBox.getText().toString();
        String capitalCharacter = editCharacterBox.toUpperCase();
        //Referencing to the submit button
        Button carHintsSubmitBtn = findViewById(R.id.carHintsSubmitBtn);
        TextView carHintsResultView = findViewById(R.id.carHintsResult);
        TextView carHintsCorrectAnsView = findViewById(R.id.carHintsCorrectAns);
        StringBuilder findLetter = new StringBuilder();
        boolean availability = false;


        if (!capitalCharacter.equals("")) {
            char tempCharacterBox = capitalCharacter.charAt(0);
            char[] inputCharacter = new char[findCarName.length()];
            TextView blankView = findViewById(R.id.carHintsBlankDisplay);
            String[] tempCarArray = new String[findCarName.length()];


            for (int x = 0; x < findCarName.length(); x++) {
                inputCharacter[x] = findCarName.charAt(x);
            }

            switch (findCarName) {
                case "ALFA ROMEO":
                    tempCarArray = alfaCharacterList;
                    break;
                case "AUDI":
                    tempCarArray = audiCharacterList;
                    break;
                case "MERCEDES BENZ":
                    tempCarArray = benzCharacterList;
                    break;
                case "BMW":
                    tempCarArray = bmwCharacterList;
                    break;
                case "JAGUAR":
                    tempCarArray = jaguarCharacterList;
                    break;
                case "MASERATI":
                    tempCarArray = maseratiCharacterList;
                    break;
            }


            for (int i = 0; i < inputCharacter.length; i++) {
                if (tempCharacterBox == inputCharacter[i]) {
                    tempCarArray[i] = editCharacterBox;
                    availability = true;
                }
            }

            for (String s : tempCarArray) {
                findLetter.append(s);
            }

            blankView.setText(findLetter.toString());
            characterBox.getText().clear();
        } else {
            //Check the timer availability
            if (timerState && !(attempt == 3)) {
                countDownTimer.cancel();
                countDownTimer.start();
            } else if (timerState) {
                countDownTimer.cancel();
            }
        }


        if (!availability) {
            attempt++;
            //Check the timer availability
            if (attempt == 3 && timerState) {
                countDownTimer.cancel();
            } else if (timerState) {
                countDownTimer.cancel();
                countDownTimer.start();
            }
        }

        if (findCarName.equals(findLetter.toString().toUpperCase())) {
            carHintsSubmitBtn.setText(R.string.car_make_next_btn);
            carHintsSubmitBtn.setOnClickListener(event -> newScreen());

            characterBox.setEnabled(false);
            carHintsResultView.setVisibility(View.VISIBLE);
            carHintsResultView.setTextColor(getResources().getColor(R.color.green_700));
            carHintsResultView.setText(R.string.car_make_result_one);
            //Check the timer availability
            if (timerState) {
                countDownTimer.cancel();
            }
        } else if (attempt == 3) {
            carHintsSubmitBtn.setText(R.string.car_make_next_btn);
            carHintsSubmitBtn.setOnClickListener(event -> newScreen());
            carHintsResultView.setVisibility(View.VISIBLE);
            carHintsResultView.setTextColor(getResources().getColor(R.color.red_700));
            carHintsResultView.setText(R.string.car_make_result_two);

            characterBox.setEnabled(false);
            String tempCarName = getString(R.string.advanced_level_correct_ans) + " " + findCarName;
            carHintsCorrectAnsView.setVisibility(View.VISIBLE);
            carHintsCorrectAnsView.setText(tempCarName);
        }

    }

    /*
     *Timer option for carHintsActivity
     */
    private void timer() {
        //Referencing to the text views
        TextView timerCountView = findViewById(R.id.carHintsTimer);
        Button carHintsSubmitBtn = findViewById(R.id.carHintsSubmitBtn);

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
                    carHintsSubmitBtn.performClick();
                }
            }.start();
        }
    }

    /*
     *Use to access to the CarHintsActivity new screen
     */
    private void newScreen() {
        Intent nextCarMake = new Intent(this, CarHintsActivity.class);
        nextCarMake.putExtra("timer_msg", timerState);
        startActivity(nextCarMake);
    }
}