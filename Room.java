public class Room {
    boolean PresenceSwitch;
    int outsideTemp = 21;
    boolean window;
    boolean rainSwitch;
    int TargetTemp = 19;
    int roomTemp = 18;

    public Room(boolean presenceSwitch, int outsideTemp, boolean window, boolean rainSwitch, int targetTemp, int roomTemp) {
        PresenceSwitch = presenceSwitch;
        this.outsideTemp = outsideTemp;
        this.window = window;
        this.rainSwitch = rainSwitch;
        TargetTemp = targetTemp;
        this.roomTemp = roomTemp;
    }

    public boolean isPresenceSwitch() {
        return PresenceSwitch;
    }

    public void setPresenceSwitch(boolean presenceSwitch) {
        PresenceSwitch = presenceSwitch;
    }

    public int getOutsideTemp() {
        return outsideTemp;
    }

    public void setOutsideTemp(int outsideTemp) {
        this.outsideTemp = outsideTemp;
    }

    public boolean isWindow() {
        return window;
    }

    public void setWindow(boolean window) {
        this.window = window;
    }

    public boolean isRainSwitch() {
        return rainSwitch;
    }

    public void setRainSwitch(boolean rainSwitch) {
        this.rainSwitch = rainSwitch;
    }

    public int getTargetTemp() {
        return TargetTemp;
    }

    public void setTargetTemp(int targetTemp) {
        TargetTemp = targetTemp;
    }

    public int getRoomTemp() {
        return roomTemp;
    }

    public void setRoomTemp(int roomTemp) {
        this.roomTemp = roomTemp;
    }
}
