package com.chyikwei.tutorial.sql.parser;

import java.util.Optional;

/**
 * Created by chyikwei on 5/19/16.
 */

public class Token {

    // all terminal tokens
    public enum TokenType {
        SELECT, CREATE, INSERT,
        TABLE, FROM, WHERE,
        INT, STR,
        LBRACK, RBRACK, COMMA,
        ASSIGN, EQUAL, UNEQUAL,
        EOF,
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
