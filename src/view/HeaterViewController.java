package view;

import ViewModel.HeaterViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class HeaterViewController
{
   @FXML private Label outsideTemp;
   @FXML private Label insideTemp1;
   @FXML private Label insideTemp2;
   @FXML private Label currentSetting;
   @FXML private Circle outsideCircle;
   @FXML private Circle temp2Circle;
   @FXML private Circle temp1Circle;


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
      this.root = root;
      this.outsideTemp.textProperty().bind(model.getOutsideTempProperty());
      this.insideTemp1.textProperty().bind(model.getInsideTemp1Property());
      this.insideTemp2.textProperty().bind(model.getInsideTemp2Property());
      this.currentSetting.textProperty().bind(model.getHeaterState());

      model.getBoolProperty().addListener((observable, oldValue, newValue) ->
      {
         if(newValue)
            this.viewHandler.openView("popUp");
         else viewHandler.closePopUp();
      });

      model.getInsideTemp1Property().addListener((observable, oldValue, newValue) ->
      {
         if(Double.parseDouble(newValue) < 15)
            temp1Circle.setFill(Color.BLUE);
         else if(Double.parseDouble(newValue) < 20)
            temp1Circle.setFill(Color.LIGHTBLUE);
         else if(Double.parseDouble(newValue) > 20 && Double.parseDouble(newValue) < 25)
            temp1Circle.setFill(Color.GREEN);
         else if(Double.parseDouble(newValue) > 25 && Double.parseDouble(newValue) < 30)
            temp1Circle.setFill(Color.ORANGE);
         else if(Double.parseDouble(newValue) > 30)
            temp1Circle.setFill(Color.RED);
      }
      );

      model.getInsideTemp2Property().addListener((observable, oldValue, newValue) ->
              {
                 if(Double.parseDouble(newValue) < 15)
                    temp2Circle.setFill(Color.BLUE);
                 else if(Double.parseDouble(newValue) < 20)
                    temp2Circle.setFill(Color.LIGHTBLUE);
                 else if(Double.parseDouble(newValue) > 20 && Double.parseDouble(newValue) < 25)
                    temp2Circle.setFill(Color.GREEN);
                 else if(Double.parseDouble(newValue) > 25 && Double.parseDouble(newValue) < 30)
                    temp2Circle.setFill(Color.ORANGE);
                 else if(Double.parseDouble(newValue) > 30)
                    temp2Circle.setFill(Color.RED);
              }
      );

      model.getOutsideTempProperty().addListener((observable, oldValue, newValue) ->
              {
                 if(Double.parseDouble(newValue) < 15)
                    outsideCircle.setFill(Color.BLUE);
                 else if(Double.parseDouble(newValue) < 20)
                    outsideCircle.setFill(Color.LIGHTBLUE);
                 else if(Double.parseDouble(newValue) > 20 && Double.parseDouble(newValue) < 25)
                    outsideCircle.setFill(Color.GREEN);
                 else if(Double.parseDouble(newValue) > 25 && Double.parseDouble(newValue) < 30)
                    outsideCircle.setFill(Color.ORANGE);
                 else if(Double.parseDouble(newValue) > 30)
                    outsideCircle.setFill(Color.RED);
              }
      );

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
