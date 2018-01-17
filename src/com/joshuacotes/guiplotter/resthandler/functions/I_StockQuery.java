package com.joshuacotes.guiplotter.resthandler.functions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public interface I_StockQuery {

    final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    final static DateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String[] getHeaders();
    public int getRecordsCount();
    public String getSymbol();
    public String[][] getPrices();
    public String getURL();
}
