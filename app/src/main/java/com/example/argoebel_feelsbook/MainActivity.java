/** Name: Austin Goebel
 * CCID: argoebel
 * SID#: 1461166
 * My video: https://youtu.be/TbT4Jedbzco
 *
 *
 * Sources:
 * https://github.com/watts1/lonelyTwitter
 * https://www.youtube.com/watch?v=fn5OlqQuOCk
 * https://www.youtube.com/watch?v=uToOj67nl8Y
 * https://www.youtube.com/watch?v=kCJv5YWHRXQ
 * https://www.youtube.com/watch?v=eX-TdY6bLdg
 * https://www.homeandlearn.co.uk/java/java_method_calling.html
 * https://developer.android.com/guide/topics/ui/declaring-layout
 */

package com.example.argoebel_feelsbook;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String FILENAME = "file.sav";
    private EditText emotionComments;
    private ListView oldEmotionsList;
    private ArrayList<Emotion> emotions = new ArrayList<Emotion>();
    private ArrayAdapter<Emotion> adapter;
    public Emotion selectedEmotion;
    public Integer selectedPosition;
    public Emotion emotion = new Emotion();

    public List<Integer> counts = Arrays.asList(0,0,0,0,0,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emotionComments = (EditText) findViewById(R.id.editText);

        final Button loveButton = (Button) findViewById(R.id.button);
        final Button angerButton = (Button) findViewById(R.id.button2);
        final Button joyButton= (Button) findViewById(R.id.button3);
        final Button sadnessButton = (Button) findViewById(R.id.button5);
        final Button surpriseButton = (Button) findViewById(R.id.button6);
        final Button fearButton = (Button) findViewById(R.id.button7);
        oldEmotionsList = (ListView) findViewById(R.id.pastEmotionsList);


        // if any emotions in listview are clicked
        oldEmotionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                selectedEmotion = emotions.get(selectedPosition);

                // starts popup window
                startActivityForResult(new Intent(getApplicationContext(), popup.class),999);
            }
        });


        // if love button is clicked
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // collect potential comment, mood, and date and send to emotions array
                String comments = emotionComments.getText().toString();
                Emotion newEmotion = new Emotion();
                try {
                    newEmotion.setComments(comments);
                    newEmotion.setDate(new Date());
                    newEmotion.setMood("Love");
                    emotions.add(newEmotion);

                    //update the counts and view and save
                    updateCounts();
                    adapter.notifyDataSetChanged();
                    saveInFile();

                }
                catch(CommentTooLongException e) {

                }
            }
        });

        // if anger button is clicked
        angerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = emotionComments.getText().toString();
                Emotion newEmotion = new Emotion();
                try {
                    newEmotion.setComments(comments);
                    newEmotion.setDate(new Date());
                    newEmotion.setMood("Anger");
                    emotions.add(newEmotion);
                    updateCounts();
                    adapter.notifyDataSetChanged();
                    saveInFile();

                }
                catch(CommentTooLongException e) {

                }
            }
        });

        // if joy button is clicked
        joyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = emotionComments.getText().toString();
                Emotion newEmotion = new Emotion();
                try {
                    newEmotion.setComments(comments);
                    newEmotion.setDate(new Date());
                    newEmotion.setMood("Joy");
                    emotions.add(newEmotion);
                    updateCounts();
                    adapter.notifyDataSetChanged();
                    saveInFile();

                }
                catch(CommentTooLongException e) {

                }
            }
        });

        // if sadness button is clicked
        sadnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = emotionComments.getText().toString();
                Emotion newEmotion = new Emotion();
                try {
                    newEmotion.setComments(comments);
                    newEmotion.setDate(new Date());
                    newEmotion.setMood("Sadness");
                    emotions.add(newEmotion);
                    updateCounts();
                    adapter.notifyDataSetChanged();
                    saveInFile();

                }
                catch(CommentTooLongException e) {

                }
            }
        });

        // if surprise button is clicked
        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = emotionComments.getText().toString();
                Emotion newEmotion = new Emotion();
                try {
                    newEmotion.setComments(comments);
                    newEmotion.setDate(new Date());
                    newEmotion.setMood("Surprise");
                    emotions.add(newEmotion);
                    updateCounts();
                    adapter.notifyDataSetChanged();
                    saveInFile();

                }
                catch(CommentTooLongException e) {

                }
            }
        });
        // if fear button is clicked
        fearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comments = emotionComments.getText().toString();
                Emotion newEmotion = new Emotion();
                try {
                    newEmotion.setComments(comments);
                    newEmotion.setDate(new Date());
                    newEmotion.setMood("Fear");
                    emotions.add(newEmotion);
                    updateCounts();
                    adapter.notifyDataSetChanged();
                    saveInFile();

                }
                catch(CommentTooLongException e) {

                }
            }
        });


    }

    // dealing with return from popup window
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        // request code is static and set to 999 at beginning as there are only two activities
        if (requestCode == 999 && resultCode == RESULT_OK){
            // if delete key is pressed
            if (data.getBooleanExtra("delete",false)) {
                emotions.remove(selectedEmotion);
                String mood = selectedEmotion.getMood();


                updateCounts();
                adapter.notifyDataSetChanged();
                saveInFile();
            }
            else {
                // if a new comment exists and is at least one char
                if ((data.getStringExtra("comments") != null) && ((data.getStringExtra("comments").length()) > 0)) {
                    String newComments = data.getStringExtra("comments");
                    // make sure comment fits formatting requirements
                    try {
                        selectedEmotion.setComments(newComments);
                    } catch (CommentTooLongException e) {

                    }
                }
                // if a mood button is pressed
                if (data.getStringExtra("mood") != null) {
                    selectedEmotion.setMood(data.getStringExtra("mood"));
                }

                // if the date is updated
                if (data.getStringExtra("date") != null) {
                    try {
                        selectedEmotion.updateDate(data.getStringExtra("date"));
                    }
                    catch (ParseException e){

                    }

                }

                // sorts emotions, updates counts, updates the view, and saves to the file
                Collections.sort(emotions);
                updateCounts();
                adapter.notifyDataSetChanged();
                saveInFile();
            }


        }
    }

    // custom function made to deal with updating the counts of all the emotions
    public void updateCounts(){

        // initialize all the textview counters
        TextView loveCounter = (TextView) findViewById(R.id.loveCount);
        TextView angerCounter = (TextView) findViewById(R.id.angerCount);
        TextView joyCounter = (TextView) findViewById(R.id.joyCount);
        TextView sadnessCounter = (TextView) findViewById(R.id.sadnessCount);
        TextView surpriseCounter = (TextView) findViewById(R.id.surpriseCount);
        TextView fearCounter = (TextView) findViewById(R.id.fearCount);

        // counts = list of all counts fore each emotion (Love: , Anger: , ... )
        counts = Emotion.allCount(emotions);

        // Assigns count to each Textview
        String loveText = "Love: " + (counts.get(0).toString());
        loveCounter.setText(loveText);

        String angerText = "Anger: " + String.valueOf(counts.get(1).toString());
        angerCounter.setText(angerText);

        String joyText = "Joy: " + String.valueOf(counts.get(2).toString());
        joyCounter.setText(joyText);

        String sadnessText = "Sadness: " + String.valueOf(counts.get(3).toString());
        sadnessCounter.setText(sadnessText);

        String surpriseText = "Surprise: " + String.valueOf(counts.get(4).toString());
        surpriseCounter.setText(surpriseText);

        String fearText = "Fear: " + String.valueOf(counts.get(5).toString());
        fearCounter.setText(fearText);
    }

    // onStart, setup adapter and load data from file
    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
        updateCounts();
        adapter = new ArrayAdapter<Emotion>(this, R.layout.list_item,emotions);
        oldEmotionsList.setAdapter(adapter);



    }
    // load data from file
    // heavily influenced by https://github.com/watts1/lonelyTwitter
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            Gson gson = new Gson();
            Type listEmotionType = new TypeToken<ArrayList<Emotion>>(){}.getType();

            emotions = gson.fromJson(reader,listEmotionType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            emotions=new ArrayList<Emotion>();
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // save data fo file
    // heavily influenced by https://github.com/watts1/lonelyTwitter
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw);
            Gson gson = new Gson();
            gson.toJson(emotions, writer);
            writer.flush();
            fos.close();


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}
