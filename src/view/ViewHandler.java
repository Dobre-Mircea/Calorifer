package view;

import ViewModel.HeaterViewModel;
import ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.HeaterModel;

public class ViewHandler extends Application
{
    private Stage primaryStage;
    private Scene currentScene;

    private HeaterViewController heaterViewController;
    private PopUpController popUpController;
    private ViewModelFactory factory;

    public ViewHandler(ViewModelFactory factory)
    {
        this.factory = factory;
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.currentScene = new Scene(new Region());
        this.openView("heater");
    }


    public void openView(String id)
    {
        Region root = null;
        String title = "";
        switch (id)
        {
            case "heater":
                root = loadHeaterView("HeaterView.fxml");
                title += "Heater Main Menu - Group 3";
                break;
            case "popUp":
                root = loadPopUpView("PopUp.fxml");
                title += "WARNING";
                break;
        }
        currentScene.setRoot(root);


        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    public void closeView()
    {
        primaryStage.close();
    }

    private Region loadHeaterView(String fxmlFile)
    {
        if (heaterViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                heaterViewController = loader.getController();
                heaterViewController.init(this, factory.getHeaterViewModel(), root);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            heaterViewController.reset();
        }
        return heaterViewController.getRoot();
    }


    private Region loadPopUpView(String fxmlFile)
    {
        if (popUpController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                popUpController = loader.getController();
                popUpController.init(this, factory.getPopUpViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            popUpController.reset();
        }
        return popUpController.getRoot();
    }



}
