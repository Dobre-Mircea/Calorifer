package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HeaterModelManager implements HeaterModel
{
    private PropertyChangeSupport support;

    private String insideTemp1;
    private String insideTemp2;
    private String outsideTemp;
    private String heaterLevel;

    private HeaterState heaterState;

    public HeaterModelManager()
    {
        support = new PropertyChangeSupport(this);
        heaterState = new idleState(this);
    }

    @Override
    public void setState(HeaterState state)
    {
        this.heaterState = state;
    }

    public String getInsideTemp2()
    {
        return this.insideTemp2;
    }

    public String getOutsideTemp()
    {
        return this.outsideTemp;
    }

    public String getHeaterLevel()
    {
        return this.heaterLevel;
    }

    public void setInsideTemp1(Double temp)
    {
        this.insideTemp1 = temp.toString();
    }

    public void setInsideTemp2(Double temp)
    {
        this.insideTemp2 = temp.toString();
    }

    public void setOutsideTemp(Double temp)
    {
        this.outsideTemp = temp.toString();
    }

    public void setHeaterLevel(String state)
    {
        this.heaterLevel = state;
    }

    @Override
    public void addListener(String propertyName, PropertyChangeListener listener)
    {
        this.support.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener)
    {
        this.support.removePropertyChangeListener(propertyName, listener);
    }


    // and maybe other methods...
}
