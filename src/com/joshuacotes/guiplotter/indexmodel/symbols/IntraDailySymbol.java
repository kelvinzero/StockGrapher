package com.joshuacotes.guiplotter.indexmodel.symbols;

import indexmodel.restful.AlphaURL;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.util.*;

public class IntraDailySymbol extends Symbol{

    public IntraDailySymbol(String symbol, int interval, boolean all, boolean json){

        super(symbol);
        super.setURLString(ALPHA_URL + "function=" + AlphaURL.TIME_SERIES_INTRADAY + "&symbol=" +
                symbol + "&interval=" + interval + "min" + (all ? "&outputsize=full" : "") +
                "&apikey=" + API_KEY + (json ? "" : "&datatype=csv"));
    }

    @Override
    public void queryPricesREST() throws IOException, ParseException{
        getResultsREST();
    }


    protected void buildPriceArray(String[][] results)throws ParseException{
    }

}
