package view;

import ViewModel.PopUpViewModel;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;


public class PopUpController
{
    private ViewHandler viewHandler;
    private PopUpViewModel model;
    private Region root;
    @FXML Label temperatureLabel;


    public void init(ViewHandler viewHandler, PopUpViewModel popUpViewModel, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = popUpViewModel;
        this.root = root;

        temperatureLabel.setText("LOW");
        temperatureLabel.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        model.getHotProperty().addListener((observable, oldValue, newValue)->
                {
                    if(!model.getHotProperty().getValue().equals(true))
                    {
                        temperatureLabel.setText("LOW");
                        temperatureLabel.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                    }
                    if(model.getHotProperty().getValue().equals(true))
                    {
                        temperatureLabel.setText("HIGH");
                        temperatureLabel.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                    }
                }
        );
    }

    public void reset()
    {
        model.reset();
    }

    public Region getRoot()
    {
        return this.root;
    }

}
