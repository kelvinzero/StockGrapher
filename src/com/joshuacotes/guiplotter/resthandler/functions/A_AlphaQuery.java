package com.joshuacotes.guiplotter.resthandler.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.*;

public abstract class A_AlphaQuery implements I_StockQuery {

    protected String[] _headers; // [column id's]
    protected String[][] _priceList; // [date time][price]
    private String _symbol;
    private String _urlString;
    private int _recordsCount;

    protected A_AlphaQuery(String symbol){
        _symbol = symbol;
        _recordsCount = 0;
    }

    public String getURL(){
        return _urlString;
    }

    protected void setURLString(String url){
        _urlString = url;
    }

    @Override
    public String[] getHeaders(){
        return _headers;
    }

    @Override
    public String getSymbol() {
        return _symbol;
    }

    public int getRecordsCount(){
        return _recordsCount;
    }

    public String[][] getPrices() {
        return _priceList;
    }

    abstract void queryPricesREST() throws IOException, ParseException;

    protected String[][] getResultsREST()
            throws IOException {

        URL url = new URL(_urlString);
        BufferedReader urlReader;
        URLConnection urlConnection;
        List<String[]> resultList;
        String lineBuffer;

        urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setAllowUserInteraction(false);
        urlReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        resultList = new ArrayList<>();

        while ((lineBuffer = urlReader.readLine()) != null){
            resultList.add(lineBuffer.split(", *"));
        }

        _priceList = new String[resultList.size()-1][resultList.get(0).length];
        _headers = new String[resultList.get(0).length];
        System.arraycopy(resultList.get(0), 0, _headers, 0, _headers.length);

        for(int line = 1; line < resultList.size(); line++)
            System.arraycopy(resultList.get(line), 0, _priceList[line-1], 0, _priceList[line-1].length);

        urlReader.close();
        _recordsCount = _priceList.length;
        return _priceList;
    }

}


