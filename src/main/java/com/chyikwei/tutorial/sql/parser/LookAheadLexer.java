package com.chyikwei.tutorial.sql.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chyikwei on 5/20/16.
 *
 */
public abstract class LookAheadLexer {
    //LL(k) Lexer
    static Logger logger = LoggerFactory.getLogger(LookAheadLexer.class);

    public static final char EOF = (char)-1;

    protected final int k;
    protected final String input;
    protected final int inputSize;

    protected int pos;
    protected char[] lookahead;

    public LookAheadLexer(int k, String input) {
        this.k = k;
        this.lookahead = new char[k];
        this.input = input;
        this.inputSize = input.length();

        this.pos = 0;
        for (int i=0; i < k; i++){
            consume();
        }
    }

    public abstract Token nextToken();

    public void consume() {
        if (pos >= inputSize) {
            lookahead[pos % k] = EOF;
            logger.debug("set lookahead " + pos % k + " to EOF");
        } else {
            lookahead[pos % k] = input.charAt(pos);
            logger.debug("set lookahead " + pos % k + " to " + input.charAt(pos));
        }
        pos += 1;
    }

    public char ahead(int i) {

        if (i >= k || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int idx = (pos + i) % k;

        return lookahead[idx];
    }
}
