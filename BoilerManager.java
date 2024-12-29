package heatingSystem;
public class BoilerManager {

    private final double boilerMaxTemp = 70.0; // maximum temperature the boiler can reach
    private boolean isBoilerOn = false;        // Boiler off by default
    private double boilerTemp=0.0;             // Current temperature of the boiler

    public BoilerManager() {
        // Constructor
    }

    public double getBoilerTemp() {
        return boilerTemp; // Returns the current temperature of the boiler
    }

    public boolean isBoilerOn() {
        return isBoilerOn; // Returns whether the boiler is on or off
    }

    public void turnOnBoiler() {
        isBoilerOn = true;  // Turn on the boiler
        System.out.println("Boiler is on");
    }

    public void turnOffBoiler() {
        isBoilerOn = false; // Turn off the boiler
        System.out.println("Boiler is off");
    }

    public void adjustBoilerTemp(double maxRequiredTemp) {
        if (isBoilerOn) {
            if (maxRequiredTemp <= boilerMaxTemp) {
                boilerTemp = maxRequiredTemp;
                System.out.println("Boiler temperature set to " + maxRequiredTemp); // Set the boiler temperature to the required temperature
            } else {
                boilerTemp = boilerMaxTemp;
                System.out.println("Maximum temperature reached, setting to maximum temperature of " + boilerMaxTemp); // Set the boiler temperature to the maximum temperature
            }
        } else {
            System.out.println("Boiler is off, turn on the boiler to adjust temperature");
        }
    }
    
    
}