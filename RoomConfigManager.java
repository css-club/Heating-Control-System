public class RoomConfigManager {

    private double presenceTemp;
    private double awayTemp;
    private int insideTime;
    private int awayTime;
    
    public RoomConfigManager() {
        this.presenceTemp = 20.0;
        this.awayTemp = 15.0;
        this.insideTime = 5;
        this.awayTime = 15;
    }

    public void setPresenceTemp(double temp) {
        if (temp >= 10 && temp <= 30) {
            this.presenceTemp = temp;
            System.out.println("Presence temperature set to: " + temp + "°C");
        } else {
            System.out.println("Invalid presence temperature. Please set a value between 10°C and 30°C.");
        }
    }

    public void setAwayTemp(double temp) {
        if (temp >= 5 && temp <= 25) {
            this.awayTemp = temp;
            System.out.println("Away temperature set to: " + temp + "°C");
        } else {
            System.out.println("Invalid away temperature. Please set a value between 5°C and 25°C.");
        }
    }

    public void setInsideTime(int minutes) {
        if (minutes >= 1 && minutes <= 60) {
            this.insideTime = minutes;
            System.out.println("Inside time set to: " + minutes + " minutes");
        } else {
            System.out.println("Invalid inside time. Please set a value between 1 and 60 minutes.");
        }
    }

    public void setAwayTime(int minutes) {
        if (minutes >= 1 && minutes <= 60) {
            this.awayTime = minutes;
            System.out.println("Away time set to: " + minutes + " minutes");
        } else {
            System.out.println("Invalid away time. Please set a value between 1 and 60 minutes.");
        }
    }

    public double getPresenceTemp() {
        return this.presenceTemp;
    }

    public double getAwayTemp() {
        return this.awayTemp;
    }

    public int getInsideTime() {
        return this.insideTime;
    }

    public int getAwayTime() {
        return this.awayTime;
    }

    public void displayCurrentConfig() {
        System.out.println("Current Configuration:");
        System.out.println("Presence Temperature: " + this.presenceTemp + "°C");
        System.out.println("Away Temperature: " + this.awayTemp + "°C");
        System.out.println("Inside Time: " + this.insideTime + " minutes");
        System.out.println("Away Time: " + this.awayTime + " minutes");
    }

    public static void main(String[] args) {
        RoomConfigManager roomConfig = new RoomConfigManager();
        
        roomConfig.displayCurrentConfig();

        roomConfig.setPresenceTemp(22.0);
        roomConfig.setAwayTemp(18.0);
        roomConfig.setInsideTime(10);
        roomConfig.setAwayTime(20);
        
        roomConfig.displayCurrentConfig();
        
        System.out.println("Presence Temperature: " + roomConfig.getPresenceTemp() + "°C");
        System.out.println("Away Temperature: " + roomConfig.getAwayTemp() + "°C");
        System.out.println("Inside Time: " + roomConfig.getInsideTime() + " minutes");
        System.out.println("Away Time: " + roomConfig.getAwayTime() + " minutes");
    }
}
