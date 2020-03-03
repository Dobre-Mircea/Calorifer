import javafx.application.Application;
import javafx.stage.Stage;
import model.HeaterModel;
import model.HeaterModelManager;
import view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    //test2
    //test
    // Model
    HeaterModel model = new HeaterModelManager();
    //Thermometer bai = new Thermometer(model, "Muist", 23, 2);
    //Thermometer bai2 = new Thermometer(model, "Muist2", 13, 6);
    //Thread thread = new Thread(bai);
    //thread.setDaemon(true);
    //Thread thread2 = new Thread(bai2);
    //thread2.setDaemon(true);
    //thread.start();
    //thread2.start();x`
    // View
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
    /////////////////////////////////////////////////
    //test3
  }
}
