package com.chyikwei.tutorial.sql;

/**
 * Created by chyikwei on 5/18/16.
 */
public class Parser {

    private boolean isSuccess;

    public Parser() {
        isSuccess = false;
    }

    public boolean parse(String raw_query){
        isSuccess = true;
        System.out.println(raw_query);
        return isSuccess;
    }

    public static void main(String[] args) {
        String query = "select * from test;";
        Parser p = new Parser();
        p.parse(query);
    }
}
