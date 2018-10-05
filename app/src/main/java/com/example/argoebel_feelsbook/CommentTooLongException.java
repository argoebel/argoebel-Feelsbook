package com.example.argoebel_feelsbook;

public class CommentTooLongException extends Exception {

    CommentTooLongException() {
        super("Your message is too long! Max comment length is 100 characters.");

    }
}
