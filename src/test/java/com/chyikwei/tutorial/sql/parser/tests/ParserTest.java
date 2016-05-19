package com.chyikwei.tutorial.sql.parser.tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.chyikwei.tutorial.sql.parser.Parser;

/**
 * Created by chyikwei on 5/18/16.
 */
public class ParserTest {

    @Test
    public void parseResult() {
        Parser p = new Parser();
        assertTrue(p.parse("this is test #1"));
    }
}
