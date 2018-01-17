package com.joshuacotes.guiplotter.resthandler;

import com.joshuacotes.guiplotter.resthandler.functions.IntraDailyQuery;

import java.io.IOException;
import java.text.ParseException;

public class AlphaREST {


    public static IntraDailyQuery query(String symbol, int interval, boolean all, boolean json)
    throws IOException, ParseException {

        IntraDailyQuery newSymbol = new IntraDailyQuery(symbol, interval, all, json);
        newSymbol.queryPricesREST();
        return newSymbol;
    }
}
