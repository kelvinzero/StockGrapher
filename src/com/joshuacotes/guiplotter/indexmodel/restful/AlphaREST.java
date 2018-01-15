package com.joshuacotes.guiplotter.indexmodel.restful;

import indexmodel.symbols.*;

import java.io.IOException;
import java.text.ParseException;

public class AlphaREST {


    public static IntraDailySymbol queryIntraday(String symbol, int interval, boolean all, boolean json)
    throws IOException, ParseException {

        IntraDailySymbol newSymbol = new IntraDailySymbol(symbol, interval, all, json);
        newSymbol.queryPricesREST();
        return newSymbol;
    }


}
