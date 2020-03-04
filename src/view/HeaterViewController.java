package view;

import ViewModel.HeaterViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;


public class HeaterViewController
{
   @FXML private Label outsideTemp;
   @FXML private Label insideTemp1;
   @FXML private Label insideTemp2;
   @FXML private Label currentSetting;

   private ViewHandler viewHandler;
   private HeaterViewModel model;
   private Region root;

   public HeaterViewController()
   {
   }

   public void init(ViewHandler viewHandler, HeaterViewModel model, Region root)
   {
      this.viewHandler = viewHandler;
      this.model = model;
      //model.addListener("insideTemp1", this);
      this.root = root;
      this.outsideTemp.textProperty().bind(model.getOutsideTempProperty());
      this.insideTemp1.textProperty().bind(model.getInsideTemp1Property());
      this.insideTemp2.textProperty().bind(model.getInsideTemp2Property());
      this.currentSetting.textProperty().bind(model.getHeaterState());
   }

   public void reset()
   {
      // empty
   }

   public Region getRoot()
   {
      return root;
   }

   @FXML private void heaterDown()
   {
      model.heaterDown();
   }

   @FXML private void heaterUp()
   {
      model.heaterUp();
   }

}
