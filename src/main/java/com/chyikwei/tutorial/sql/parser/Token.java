package com.chyikwei.tutorial.sql.parser;

import java.util.Optional;

/**
 * Created by chyikwei on 5/19/16.
 */

public class Token {

    // all terminal tokens
    public enum Type {
        SELECT, CREATE, INSERT,
        TABLE, FROM, WHERE,
        INT, STR,
        LBRACK, RBRACK, COMMA,
        EQUAL, NOT, GREATER, LESS,
        AND,
        EOF,
    }

    public final Type type;
    public final Optional<String> text;

    public Token(Type t, String text){
        this.type = t;
        this.text = Optional.of(text);
    }

    public Token(Type t) {
        this.type = t;
        this.text = Optional.empty();
    }

    public String toString() {
        if (this.text.isPresent()) {
            return String.format("<%s : %s>", this.type, this.text.get());
        }
        else {
            return String.format("<%s>", this.type);
        }
    }
}
