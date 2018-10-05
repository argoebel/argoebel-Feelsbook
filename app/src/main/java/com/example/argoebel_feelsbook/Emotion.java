package com.example.argoebel_feelsbook;

/** Sources
 * https://www.journaldev.com/17899/java-simpledateformat-java-date-format
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html
 * https://www.mkyong.com/java/how-do-convert-array-to-list-in-java/
 * https://stackify.com/specify-handle-exceptions-java/
*/

import org.w3c.dom.Comment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Emotion implements Comparable<Emotion> {

    private Date date;
    private String mood;
    private String comments;
    private static final Integer MAX_CHARS = 100;


    // sets comment for emotion
    public void setComments(String comments) throws CommentTooLongException {
        // uses exception handler if length is more than 100 char
        if ((comments.length() <= this.MAX_CHARS)) {
            this.comments = comments;
        }
        else {
            throw new CommentTooLongException();
        }

        this.comments = comments; }
    public void setMood(String input_mood) {this.mood = input_mood; }

    public void setDate(Date date) {this.date = date; }

    // use date formatting for input
    public void updateDate(String sDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd/HH/mm");
        this.date = formatter.parse(sDate);
    }

    public String getComments() {return this.comments; }
    public String getMood() {return this.mood; }
    public Date getDate() {return this.date; }

    // format string to print
    public String toString() {
        return this.date.toString()+" | "+this.mood+" | "+ this.comments;


    }
    // Allow for Emotions to be sorted
    @Override
    public int compareTo(Emotion emotion) {
        return getDate().compareTo(emotion.getDate());
    }

    public static List<Integer> allCount(ArrayList<Emotion> emotions) {
        int loveCount = 0;
        int angerCount = 0;
        int joyCount = 0;
        int sadnessCount = 0;
        int surpriseCount = 0;
        int fearCount = 0;
        for (Emotion emotion : emotions) {
            if (emotion.getMood().equals("Love")) {
                loveCount++;
            }
            else if (emotion.getMood().equals("Anger")) {
                angerCount++;
            }
            else if (emotion.getMood().equals("Joy")) {
                joyCount++;
            }
            else if (emotion.getMood().equals("Sadness")) {
                sadnessCount++;
            }
            else if (emotion.getMood().equals("Surprise")) {
                surpriseCount++;
            }
            else if (emotion.getMood().equals("Fear")){
                fearCount++;
            }
        }
        return Arrays.asList(loveCount, angerCount, joyCount, sadnessCount, surpriseCount, fearCount);
    }



}
