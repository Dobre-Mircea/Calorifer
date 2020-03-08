package ViewModel;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import model.HeaterModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PopUpViewModel implements PropertyChangeListener
{

    private final int MAX = 30;
    private final int MIN = 15;

    private BooleanProperty hot;

    private HeaterModel model;
    public PopUpViewModel(HeaterModel model)
    {
        this.model = model;
        model.addListener("insideTemp1" , this);
        model.addListener("insideTemp2" , this);
        hot = new SimpleBooleanProperty(false);
    }

    public BooleanProperty getHotProperty()
    {
        return this.hot;
    }


    public void reset()
    {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        Platform.runLater(()->
        {
            if(evt.getPropertyName().equals("insideTemp1"))
            {
                if((Double.parseDouble(model.getInsideTemp2()) > MAX || Double.parseDouble(model.getInsideTemp1()) > MAX))
                {
                    hot.setValue(true);
                }
                if((Double.parseDouble(model.getInsideTemp2()) < MIN || Double.parseDouble(model.getInsideTemp1()) < MIN))
                {
                    hot.setValue(false);
                }
            }
            else if(evt.getPropertyName().equals("insideTemp2"))
            {
                if((Double.parseDouble(model.getInsideTemp2()) > MAX || Double.parseDouble(model.getInsideTemp1()) > MAX))
                {
                    hot.setValue(true);
                }
                if((Double.parseDouble(model.getInsideTemp2()) < MIN || Double.parseDouble(model.getInsideTemp1()) < MIN))
                {
                    hot.setValue(false);
                }
            }
        });
    }
}
