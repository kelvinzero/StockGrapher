package com.joshuacotes.guiplotter.resthandler;

public class AlphaURL {

    public final static String API_KEY = "76A0CH4BZXQCG63P";
    public final static String ALPHA_URL = "https://www.alphavantage.co/query?";

    /**
     * Builds a URL for TIME_SERIES_INTRADAY to query the REST service.
     * @param symbol
     * @param interval
     * @param all
     * @param json
     * @return
     */
    public static String buildURL(String symbol, int interval, boolean all, boolean json){
        return (ALPHA_URL + "function=" + QueryType.TIME_SERIES_INTRADAY + "&symbol=" +
                symbol + "&interval=" + interval + "min" + (all ? "&outputsize=full" : "") +
                "&apikey=" + API_KEY + (json ? "" : "&datatype=csv"));
    }

}
