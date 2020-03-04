package view;

import ViewModel.PopUpViewModel;
import javafx.scene.layout.Region;


public class PopUpController
{
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
        model.reset();
    }

    public Region getRoot()
    {
        return this.root;
    }

}
