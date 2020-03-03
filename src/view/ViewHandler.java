package view;

import ViewModel.HeaterViewModel;
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
  private HeaterModel model;

  public ViewHandler(HeaterModel model)
  {
    this.model = model;
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    this.currentScene = new Scene(new Region());
    openView("temperature");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "temperature":
        root = loadTemperatureView("TemperatureView.fxml");
        break;
    }
    currentScene.setRoot(root);

    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  private Region loadTemperatureView(String fxmlFile)
  {
    if (heaterViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        heaterViewController = loader.getController();
        heaterViewController.init(this, (HeaterViewModel) model, root);
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

}
