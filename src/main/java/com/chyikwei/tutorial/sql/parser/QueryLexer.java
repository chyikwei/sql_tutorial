package com.chyikwei.tutorial.sql.parser;

/**
 * Created by chyikwei on 5/19/16.
 *
 * This is a LL(2) parser
 */
public class QueryLexer extends Lexer{

    private int pos;
    private int inputSize;
    private char head;
    private char head2;

    public QueryLexer(String input) {
        super(input);
        inputSize = input.length();
        pos = 0;
        lookahead();

    }

    private void lookahead() {
        if (pos >= inputSize) {
            head = EOF;
        } else {
            head = this.input.charAt(pos);
        }
        if (pos + 1 >= inputSize) {
            head2 = EOF;
        } else {
            head2 = this.input.charAt(pos+1);
        }
    }

    private void consume(){
        pos = pos + 1;
        lookahead();
    }

    public Token nextToken(){
        while (head != EOF) {
            switch (head) {
                case '=':
                    consume();
                    return new Token(Token.Type.EQUAL);
                case '>':
                    consume();
                    return new Token(Token.Type.GREATER);
                case '<':
                    consume();
                    return new Token(Token.Type.LESS);
                case ';':
                    consume();
                    return new Token(Token.Type.COMMA);
                case '(':
                    consume();
                    return new Token(Token.Type.LBRACK);
                case ')':
                    consume();
                    return new Token(Token.Type.RBRACK);
            }
        }
        return new Token(Token.Type.EOF);
    }
}
