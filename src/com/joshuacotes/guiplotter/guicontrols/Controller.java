package com.joshuacotes.guiplotter.guicontrols;

import com.joshuacotes.guiplotter.plotter.PlotterWIN;
import com.joshuacotes.guiplotter.resthandler.QueryType;
import com.joshuacotes.guiplotter.resthandler.plotmediator.PlotterMediator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Calendar;

public class Controller {

    @FXML DatePicker    startDate;
    @FXML DatePicker    endDate;
    @FXML ChoiceBox     startTime;
    @FXML ChoiceBox     endTime;
    @FXML ChoiceBox     function;
    @FXML ChoiceBox     interval;
    @FXML ChoiceBox     markets;
    @FXML ChoiceBox     outputs;
    @FXML TextField     symbolText;
    @FXML Label         marketslabel;

    private PlotterMediator plotterMediator;

    @FXML
    public void initialize(){
        plotterMediator = new PlotterMediator();
        fillTimeLists();
        fillFunctionsList();
        fillIntervalList();
        fillCryptoMarketsList();
        fillOutputsList();
        setCallbacks();
        setStartDate(0);
        setEndDate();
        symbolText.textProperty().setValue("BTC");
    }

    public void onGetQuoteClick(){
        String function     = this.function.getSelectionModel().getSelectedItem().toString();
        String market       = this.markets.getSelectionModel().getSelectedItem().toString();
        String symbol       = this.symbolText.toString();
        String outputType   = this.outputs.getSelectionModel().getSelectedItem().toString();
        LocalDate fromDate  = this.startDate.getValue();
        LocalDate endDate   = this.endDate.getValue();
        int interval        = Integer.valueOf(this.interval.getSelectionModel().getSelectedItem().toString());

        plotterMediator.plotIntradayPrices(symbol, interval, fromDate, endDate);
    }

    private void setCallbacks(){
        function.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                onFunctionsListChanged(newValue.intValue());
            }
        });
    }

    private void fillCryptoMarketsList(){
        Listbuilder.buildCryptoMarketList(markets);
        markets.getSelectionModel().selectLast();
    }

    private void fillTimeLists(){

        Listbuilder.buildTimesList(startTime);
        Listbuilder.buildTimesList(endTime);
        startTime.getSelectionModel().selectFirst();
        endTime.getSelectionModel().selectLast();
    }

    private void fillFunctionsList(){
        Listbuilder.buildFunctionList(function);
        function.getSelectionModel().selectLast();
    }

    private void fillIntervalList(){
        Listbuilder.buildIntervalList(interval);
        interval.getSelectionModel().selectLast();
    }

    private void onFunctionsListChanged(int selectedIndex){

        //if crypto selected
        if(function.getItems().size()-1 == selectedIndex){
            markets.visibleProperty().setValue(true);
            marketslabel.visibleProperty().setValue(true);
            symbolText.setText("BTC");
        }
        else {
            markets.visibleProperty().setValue(false);
            marketslabel.visibleProperty().setValue(false);
        }

        switch (selectedIndex){
            case 0:
                setStartDate(0);
                symbolText.setText("NASDQ");
                break;
            case 1:
                setStartDate(6);
                symbolText.setText("NASDQ");
                break;
            case 2:
                setStartDate(6);
                symbolText.setText("NASDQ");
                break;
            case 3:
                setStartDate(31);
                symbolText.setText("NASDQ");
                break;
            case 4:
                setStartDate(31);
                symbolText.setText("NASDQ");
                break;
            case 5:
                setStartDate(364);
                symbolText.setText("NASDQ");
                break;
            case 6:
                setStartDate(364);
                symbolText.setText("NASDQ");
                break;
        }

    }

    private void setEndDate(){
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        switch (dayOfWeek) {
            case 1:
                endDate.setValue(LocalDate.now().minusDays(2));
                break;
            case 7:
                endDate.setValue(LocalDate.now().minusDays(1));
                break;
            default:
                endDate.setValue(LocalDate.now());
        }
    }

    private void setStartDate(int numDaysAgo){
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        switch (dayOfWeek){
            case 1:
                startDate.setValue(LocalDate.now().minusDays(2).minusDays(numDaysAgo));
                break;
            case 7:
                startDate.setValue(LocalDate.now().minusDays(1).minusDays(numDaysAgo));
                break;
            default:
                if(LocalDate.now().minusDays(numDaysAgo).getDayOfWeek().getValue() == 7)
                    startDate.setValue(LocalDate.now().minusDays(numDaysAgo).minusDays(2));
                else if(LocalDate.now().minusDays(numDaysAgo).getDayOfWeek().getValue() == 6)
                    startDate.setValue(LocalDate.now().minusDays(numDaysAgo).minusDays(1));
                else
                    startDate.setValue(LocalDate.now());

        }
    }

    private void fillOutputsList(){
        Listbuilder.buildOutputsList(outputs);
        outputs.getSelectionModel().selectFirst();
    }

}
