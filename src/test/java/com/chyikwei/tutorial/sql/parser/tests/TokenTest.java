package com.chyikwei.tutorial.sql.parser.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import com.chyikwei.tutorial.sql.parser.Token;

/**
 * Created by chyikwei on 5/18/16.
 */
public class TokenTest {

    @Test
    public void testCreateTokenFormat() {
        Token t = new Token(Token.Type.CREATE);
        assertEquals(t.type, Token.Type.CREATE);
        assertFalse(t.text.isPresent());
        assertEquals(t.toString(), "<CREATE>");

    }

    @Test
    public void TestEofTokenFormat() {
        Token t = new Token(Token.Type.EOF);
        assertEquals(t.type, Token.Type.EOF);
        assertFalse(t.text.isPresent());
        assertEquals(t.toString(), "<EOF>");
    }
}
