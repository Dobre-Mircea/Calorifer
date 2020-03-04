import ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import model.HeaterModel;
import model.HeaterModelManager;
import model.Thermometer;
import view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    HeaterModel model = new HeaterModelManager();
    ViewModelFactory factory = new ViewModelFactory(model);


    Thermometer t1 = new Thermometer(model, 1);
    Thread bai = new Thread(t1);
    bai.setDaemon(true);
    bai.start();
    Thermometer t2 = new Thermometer(model, 2);
    Thread bai2 = new Thread(t2);
    bai2.setDaemon(true);
    bai2.start();

    Thermometer out = new Thermometer(model, 3);
    Thread outT = new Thread(out);
    outT.setDaemon(true);
    outT.start();


    ViewHandler view = new ViewHandler(factory);

    model.setStuff(view);

    view.start(primaryStage);

    //view.openView("popUp");
  }
}
