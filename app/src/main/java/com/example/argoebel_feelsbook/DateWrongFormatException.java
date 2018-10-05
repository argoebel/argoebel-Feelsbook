package com.example.argoebel_feelsbook;

public class DateWrongFormatException extends Exception {

    DateWrongFormatException() {
        super("The date is entered in the incorrect format.");
    }
}
