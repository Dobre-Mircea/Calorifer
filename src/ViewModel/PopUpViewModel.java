package ViewModel;

import model.HeaterModel;
import model.PropertyChangeStuff;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PopUpViewModel implements PropertyChangeStuff {
    public int state;
    PropertyChangeSupport support;

    public PopUpViewModel(HeaterModel model)
    {
        this.state = 0;
        support = new PropertyChangeSupport(this);
    }

    public void hot()
    {
        support.firePropertyChange("HOT", "", "");
    }

    public void cold()
    {
        support.firePropertyChange("COLD", "", "");
    }


    @Override
    public void addListener(String propertyName, PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(propertyName, listener);
    }
}
