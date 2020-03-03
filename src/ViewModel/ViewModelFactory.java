package ViewModel;

import model.HeaterModel;

public class ViewModelFactory {
    private HeaterViewModel heaterViewModel;

    public ViewModelFactory(HeaterModel model)
    {
        heaterViewModel = new HeaterViewModel(model);
    }

    public HeaterViewModel getHeaterViewModel()
    {
        return this.heaterViewModel;
    }

}
