package ViewModel;

import javafx.application.Platform;
import javafx.beans.property.*;
import model.HeaterModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeaterViewModel implements PropertyChangeListener
{
    private StringProperty insideTemp1;
    private StringProperty insideTemp2;
    private StringProperty outsideTemp;
    private StringProperty heaterState;
    private HeaterModel model;

    public HeaterViewModel(HeaterModel model)
    {
        this.model = model;
        model.addListener("insideTemp1" , this);
        model.addListener("insideTemp2" , this);
        model.addListener("outsideTemp" , this);
        model.addListener("heaterState" , this);
        this.insideTemp1 = new SimpleStringProperty("Inside temp 1: ");
        this.insideTemp2 = new SimpleStringProperty("Inside temp 2: ");
        this.outsideTemp = new SimpleStringProperty("Outside temp: ");
    }

    public StringProperty getInsideTemp1Property()
    {
        return this.insideTemp1;
    }

    public StringProperty getInsideTemp2Property()
    {
        return this.insideTemp2;
    }

    public StringProperty getOutsideTempProperty()
    {
        return this.outsideTemp;
    }

    public StringProperty getHeaterState()
    {
        return this.heaterState;
    }


    public void heaterUp()
    {
        //
    }

    public void heaterDown()
    {
        //
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        Platform.runLater(()->
                {
                    if(evt.getPropertyName().equals("insideTemp1"))
                    {
                        this.insideTemp1.setValue(evt.getNewValue().toString());
                    }
                    else if(evt.getPropertyName().equals("insideTemp2"))
                    {
                        this.insideTemp2.setValue(evt.getNewValue().toString());
                    }
                    else if(evt.getPropertyName().equals("outsideTemp"))
                    {
                        this.outsideTemp.setValue(evt.getNewValue().toString());
                    }
                    else if(evt.getPropertyName().equals("heaterState"))
                    {
                        this.heaterState.setValue(evt.getNewValue().toString());
                    }
                }
        );
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
