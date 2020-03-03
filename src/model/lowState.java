package model;
public class lowState implements HeaterState
{
    boolean completed;
    Thread timer;

    public lowState(HeaterModel model)
    {
        model.setHeaterLevel("1");
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
            System.out.println("Heater is now on idle setting");
            model.setState(new idleState(model));
            completed = true;
        }
    }

    @Override
    public void upButton(HeaterModel model)
    {
        if (!completed)
        {
            timer.interrupt();
            System.out.println("Heater is now on MEDIUM setting");
            model.setState(new mediumState(model));
            completed = true;
        }
    }
}
