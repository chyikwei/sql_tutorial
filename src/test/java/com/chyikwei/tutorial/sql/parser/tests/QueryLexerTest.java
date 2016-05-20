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
    public void testSimpleSelet(){
        String q = "select col_1 from table_1;";
        Token[] tokens = {
                new Token(Token.TokenType.SELECT),
                new Token(Token.TokenType.STR, "col_1"),
                new Token(Token.TokenType.FROM),
                new Token(Token.TokenType.STR, "table_1"),
                new Token(Token.TokenType.COMMA),
        };

        QueryLexer lexer = new QueryLexer(q);
        for (Token target: tokens){
            Token current = lexer.nextToken();
            assertEquals(target.type, current.type);
        }

    }

}
