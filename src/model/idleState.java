package model;

public class idleState implements HeaterState
{
    boolean completed;
    Thread timer;

    public idleState(HeaterModel model)
    {
        model.setHeaterLevel("0");
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
            System.out.println("HEATER IS ALREADY IDLING");
        }
    }

    @Override
    public void upButton(HeaterModel model)
    {
        if (!completed)
        {
            timer.interrupt();
            System.out.println("Heater is now on Low setting");
            model.setState(new lowState(model));
            completed = true;
        }
    }
}
