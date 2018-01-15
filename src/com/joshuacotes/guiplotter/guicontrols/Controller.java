package com.joshuacotes.guiplotter.guicontrols;

import com.joshuacotes.guiplotter.builders.Listbuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Calendar;

public class Controller {

    @FXML DatePicker startDate;
    @FXML DatePicker endDate;
    @FXML ChoiceBox startTime;
    @FXML ChoiceBox endTime;
    @FXML TextField symbolText;
    @FXML ChoiceBox function;
    @FXML ChoiceBox interval;
    @FXML ChoiceBox markets;
    @FXML ChoiceBox outputs;
    @FXML Label marketslabel;
    @FXML Button getquotes;

    @FXML
    public void initialize(){
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

        switch (dayOfWeek){
            case 1:
                endDate.setValue(LocalDate.now().minusDays(2));
                break;
            case 7:
                endDate.setValue(LocalDate.now().minusDays(1));
                break;
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
        }
    }

    private void fillOutputsList(){
        Listbuilder.buildOutputsList(outputs);
        outputs.getSelectionModel().selectFirst();
    }

}
