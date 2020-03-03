package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public interface HeaterModel extends PropertyChangeStuff
{
    public void setState(HeaterState state);
    public void setHeaterLevel(String state);
    public HeaterState getHeaterState();
    public PropertyChangeSupport getChange();
}
