package com.joshuacotes.guiplotter.guicontrols;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class Listbuilder {

    private static final String[] FUNCTION = {
            "TIME_SERIES_INTRADAY", "TIME_SERIES_DAILY", "TIME_SERIES_DAILY_ADJUSTED",
            "TIME_SERIES_WEEKLY", "TIME_SERIES_WEEKLY_ADJUSTED", "TIME_SERIES_MONTHLY",
            "TIME_SERIES_MONTHLY_ADJUSTED", "DIGITAL_CURRENCY_INTRADAY"};

    private static final String[] CRYPTOMARKETS = {
            "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS",
            "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN",
            "BHD", "BIF", "BITGOLD", "BMD", "BND", "BOB", "BRL",
            "BSD", "BTN", "BWP", "BYR", "BZD", "CAD", "CDF", "CHF",
            "CLF", "CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK"};

    private static final String[] OUTPUTS = {"WINDOWS", "PNG", "GIF"};

    public static void buildOutputsList(ChoiceBox outputsBox){
        ObservableList<String> outputs = FXCollections.observableArrayList();
        outputs.addAll(OUTPUTS);
        outputsBox.setItems(outputs);
    }

    public static void buildTimesList(ChoiceBox timesBox){
        ObservableList<String> times = FXCollections.observableArrayList();
        for(int i = 9; i <= 15; i++){
            times.add(i + ":00");
            if(i < 15)
                times.add(i + ":30");
        }
        timesBox.setItems(times);
    }

    public static void buildCryptoMarketList(ChoiceBox marketBox){
        ObservableList<String> markets = FXCollections.observableArrayList();
        markets.addAll(CRYPTOMARKETS);
        marketBox.setItems(markets);
    }


    public static void buildFunctionList(ChoiceBox functionBox){
        ObservableList<String> functions = FXCollections.observableArrayList();
        functions.addAll(FUNCTION);
        functionBox.setItems(functions);
    }

    public static void buildIntervalList(ChoiceBox intervalBox){
        ObservableList<String> intervalList = FXCollections.observableArrayList();
        intervalList.add("1min");
        intervalList.add("5min");
        intervalList.add("15min");
        intervalList.add("30min");
        intervalList.add("60min");
        intervalBox.setItems(intervalList);
    }

}
