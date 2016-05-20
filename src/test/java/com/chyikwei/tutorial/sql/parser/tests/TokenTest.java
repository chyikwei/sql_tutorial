package com.chyikwei.tutorial.sql.parser.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import com.chyikwei.tutorial.sql.parser.Token;

/**
 * Created by chyikwei on 5/18/16.
 */
public class TokenTest {

    @Test
    public void createTokenResult() {
        Token t = new Token(Token.TokenType.CREATE);
        assertEquals(t.type, Token.TokenType.CREATE);
    }
}
