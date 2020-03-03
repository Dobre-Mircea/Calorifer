package model;

public class mediumState implements  HeaterState
{
    boolean completed;
    Thread timer;

    public mediumState(HeaterModel model)
    {
        model.setHeaterLevel("2");
        model.getChange().firePropertyChange("heaterState", null, "2");
        completed = false;
        timer = new Thread(() -> {
            while(true)
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    System.out.println("");
                }
        });
        timer.start();
    }

    @Override
    public void downButton(HeaterModel model)
    {
        if (!completed)
        {
            timer.interrupt();
            System.out.println("Heater is now on LOW setting");
            model.setState(new lowState(model));
            completed = true;
        }
    }

    @Override
    public void upButton(HeaterModel model)
    {
        if (!completed)
        {
            timer.interrupt();
            System.out.println("Heater is now on MAX setting");
            model.setState(new highState(model));
            completed = true;
        }
    }
}
