package model;

public class highState implements HeaterState
{
    boolean completed;
    Thread timer;

    public highState(HeaterModel model)
    {
        model.setHeaterLevel("3");
        model.getChange().firePropertyChange("heaterState", null, "3");
        completed = false;
        timer = new Thread(() -> {
                try {
                    Thread.sleep(4000);
                    this.downButton(model);
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
            System.out.println("Heater is now on Medium setting");
            model.setState(new mediumState(model));
            completed = true;
        }
    }

    @Override
    public void upButton(HeaterModel model)
    {
        System.out.println("Heater is allready on MAX");
    }
}
