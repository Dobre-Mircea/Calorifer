package ViewModel;

import model.HeaterModel;

public class ViewModelFactory {
    private HeaterViewModel heaterViewModel;
    private PopUpViewModel popUpViewModel;

    public ViewModelFactory(HeaterModel model)
    {
        heaterViewModel = new HeaterViewModel(model);
        popUpViewModel = new PopUpViewModel(model);
    }

    public HeaterViewModel getHeaterViewModel()
    {
        return this.heaterViewModel;
    }

    public PopUpViewModel getPopUpViewModel()
    {
        return this.popUpViewModel;
    }

}
