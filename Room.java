class Room {
    int PresenceTemp = 20;
    int AwayTemp = 15;
    int InsideTime = 5;
    int Awaytime = 15;
    int HeatingTime = 10;

    boolean PresenceSwitch;
    int outsideTemp;
    boolean window;
    boolean rainSwitch;
    int TargetTemp;
    int roomTemp;

    public Room(boolean presenceSwitch, int outsideTemp, boolean window, boolean rainSwitch, int targetTemp, int roomTemp) {
        PresenceSwitch = presenceSwitch;
        this.outsideTemp = outsideTemp;
        this.window = window;
        this.rainSwitch = rainSwitch;
        TargetTemp = targetTemp;
        this.roomTemp = roomTemp;
    }

    public int getPresenceTemp() { return PresenceTemp; }
    public void setPresenceTemp(int presenceTemp) { PresenceTemp = presenceTemp; }
    public int getAwayTemp() { return AwayTemp; }
    public void setAwayTemp(int awayTemp) { AwayTemp = awayTemp; }
    public int getInsideTime() { return InsideTime; }
    public void setInsideTime(int insideTime) { InsideTime = insideTime; }
    public int getAwaytime() { return Awaytime; }
    public void setAwaytime(int awaytime) { Awaytime = awaytime; }
    public int getHeatingTime() { return HeatingTime; }
    public void setHeatingTime(int heatingTime) { HeatingTime = heatingTime; }
    public boolean isPresenceSwitch() { return PresenceSwitch; }
    public void setPresenceSwitch(boolean presenceSwitch) { PresenceSwitch = presenceSwitch; }
    public int getOutsideTemp() { return outsideTemp; }
    public void setOutsideTemp(int outsideTemp) { this.outsideTemp = outsideTemp; }
    public boolean isWindow() { return window; }
    public void setWindow(boolean window) { this.window = window; }
    public boolean isRainSwitch() { return rainSwitch; }
    public void setRainSwitch(boolean rainSwitch) { this.rainSwitch = rainSwitch; }
    public int getTargetTemp() { return TargetTemp; }
    public void setTargetTemp(int targetTemp) { TargetTemp = targetTemp; }
    public int getRoomTemp() { return roomTemp; }
    public void setRoomTemp(int roomTemp) { this.roomTemp = roomTemp; }
    public void displayCurrentValues() {
        // Add output: Display all current values.
    }
}