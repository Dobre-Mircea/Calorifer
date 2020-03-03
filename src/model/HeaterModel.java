package model;

import java.beans.PropertyChangeListener;

public interface HeaterModel extends PropertyChangeStuff
{
    public void setState(HeaterState state);
    public void setHeaterLevel(String state);

}
