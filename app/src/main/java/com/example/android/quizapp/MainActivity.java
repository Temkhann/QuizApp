package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int nbOfQuestion = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        printQuestionString(); //This probably not the best way but this string is really ugly.
    }

    /**
    * This method prints the code for the question 10
    */
    private void printQuestionString(){
        String test = "<Linearlayout\n      " +
                "xmlns:android=\"http://...\"\n      " +
                "xmlns:tools=\"http://...\"\n      " +
                "android:layout_width=\"match_parent\"\n      " +
                "android:layout_height=\"match_parent\"\n      " +
                "android:orientation=vertical />\n</LinearLayout>";
        TextView question = findViewById(R.id.Question10_text);
        question.setText(test);
    }

    /**
     * This method call the color change
     * @param array A boolean array which says if the answers of each questions was right or wrong
     */
    private void colorTrueOrFalse(boolean[] array){

        LinearLayout l1 = findViewById(R.id.Question1);
        LinearLayout l2 = findViewById(R.id.Question2);
        LinearLayout l3 = findViewById(R.id.Question3);
        LinearLayout l4 = findViewById(R.id.Question4);
        LinearLayout l5 = findViewById(R.id.Question5);
        LinearLayout l6 = findViewById(R.id.Question6);
        LinearLayout l7 = findViewById(R.id.Question7);
        LinearLayout l8 = findViewById(R.id.Question8);
        LinearLayout l9 = findViewById(R.id.Question9);
        LinearLayout l10 = findViewById(R.id.Question10);

        changeColorLinearLayout(array[0], l1);
        changeColorLinearLayout(array[1], l2);
        changeColorLinearLayout(array[2], l3);
        changeColorLinearLayout(array[3], l4);
        changeColorLinearLayout(array[4], l5);
        changeColorLinearLayout(array[5], l6);
        changeColorLinearLayout(array[6], l7);
        changeColorLinearLayout(array[7], l8);
        changeColorLinearLayout(array[8], l9);
        changeColorLinearLayout(array[9], l10);
    }

    /**
     * This method change the color of the question depending it was answered right or wrong
     * @param b A boolean which says if the answer was right or wrong
     * @param l The LinearLayout which will have its color changed
     */
    private void changeColorLinearLayout (boolean b, LinearLayout l){
        if (b)
            l.setBackgroundColor(getResources().getColor(R.color.right_answer));
        else
            l.setBackgroundColor(getResources().getColor(R.color.wrong_answer));
    }

    /**
     * This method calculates and prints the results
     */
    public void submit(View view){

        boolean[] answer_tab = new boolean[nbOfQuestion];
        for(int i=0; i<nbOfQuestion; i++){
            answer_tab[i] = false;
        }

        //Check every answer
        RadioButton answer1 = findViewById(R.id.Answer1_1);
        answer_tab[0] = answer1.isChecked();

        CheckBox answer2_1 = findViewById(R.id.Answer2_1);
        CheckBox answer2_2 = findViewById(R.id.Answer2_2);
        CheckBox answer2_3 = findViewById(R.id.Answer2_3);
        CheckBox answer2_4 = findViewById(R.id.Answer2_4);
        answer_tab[1] = !(answer2_1.isChecked())
                     && answer2_2.isChecked()
                     && !(answer2_3.isChecked())
                     && answer2_4.isChecked();

        CheckBox answer3_1 = findViewById(R.id.Answer3_1);
        CheckBox answer3_2 = findViewById(R.id.Answer3_2);
        CheckBox answer3_3 = findViewById(R.id.Answer3_3);
        CheckBox answer3_4 = findViewById(R.id.Answer3_4);
        answer_tab[2] = !(answer3_1.isChecked())
                && !(answer3_2.isChecked())
                && answer3_3.isChecked()
                &&!(answer3_4.isChecked());

        CheckBox answer4_1 = findViewById(R.id.Answer4_1);
        CheckBox answer4_2 = findViewById(R.id.Answer4_2);
        CheckBox answer4_3 = findViewById(R.id.Answer4_3);
        CheckBox answer4_4 = findViewById(R.id.Answer4_4);
        answer_tab[3] = answer4_1.isChecked()
                && !(answer4_2.isChecked())
                && answer4_3.isChecked()
                && !(answer4_4.isChecked());

        CheckBox answer5_1 = findViewById(R.id.Answer5_1);
        CheckBox answer5_2 = findViewById(R.id.Answer5_2);
        CheckBox answer5_3 = findViewById(R.id.Answer5_3);
        CheckBox answer5_4 = findViewById(R.id.Answer5_4);
        answer_tab[4] = !(answer5_1.isChecked())
                && !(answer5_2.isChecked())
                && !(answer5_3.isChecked())
                && answer5_4.isChecked();

        RadioButton answer6 = findViewById(R.id.Answer6_2);
        answer_tab[5] = answer6.isChecked();

        RadioButton answer7 = findViewById(R.id.Answer7_1);
        answer_tab[6] = answer7.isChecked();

        CheckBox answer8_1 = findViewById(R.id.Answer8_1);
        CheckBox answer8_2 = findViewById(R.id.Answer8_2);
        CheckBox answer8_3 = findViewById(R.id.Answer8_3);
        CheckBox answer8_4 = findViewById(R.id.Answer8_4);
        answer_tab[7] = !(answer8_1.isChecked())
                && answer8_2.isChecked()
                && !(answer8_3.isChecked())
                && !(answer8_4.isChecked());

        RadioButton answer9 = findViewById(R.id.Answer9_2);
        answer_tab[8] = answer9.isChecked();

        RadioButton answer10 = findViewById(R.id.Answer10_3);
        answer_tab[9] = answer10.isChecked();

        //Change the color depending the answer was right or wrong
        colorTrueOrFalse(answer_tab);

        //Calculate the score
        int score = 0;
        for(int i=0; i<nbOfQuestion; i++){
            if (answer_tab[i])
                score++;
        }

        //Display the score
        TextView result = findViewById(R.id.result_text);
        String text = ("" + score + "/" + nbOfQuestion);
        result.setText(text);

    }
}
