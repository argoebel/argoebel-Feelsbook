package com.example.argoebel_feelsbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class popup extends Activity {

    protected String newMood;

    // create the popup window
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup_window);

        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        // adjust height and width of popup window
        getWindow().setLayout((int) (width*0.9), (int) (height*0.9));


    }

    // Initalize all buttons in the popup window
    @Override
    protected void onStart(){
        super.onStart();

        final EditText newComments = (EditText) findViewById(R.id.editText2);
        final EditText newDate = (EditText) findViewById(R.id.editText3);
        final Button loveButton = (Button) findViewById(R.id.popupbutton1);
        final Button angerButton = (Button) findViewById(R.id.popupbutton2);
        final Button joyButton = (Button) findViewById(R.id.popupbutton3);
        final Button sadnessButton = (Button) findViewById(R.id.popupbutton4);
        final Button surpriseButton = (Button) findViewById(R.id.popupbutton5);
        final Button fearButton = (Button) findViewById(R.id.popupbutton6);
        final Button updateTextButton = (Button) findViewById(R.id.button4);
        final Button deleteButton = (Button) findViewById(R.id.popupbuttonDelete);
        final Button updateDateButton = (Button) findViewById(R.id.button8);

        // if love button is clicked
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = newComments.getText().toString();
                newMood = "Love";

                String date = newDate.getText().toString();

                Intent i = new Intent();
                i.putExtra("mood", newMood);
                i.putExtra("comments",comments);
                i.putExtra("date", date);
                setResult(RESULT_OK, i);
                finish();
            }
        });

        // if anger button is clicked
        angerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String comments = newComments.getText().toString();
                newMood = "Anger";

                String date = newDate.getText().toString();

                Intent i = new Intent();
                i.putExtra("mood", newMood);
                i.putExtra("comments",comments);
                i.putExtra("date", date);
                setResult(RESULT_OK, i);
                finish();
            }
        });

        // if joy button is clicked
        joyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = newComments.getText().toString();
                newMood = "Joy";

                String date = newDate.getText().toString();

                Intent i = new Intent();
                i.putExtra("mood", newMood);
                i.putExtra("comments",comments);
                i.putExtra("date", date);
                setResult(RESULT_OK, i);
                finish();
            }
        });

        // if sadness button is clicked
        sadnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = newComments.getText().toString();

                newMood = "Sadness";

                String date = newDate.getText().toString();

                Intent i = new Intent();
                i.putExtra("mood", newMood);
                i.putExtra("comments",comments);
                i.putExtra("date", date);
                setResult(RESULT_OK, i);
                finish();
            }
        });

        // if surprise button is clicked
        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = newComments.getText().toString();

                newMood = "Surprise";

                String date = newDate.getText().toString();

                Intent i = new Intent();
                i.putExtra("mood", newMood);
                i.putExtra("comments",comments);
                i.putExtra("date", date);
                setResult(RESULT_OK, i);
                finish();
            }
        });

        // if fear button is clicked
        fearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = newComments.getText().toString();

                newMood = "Fear";

                String date = newDate.getText().toString();

                Intent i = new Intent();
                i.putExtra("mood", newMood);
                i.putExtra("comments",comments);
                i.putExtra("date", date);
                setResult(RESULT_OK, i);
                finish();
            }
        });

        // if the update text button is clicked
        updateTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = newComments.getText().toString();
                Intent i = new Intent();
                i.putExtra("comments",comments);
                setResult(RESULT_OK, i);
                finish();
            }
        });

        // if delete button is clicked
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("delete", true);
                setResult(RESULT_OK,i);
                finish();

            }
        });

        // if date button is clicked
        updateDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = newDate.getText().toString();
                Intent i = new Intent();
                i.putExtra("date", date);
                setResult(RESULT_OK,i);
                finish();

            }
        });

    }
}
