package com.chyikwei.tutorial.sql.parser;

/**
 * Created by chyikwei on 5/19/16.
 *
 * This is a LL(2) parser
 */
public class QueryLexer extends Lexer{

    private int pos = 0;
    private int inputSize;
    private char ahead;
    private char ahead2;

    public QueryLexer(String input) {
        super(input);
        inputSize = input.length();
    }

    private void consume(){
        pos = pos + 1;
        if (pos >= inputSize) {
            ahead = EOF;
        } else {
            ahead = this.input.charAt(pos);
        }
        if (pos + 1 >= inputSize) {
            ahead2 = EOF;
        } else {
            ahead2 = this.input.charAt(pos+1);
        }
    }

    public Token nextToken(){
        return new Token(Token.TokenType.CREATE);
    }
}
