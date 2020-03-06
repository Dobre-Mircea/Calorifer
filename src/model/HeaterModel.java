package model;

import ViewModel.ViewModelFactory;
import javafx.stage.Stage;
import view.ViewHandler;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public interface HeaterModel extends PropertyChangeStuff {
    public void setState(HeaterState state);

    public void setHeaterLevel(String state);

    public String getHeaterLevel();

    public PropertyChangeSupport getChange();

    public void setInsideTemp1(Double temp);

    public void setInsideTemp2(Double temp);

    public void setOutsideTemp(Double temp);

    public String getInsideTemp2();

    public String getInsideTemp1();

    public String getOutsideTemp();

    public HeaterState getHeaterState();
}