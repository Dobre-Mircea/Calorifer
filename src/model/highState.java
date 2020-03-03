package model;

public class highState implements HeaterState
{
    boolean completed;
    Thread timer;

    public highState(HeaterModel model)
    {
        model.setHeaterLevel("3");
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
            model.setState(new lowState(model));
            completed = true;
        }
    }

    @Override
    public void upButton(HeaterModel model)
    {
        if (!completed)
        {
            System.out.println("Heater is allready on MAX");
        }
    }
}
