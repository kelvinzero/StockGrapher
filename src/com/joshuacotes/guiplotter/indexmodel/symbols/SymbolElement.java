package com.joshuacotes.guiplotter.indexmodel.symbols;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public interface SymbolElement {

    final static String API_KEY = "76A0CH4BZXQCG63P";
    final static String ALPHA_URL = "https://www.alphavantage.co/query?";
    final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    final static DateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String[] getHeaders();
    public int getRecordsCount();
    public String getSymbol();
    public String[][] getPrices();
}
