package com.chyikwei.tutorial.sql.parser.tests;

/**
 * Created by chyikwei on 5/19/16.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import com.chyikwei.tutorial.sql.parser.QueryLexer;
import com.chyikwei.tutorial.sql.parser.Token;

public class QueryLexerTest {

    @Test
    public void testEOF(){
        String q = "";
        QueryLexer lexer = new QueryLexer(q);
        Token eof = new Token(Token.Type.EOF);
        assertEquals(eof.type, lexer.nextToken().type);
    }

    @Test
    public void testSepcialChar(){
        String q = "();";
        QueryLexer lexer = new QueryLexer(q);
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

        QueryLexer lexer = new QueryLexer(q);
        for (Token target: tokens){
            Token current = lexer.nextToken();
            assertEquals(target.type, current.type);
        }

    }
    **/

}
