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
    private BooleanProperty bool;

    private final int MAX = 30;
    private final int MIN = 15;


    public HeaterViewModel(HeaterModel model)
    {
        this.model = model;
        model.addListener("insideTemp1" , this);
        model.addListener("insideTemp2" , this);
        model.addListener("outsideTemp" , this);
        model.addListener("heaterState" , this);
        bool = new SimpleBooleanProperty(false);
        this.insideTemp1 = new SimpleStringProperty("Inside temp 1: ");
        this.insideTemp2 = new SimpleStringProperty("Inside temp 2: ");
        this.outsideTemp = new SimpleStringProperty("Outside temp: ");
        this.heaterState = new SimpleStringProperty("0");
    }

    public StringProperty getInsideTemp1Property()
    {
        return this.insideTemp1;
    }

    public StringProperty getInsideTemp2Property()
    {
        return this.insideTemp2;
    }

    public BooleanProperty getBoolProperty()
    {
        return this.bool;
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
        System.out.println("+");
        model.getHeaterState().upButton(model);
    }

    public void heaterDown()
    {
        //
        System.out.println("-");
        model.getHeaterState().downButton(model);
    }



    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        Platform.runLater(()->
                {
                    if(evt.getPropertyName().equals("insideTemp1"))
                    {
                        if((Double.parseDouble(evt.getNewValue().toString()) < MIN || Double.parseDouble(evt.getNewValue().toString()) && !view.popUpOpen())
                        {
                            bool.setValue(true);
                        }
                        else  if(!(temp < MIN || temp > MAX) && view.popUpOpen() && !(Double.parseDouble(insideTemp2) < MIN || Double.parseDouble(insideTemp2) > MAX))
                            bool.setValue(false);

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
