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

    private Token parseInt() {
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

    private Token createTokenFromString(String s) {
        String sUpper = s.toUpperCase();
        switch (sUpper) {
            case "SELECT":
                return new Token(Token.Type.SELECT);
            case "CREATE":
                return new Token(Token.Type.CREATE);
            case "INSERT":
                return new Token(Token.Type.INSERT);
            case "FROM":
                return new Token(Token.Type.FROM);
            case "WHERE":
                return new Token(Token.Type.WHERE);
            default:
                return new Token(Token.Type.VAR, s);
        }
    }

    private Token parseVar() {
        StringBuffer buff = new StringBuffer();
        char c = ahead(0);
        while (isStr(c) || isInt(c)){
            logger.debug("look ahead = " + c);
            buff.append(c);
            consume();
            c = ahead(0);
            logger.debug("after consume, look ahead = " + c);
        }
        return createTokenFromString(buff.toString());
    }

    private Token parseStr() {
        StringBuffer buff = new StringBuffer();
        consume();
        char c = ahead(0);
        while (c != '\''){
            logger.debug("look ahead = " + c);
            buff.append(c);
            consume();
            c = ahead(0);
            logger.debug("after consume, look ahead = " + c);
        }
        consume();
        return new Token(Token.Type.STR, buff.toString());
    }

    public boolean hasNext() {
        return ahead(0) == EOF;
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
                    if (ahead(1) == '=') {
                        consume();
                        consume();
                        return new Token(Token.Type.GREATER_EQUAL);
                    } else {
                        consume();
                        return new Token(Token.Type.GREATER);
                    }
                case '<':
                    if (ahead(1) == '=') {
                        consume();
                        consume();
                        return new Token(Token.Type.LESS_EQUAL);
                    } else {
                        consume();
                        return new Token(Token.Type.LESS);
                    }
                case '!':
                    if (ahead(1) == '=') {
                        consume();
                        consume();
                        return new Token(Token.Type.UNEQUAL);
                    } else {
                        consume();
                        return new Token(Token.Type.NOT);
                    }
                case ',':
                    consume();
                    return new Token(Token.Type.COMMA);
                case ';':
                    consume();
                    return new Token(Token.Type.SEMICOLON);
                case '(':
                    consume();
                    return new Token(Token.Type.LBRACK);
                case ')':
                    consume();
                    return new Token(Token.Type.RBRACK);
                case '\'':
                    return parseStr();

                default:
                    if (isStr(c)) {
                        return parseVar();
                    } else if (isInt(c)) {
                        return parseInt();
                    } else {
                        throw new RuntimeException("unhandled char: " + c);
                    }
            }
        }
        return new Token(Token.Type.EOF);
    }

}
