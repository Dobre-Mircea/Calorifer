package model;

import ViewModel.ViewModelFactory;
import javafx.stage.Stage;
import view.ViewHandler;

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
    ViewModelFactory factory;
    ViewHandler view;
    Stage primaryStage;

    public void setStuff(ViewModelFactory factory, ViewHandler view, Stage primaryStage)
    {
        this.factory = factory;
        this.view = view;
        this.primaryStage = primaryStage;
    }

    public HeaterModelManager()
    {
        support = new PropertyChangeSupport(this);
        heaterState = new idleState(this);
        insideTemp1 = "20";
        insideTemp2 = "20";
        outsideTemp = "15.00";

    }

    @Override
    public void setState(HeaterState state)
    {
        this.heaterState = state;
    }

    public HeaterState getHeaterState()
    {
        return this.heaterState;
    }

    public PropertyChangeSupport getChange()
    {
        return this.support;
    }

    public String getInsideTemp2()
    {
        return this.insideTemp2;
    }

    public String getInsideTemp1()
    {
        return this.insideTemp1;
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
        if(insideTemp1.length() > 5)
            this.insideTemp1 = this.insideTemp1.substring(0, 5);
        support.firePropertyChange("insideTemp1", "muie", insideTemp1);

        if(temp < 15)
        {
            view.openView("popUp");
            factory.getPopUpViewModel().cold();
        }
        else if(temp > 22)
        {
            view.openView("popUp");
            factory.getPopUpViewModel().hot();
        }
    }

    public void setInsideTemp2(Double temp)
    {
        this.insideTemp2 = temp.toString();
        if(insideTemp2.length() > 5)
            this.insideTemp2 = this.insideTemp2.substring(0, 5);
        support.firePropertyChange("insideTemp2", "muie", insideTemp2);

        if(temp < 15)
        {
            view.openView("popUp");
            factory.getPopUpViewModel().cold();
        }
        else if(temp > 30)
        {
            view.openView("popUp");
            factory.getPopUpViewModel().hot();
        }
    }

    public void setOutsideTemp(Double temp)
    {
        this.outsideTemp = temp.toString();
        if(outsideTemp.length() > 5)
            this.outsideTemp = this.outsideTemp.substring(0, 5);
        support.firePropertyChange("outsideTemp", "sugeoba", outsideTemp);
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
