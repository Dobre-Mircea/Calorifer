package model;

import ViewModel.HeaterViewModel;

public class Thermometer implements Runnable {
    private HeaterModel model;
    private int setting;

    public Thermometer(HeaterModel model, int setting) {
        this.model = model;
        this.setting = setting;
    }

    @Override
    public synchronized void run() {
        while (true)
        {
            if (setting == 1)
            {
                model.setInsideTemp1(temperature(Double.parseDouble(model.getInsideTemp1()), Integer.parseInt(model.getHeaterLevel()), 1, Double.parseDouble(model.getOutsideTemp()), 5));
            } else if (setting == 2)
            {
                model.setInsideTemp2(temperature(Double.parseDouble(model.getInsideTemp2()), Integer.parseInt(model.getHeaterLevel()), 7, Double.parseDouble(model.getOutsideTemp()), 5));
            } else if (setting == 3)
            {
                model.setOutsideTemp(externalTemperature(Double.parseDouble(model.getOutsideTemp()), -10, 45));
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public double externalTemperature(double t0, double min, double max) {
        double left = t0 - min;
        double right = max - t0;
        int sign = Math.random() * (left + right) > left ? 1 : -1;
        t0 += sign * Math.random();
        return t0;
    }

    public double temperature(double t, int p, int d, double t0, int s) {
        double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
        tMax = Math.max(Math.max(t, tMax), t0);
        double heaterTerm = 0;
        if (p > 0) {
            double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
            heaterTerm = 30 * s * Math.abs(tMax - t) / den;
        }
        double outdoorTerm = (t - t0) * s / 250.0;
        t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
        return t;
    }


}
