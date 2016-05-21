package com.chyikwei.tutorial.sql.parser;

import com.sun.corba.se.impl.oa.toa.TOA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chyikwei on 5/20/16.
 */
public class SqlLexer extends LookAheadLexer {
    // LL(2)
    static Logger logger = LoggerFactory.getLogger(SqlLexer.class);

    public SqlLexer(String input) {
        super(2, input);
    }

    private boolean isStr(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isInt(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }

    private Token parse_int() {
        StringBuffer buff = new StringBuffer();
        char c = ahead(0);
        while (isInt(c)){
            logger.debug("look ahead = " + c);
            buff.append(c);
            consume();
            c = ahead(0);
            logger.debug("after consume, look ahead = " + c);

        }
        return new Token(Token.Type.INT, buff.toString());
    }

    private Token parse_name() {
        StringBuffer buff = new StringBuffer();
        char c = ahead(0);
        while (isStr(c) || isInt(c)){
            logger.debug("look ahead = " + c);
            buff.append(c);
            consume();
            c = ahead(0);
            logger.debug("after consume, look ahead = " + c);
        }
        return new Token(Token.Type.STR, buff.toString());
    }

    public Token nextToken() {
        while (ahead(0) != EOF) {
            char c = ahead(0);
            switch (c) {
                case ' ':
                    consume();
                    break;
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

                default:
                    if (isStr(c)) {
                        return parse_name();
                    } else if (isInt(c)) {
                        return parse_int();
                    } else {
                        throw new RuntimeException("unhandled char: " + c);
                    }
            }
        }
        return new Token(Token.Type.EOF);
    }

}
