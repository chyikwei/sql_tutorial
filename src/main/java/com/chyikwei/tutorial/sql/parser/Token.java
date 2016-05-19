package com.chyikwei.tutorial.sql.parser;

import java.util.Optional;

/**
 * Created by chyikwei on 5/19/16.
 */

public class Token {

    public enum TokenType {
        CREATE, INSERT ,TABLE,
        SELECT, UPDATE, FROM,
        WHERE, NOT, INT, INDEX,
        CHAR, FLOAT, TEXT, SUM,
        MIN, MAX, AVERAGE
    }

    public final TokenType type;
    public final Optional<String> text;

    public Token(TokenType t, String text){
        this.type = t;
        this.text = Optional.of(text);
    }

    public Token(TokenType t) {
        this.type = t;
        this.text = Optional.empty();
    }
}
