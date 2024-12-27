// Base Sensor Class
abstract class Sensor {
    protected String sensorType;

    public Sensor(String sensorType) {
        this.sensorType = sensorType;
    }

    public abstract double readValue();
}

// Temperature Sensor Class
class TemperatureSensor extends Sensor {
    private double currentTemperature;

    // Constructor that accepts an initial temperature set by the user
    public TemperatureSensor(double initialTemperature) {
        super("Temperature");
        this.currentTemperature = initialTemperature;
    }

    @Override
    public double readValue() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double temperature) {
        this.currentTemperature = temperature;
    }
}

// Rain Sensor Class
class RainSensor extends Sensor {
    private boolean isRaining;

    // Constructor that accepts an initial state set by the user
    public RainSensor(boolean initialState) {
        super("Rain");
        this.isRaining = initialState;
    }

    @Override
    public double readValue() {
        return isRaining ? 1.0 : 0.0; // 1 for raining, 0 for not raining
    }

    public void setRaining(boolean raining) {
        this.isRaining = raining;
    }
}

// Presence Sensor Class
class PresenceSensor extends Sensor {
    private boolean isPersonInside;

    // Constructor that accepts an initial state set by the user
    public PresenceSensor(boolean initialState) {
        super("Presence");
        this.isPersonInside = initialState;
    }

    @Override
    public double readValue() {
        return isPersonInside ? 1.0 : 0.0; // 1 for presence, 0 for absence
    }

    public void setPersonInside(boolean personInside) {
        this.isPersonInside = personInside;
    }
}


