
public class EventManager {
    private BoilerManager boilerManager;
    private WindowManager windowManager;
    private RoomConfigManager roomConfigManager;

    
    public EventManager(BoilerManager boilerManager, WindowManager windowManager, RoomConfigManager roomConfigManager) {
        this.boilerManager = boilerManager;
        this.windowManager = windowManager;
        this.roomConfigManager = roomConfigManager;
    }

    
    public void handleEvent(String eventType) {
        switch (eventType.toLowerCase()) {
            case "rain":
                triggerRainEvent();
                break;

            case "roomempty":
                triggerRoomEmptyEvent();
                break;

            case "temperaturethreshold":
                adjustBoilerTempForThreshold();
                break;

            default:
                System.out.println("Unhandled event type: " + eventType);
                break;
        }
    }

    
    private void triggerRainEvent() {
        System.out.println("Rain detected! Adjusting windows...");
        windowManager.closeWindow(); 
    }

    
    private void triggerRoomEmptyEvent() {
        System.out.println("Room is empty! Activating energy-saving mode...");
        roomConfigManager.setAwayTemp(18.0); 
    }

    
    private void adjustBoilerTempForThreshold() {
        System.out.println("Temperature threshold breached! Adjusting boiler...");
        boilerManager.adjustBoilerTemp(22.0); 
    }

     public static void main(String[] args) {
    
        BoilerManager boilerManager = new BoilerManager();
        WindowManager windowManager = new WindowManager();
        RoomConfigManager roomConfigManager = new RoomConfigManager();

        
        EventManager manager = new EventManager(boilerManager, windowManager, roomConfigManager);

        
        manager.handleEvent("rain");
        manager.handleEvent("roomempty");
        manager.handleEvent("temperaturethreshold");
        manager.handleEvent("unknown");
    }
}


class BoilerManager {
    public void adjustBoilerTemp(double temp) {
        System.out.println("Boiler temperature adjusted to: " + temp + "°C");
    }
}


class WindowManager {
    public void closeWindow() {
        System.out.println("Window closed.");
    }
}

class RoomConfigManager {
    public void setAwayTemp(double temp) {
        System.out.println("Away temperature set to: " + temp + "°C");
    }
}
