package com.example.android.javatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.javatest.R.id.q1a1;

public class MainActivity extends AppCompatActivity {

    int scoreTotal;
    boolean question4;
    boolean questionOneTotal;
    boolean question2;
    boolean question3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Calculate total score for all questions
    public void calculateScore(View view) {
        //Calculates first question
        CheckBox firstQuestion = (CheckBox) findViewById(q1a1);
        boolean questionOne = firstQuestion.isChecked();
        CheckBox firstQuestion2 = (CheckBox) findViewById(R.id.q1a2);
        boolean questionOne2 = firstQuestion2.isChecked();
        CheckBox firstQuestion3 = (CheckBox) findViewById(R.id.q1a3);
        boolean questionOne3 = firstQuestion3.isChecked();
        if (questionOne && questionOne2 && !questionOne3) {
            scoreTotal = scoreTotal + 1;
            questionOneTotal = true;
        }

        //Calculate second question
        RadioButton secondQuestion = (RadioButton) findViewById(R.id.q2a3);
        boolean questionTwo = secondQuestion.isChecked();
        if (questionTwo) {
            scoreTotal = scoreTotal + 1;
            question2 = true;
        }
        //Calculate third question
        RadioButton thirdQuestion = (RadioButton) findViewById(R.id.q3a1);
        boolean questionThree = thirdQuestion.isChecked();
        if (questionThree) {
            scoreTotal = scoreTotal + 1;
            question3 = true;
        }
        //Calculate fourth question
        EditText fourthQuestion = (EditText) findViewById(R.id.q4);
        String questionFour = fourthQuestion.getText().toString();
        if (questionFour.equals("20")) {
            scoreTotal = scoreTotal + 1;
            question4 = true;
        }
        //Make toast
        Toast.makeText(this, createTestSummary(scoreTotal, questionOneTotal, question2, question3, question4), Toast.LENGTH_SHORT).show();

        //call the displayResult method

        displayResult();

        //reset variables before next submit click
        scoreTotal = 0;
        questionOneTotal = false;
        question2 = false;
        question3 = false;
        question4 = false;
    }

    //Display test result
    public void displayResult() {
        TextView createTestSummaryTextView = (TextView) findViewById(R.id.finalMessage);
        createTestSummaryTextView.setText(createTestSummary(scoreTotal, questionOneTotal, question2, question3, question4));
    }

    //Create result message
    public String createTestSummary(int scoreTotal, boolean questionOneTotal, boolean question2, boolean question3, boolean question4) {
        String javaquestion1 = getResources().getString(R.string.javaQuestion1);
        String javaquestion2 = getResources().getString(R.string.javaQuestion2);
        String javaquestion3 = getResources().getString(R.string.javaQuestion3);
        String javaquestion4 = getResources().getString(R.string.javaQuestion4);
        String javaScore = getResources().getString(R.string.javaScore);
        String javaFrom = getResources().getString(R.string.javaFrom);
        String javaResult1 = getResources().getString(R.string.javaResult1);
        String javaResult2 = getResources().getString(R.string.javaResult2);
        String javaResult3 = getResources().getString(R.string.javaResult3);
        String javaResult4 = getResources().getString(R.string.javaResult4);
        String javaResult5 = getResources().getString(R.string.javaResult5);
        String displaytotalScore = javaScore + scoreTotal + javaFrom;
        displaytotalScore += javaquestion1 + questionOneTotal;
        displaytotalScore += javaquestion2 + question2;
        displaytotalScore += javaquestion3 + question3;
        displaytotalScore += javaquestion4 + question4;
        if (scoreTotal == 4) {
            displaytotalScore += javaResult1;
        } else if (scoreTotal == 3) {
            displaytotalScore += javaResult2;
        } else if (scoreTotal == 2) {
            displaytotalScore += javaResult3;
        } else if (scoreTotal == 1) {
            displaytotalScore += javaResult4;
        } else if (scoreTotal == 0) {
            displaytotalScore += javaResult5;
        }
        return displaytotalScore;
    }

    //Reset for score and result message
    public void Reset(View view) {
        scoreTotal = 0;
        questionOneTotal = false;
        question2 = false;
        question3 = false;
        question4 = false;

        CheckBox firstQuestion = (CheckBox) findViewById(q1a1);
        if (firstQuestion.isChecked())
            firstQuestion.toggle();
        CheckBox firstQuestion2 = (CheckBox) findViewById(R.id.q1a2);
        if (firstQuestion2.isChecked())
            firstQuestion2.toggle();
        CheckBox firstQuestion3 = (CheckBox) findViewById(R.id.q1a3);
        if (firstQuestion3.isChecked())
            firstQuestion3.toggle();
        RadioButton secondQuestion1 = (RadioButton) findViewById(R.id.q2a1);
        if (secondQuestion1.isChecked())
            secondQuestion1.setChecked(false);
        RadioButton secondQuestion2 = (RadioButton) findViewById(R.id.q2a2);
        if (secondQuestion2.isChecked())
            secondQuestion2.setChecked(false);
        RadioButton secondQuestion3 = (RadioButton) findViewById(R.id.q2a3);
        if (secondQuestion3.isChecked())
            secondQuestion3.setChecked(false);
        RadioButton thirdQuestion1 = (RadioButton) findViewById(R.id.q3a1);
        if (thirdQuestion1.isChecked())
            thirdQuestion1.setChecked(false);
        RadioButton thirdQuestion2 = (RadioButton) findViewById(R.id.q3a2);
        if (thirdQuestion2.isChecked())
            thirdQuestion2.setChecked(false);
        EditText fourthQuestion = (EditText) findViewById(R.id.q4);
        fourthQuestion.setText("");
        TextView createTestSummaryTextView = (TextView) findViewById(R.id.finalMessage);
        createTestSummaryTextView.setText("");

    }
}
