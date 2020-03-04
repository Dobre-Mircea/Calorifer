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
    private Stage secoundStage;
    private Scene currentScene;
    private Scene secoundScene;

    private HeaterViewController heaterViewController;
    private PopUpController popUpController;
    private ViewModelFactory factory;

    public ViewHandler(ViewModelFactory factory)
    {
        this.factory = factory;
        this.currentScene = new Scene(new Region());
        this.secoundScene = new Scene(new Region());
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.secoundStage = new Stage();
        //this.currentScene = new Scene(new Region());
        this.openView("heater");
    }


    public void openView(String id)
    {
        switch (id)
        {
            case "heater":
                Region root = loadHeaterView("HeaterView.fxml");
                currentScene.setRoot(root);
                String title = "Heater Main Menu - Group 3";
                primaryStage.setTitle(title);
                primaryStage.setScene(currentScene);
                primaryStage.setWidth(root.getPrefWidth());
                primaryStage.setHeight(root.getPrefHeight());
                primaryStage.show();
                break;

            case "popUp":
                Region root2 = loadPopUpView("PopUp.fxml");
                secoundScene.setRoot(root2);
                String title2 = "WARNING";
                secoundStage.setTitle(title2);
                secoundStage.setScene(secoundScene);
                secoundStage.setWidth(root2.getPrefWidth());
                secoundStage.setHeight(root2.getPrefHeight());
                secoundStage.show();
                break;
        }

    }

    public void closeView()
    {
        primaryStage.close();
    }

    public void closePopUp()
    {
        secoundStage.close();
    }

    public boolean popUpOpen()
    {
        //if(popUpController == null)
          //  return false;
        //else return true;
        return secoundStage.isShowing();
    }

    private Region loadHeaterView(String fxmlFile)
    {
        Region root = null;
        if (heaterViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
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
        Region root = null;
        if (popUpController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                root = loader.load();
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
