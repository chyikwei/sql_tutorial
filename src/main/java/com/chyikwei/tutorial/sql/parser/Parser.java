package com.chyikwei.tutorial.sql.parser;

import org.slf4j.*;

/**
 * Created by chyikwei on 5/18/16.
 */
public class Parser {
    static Logger logger = LoggerFactory.getLogger(Parser.class);
    private boolean isSuccess;

    public Parser() {
        isSuccess = false;
    }

    public boolean parse(String raw_query){
        isSuccess = true;
        logger.info("start parsing...");
        logger.debug(raw_query);
        return isSuccess;
    }

    public static void main(String[] args) {
        String query = "select * from test;";
        Parser p = new Parser();
        p.parse(query);
    }
}
