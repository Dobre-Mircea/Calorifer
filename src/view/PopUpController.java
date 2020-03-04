package view;

import ViewModel.HeaterViewModel;
import ViewModel.PopUpViewModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PopUpController implements PropertyChangeListener
{
    @FXML Label warningLabel;

    private ViewHandler viewHandler;
    private PopUpViewModel model;
    private Region root;



    public void init(ViewHandler viewHandler, PopUpViewModel popUpViewModel, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = popUpViewModel;
        this.root = root;
    }

    public void reset()
    {
    }

    public Region getRoot()
    {
        return this.root;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if(evt.getPropertyName().equals("COLD"))
            warningLabel.setText("COLD");
        else if(evt.getPropertyName().equals("HOT"))
            warningLabel.setText(("HOT"));
    }
}
