package com.example.android.javatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

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
        CheckBox firstQuestion = (CheckBox) findViewById(R.id.q1a1);
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

        displayResult();
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
        String displaytotalScore = "Score: " + scoreTotal + " from 4";
        displaytotalScore += "\nQuestion 1: " + questionOneTotal;
        displaytotalScore += "\nQuestion 2: " + question2;
        displaytotalScore += "\nQuestion 3: " + question3;
        displaytotalScore += "\nQuestion 4: " + question4;
        if (scoreTotal == 4) {
            displaytotalScore += "\nAmazing result - all correct.";
        } else if (scoreTotal == 3) {
            displaytotalScore += "\nAlmost correct - one mistake.";
        } else if (scoreTotal == 2) {
            displaytotalScore += "\nNot bad - two mistakes.";
        } else if (scoreTotal == 1) {
            displaytotalScore += "\nYour results could be better :-( - three mistakes ";
        } else if (scoreTotal == 0) {
            displaytotalScore += "\nYou should learn more - four mistakes";
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
        TextView createTestSummaryTextView = (TextView) findViewById(R.id.finalMessage);
        createTestSummaryTextView.setText("");

    }
}
