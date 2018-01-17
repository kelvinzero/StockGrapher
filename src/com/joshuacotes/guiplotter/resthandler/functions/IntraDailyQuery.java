package com.joshuacotes.guiplotter.resthandler.functions;
import com.joshuacotes.guiplotter.resthandler.AlphaURL;
import com.joshuacotes.guiplotter.resthandler.QueryType;

import java.io.IOException;
import java.text.ParseException;

public class IntraDailyQuery extends A_AlphaQuery {

    public IntraDailyQuery(String symbol, int interval, boolean all, boolean json){

        super(symbol);
        super.setURLString(AlphaURL.ALPHA_URL + "function=" + QueryType.TIME_SERIES_INTRADAY.toString() + "&symbol=" +
                symbol + "&interval=" + interval + "min" + (all ? "&outputsize=full" : "") +
                "&apikey=" + AlphaURL.API_KEY + (json ? "" : "&datatype=csv"));
    }

    @Override
    public void queryPricesREST() throws IOException, ParseException{
        super.getResultsREST();
    }
}
