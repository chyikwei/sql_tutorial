package com.chyikwei.tutorial.sql.parser.tests;

/**
 * Created by chyikwei on 5/19/16.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import com.chyikwei.tutorial.sql.parser.SqlLexer;
import com.chyikwei.tutorial.sql.parser.Token;

public class SqlLexerTest {

    @Test
    public void testEOF(){
        String q = "";
        SqlLexer lexer = new SqlLexer(q);
        Token eof = new Token(Token.Type.EOF);
        assertEquals(eof.type, lexer.nextToken().type);
    }

    @Test
    public void testSepcialChar(){
        String q = "();";
        SqlLexer lexer = new SqlLexer(q);
        Token[] targets = {
                new Token(Token.Type.LBRACK),
                new Token(Token.Type.RBRACK),
                new Token(Token.Type.COMMA),
                new Token(Token.Type.EOF),
        };
        for (Token target : targets) {
            assertEquals(target.type, lexer.nextToken().type);
        }
    }

    @Test
    public void testStr(){
        String q = "this is var123";
        SqlLexer lexer = new SqlLexer(q);
        Token[] targets = {
                new Token(Token.Type.STR, "this"),
                new Token(Token.Type.STR, "is"),
                new Token(Token.Type.STR, "var123"),
                new Token(Token.Type.EOF),
        };
        for (Token target : targets) {
            assertEquals(target, lexer.nextToken());
        }
    }

    @Test
    public void testInt(){
        String q = "123 456 789";
        SqlLexer lexer = new SqlLexer(q);
        Token[] targets = {
                new Token(Token.Type.INT, "123"),
                new Token(Token.Type.INT, "456"),
                new Token(Token.Type.INT, "789"),
                new Token(Token.Type.EOF),
        };
        for (Token target : targets) {
            assertEquals(target, lexer.nextToken());
        }
    }

    /**
    @Test
    public void testSelect(){
        String q = "select col_1 from table_1;";
        Token[] tokens = {
                new Token(Token.Type.SELECT),
                new Token(Token.Type.STR, "col_1"),
                new Token(Token.Type.FROM),
                new Token(Token.Type.STR, "table_1"),
                new Token(Token.Type.COMMA),
        };

        SqlLexer lexer = new SqlLexer(q);
        for (Token target: tokens){
            Token current = lexer.nextToken();
            assertEquals(target.type, current.type);
        }

    }
    **/

}
