package com.joshuacotes.guiplotter.resthandler.plotmediator;

import com.joshuacotes.guiplotter.plotter.PlotterWIN;
import com.joshuacotes.guiplotter.resthandler.AlphaURL;
import com.joshuacotes.guiplotter.resthandler.functions.A_AlphaQuery;
import com.joshuacotes.guiplotter.resthandler.functions.I_StockQuery;
import com.joshuacotes.guiplotter.resthandler.functions.IntraDailyQuery;

import java.time.LocalDate;

public class PlotterMediator {

    private I_StockQuery _stockQuery;
    private String _url;
    private PlotterWIN _plotter;

    public void plotIntradayPrices(String symbol, int interval, LocalDate startDate, LocalDate endDate){
        {
            if(_stockQuery != null && _url != null){
                String newURL = AlphaURL.buildURL(symbol, interval, true, false);
                if(newURL.equals(_url))
                    _plotter.plot();
                else{
                    _stockQuery = new IntraDailyQuery(symbol, interval, true, false);
                    _url = _stockQuery.getURL();
                }
            }
            else {
                _stockQuery = new IntraDailyQuery(symbol, interval, true, false);
                _url = _stockQuery.getURL();
            }
        }
    }

    private String buildGnuScript(){
        return "";
    }
}
