package com.chyikwei.tutorial.sql.parser;

/**
 * Created by chyikwei on 5/19/16.
 */
public abstract class Lexer {

    public static final char EOF = (char)-1;

    protected String input;

    public Lexer(String input) {
        this.input = input;
    }

    public abstract Token nextToken();
}
