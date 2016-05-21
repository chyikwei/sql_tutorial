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
    public void testEofTokenFormat() {
        Token t = new Token(Token.Type.EOF);
        assertEquals(t.type, Token.Type.EOF);
        assertFalse(t.text.isPresent());
        assertEquals(t.toString(), "<EOF>");
    }

    @Test
    public void testEquals() {
        Token t1 = new Token(Token.Type.AND);
        Token t2 = new Token(Token.Type.AND);
        Token t3 = new Token(Token.Type.STR, "var");
        Token t4  = new Token(Token.Type.STR, "var");
        Token t5  = new Token(Token.Type.STR, "var2");
        assertEquals(t1, t2);
        assertEquals(t3, t4);
        assertNotEquals(t1, t3);
        assertNotEquals(t4, t5);
    }
}
