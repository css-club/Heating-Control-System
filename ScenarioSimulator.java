import java.util.Scanner;

// Simulation class to simulate scenarios
class ScenarioSimulator {
    private Room room;

    public ScenarioSimulator() {
        // Initialize the Room object with default values
        this.room = new Room(false, 21, false, false, 19, 18);
    }

    public void simulateScenario1() {
        Scanner scanner = new Scanner(System.in);
        boolean continueEditing = true;

        while (continueEditing) {
            // Add output: Display the menu options (1-7).
            String input = scanner.next();

            if (input.length() == 1 && input.charAt(0) >= '1' && input.charAt(0) <= '7') {
                char choice = input.charAt(0);

                switch (choice) {
                    case '1':
                        room.setInsideTime(scanner.nextInt());
                        break;
                    case '2':
                        room.setHeatingTime(scanner.nextInt());
                        break;
                    case '3':
                        room.setPresenceTemp(scanner.nextInt());
                        room.setTargetTemp(room.getPresenceTemp()); // Update target temperature
                        break;
                    case '4':
                        room.setAwayTemp(scanner.nextInt());
                        break;
                    case '5':
                        room.setAwaytime(scanner.nextInt());
                        break;
                    case '6':
                        room.displayCurrentValues(); // Add output: Display current room values.
                        break;
                    case '7':
                        continueEditing = false;
                        // Add output: "Exiting the system. Goodbye!"
                        break;
                    default:
                        // Add output: "Invalid choice. Please try again."
                }
            } else {
                // Add output: "Invalid input. Please enter a number from 1 to 7."
            }
        }
    }

    public void simulateScenario2() {
        //The user enters the room before the system activates
        room.setPresenceSwitch(true);
        room.setOutsideTemp(21);
        room.setWindow(false);
        room.setRainSwitch(true);
        room.setTargetTemp(15);
        room.setRoomTemp(18);
        // Add output: Simulate scenario 2 logic and behavior.
    }

    public void simulateScenario3() {
        room.setPresenceSwitch(false);
        room.setOutsideTemp(16);
        room.setWindow(false);
        room.setRainSwitch(true);
        room.setTargetTemp(20);
        room.setRoomTemp(19);

        if (room.getAwayTemp() == 0) {
            room.setTargetTemp(room.getAwayTemp());
            // Add output: Room target temperature set to away temperature.
        }
        // Add output: Window remains closed as the room is empty.
    }

    public void simulateScenario4() {
        room.setPresenceSwitch(false);
        room.setOutsideTemp(19);
        room.setWindow(false);
        room.setRainSwitch(true);
        room.setTargetTemp(20);
        room.setRoomTemp(19);
        // Add output: User returns before away time elapses, no temperature change.
    }

    public void simulateScenario5() {
        room.setPresenceSwitch(false);
        room.setOutsideTemp(19);
        room.setWindow(false);
        room.setRainSwitch(true);
        room.setTargetTemp(20);
        room.setRoomTemp(20);

        room.setPresenceSwitch(true);
        room.setWindow(true);
        room.setTargetTemp(room.getAwayTemp());
        // Add output: Window opened, target temperature set to away temperature.
    }

    public void simulateScenario6() {
        room.setPresenceSwitch(false);
        room.setOutsideTemp(17);
        room.setWindow(true);
        room.setRainSwitch(false);
        room.setTargetTemp(15);
        room.setRoomTemp(18);

        room.setRainSwitch(true);
        if (room.isWindow()) {
            room.setWindow(false);
            // Add output: System tilted the window to rain-secure position.
        }
        room.setWindow(true); // User manually reopens the window.
        // Add output: User manually reopened the window.
    }

    public void simulateScenario7() {
        room.setPresenceSwitch(false);
        room.setOutsideTemp(17);
        room.setWindow(false);
        room.setRainSwitch(true);
        room.setTargetTemp(20);
        room.setRoomTemp(21);
        // Add output: System should tilt the window to cool down the room.
    }

    public void simulateScenario8() {
        room.setPresenceTemp(20);
        room.setAwayTemp(15);
        room.setInsideTime(5);
        room.setAwaytime(15);
        // Add output: Default values set for all parameters.
    }

    public void simulateScenario9() {
        room.setPresenceSwitch(false);
        room.setOutsideTemp(14);
        room.setWindow(false);
        room.setRainSwitch(true);
        room.setTargetTemp(20);
        room.setRoomTemp(18);

        if (room.roomTemp == 19) {
            // Add output: Boiler temperature computed as room target temperature is reached.
        }
    }

    public void simulateScenario10() {
        room.setPresenceSwitch(false);
        room.setOutsideTemp(23);
        room.setWindow(false);
        room.setRainSwitch(true);
        room.setTargetTemp(20);
        room.setRoomTemp(21);
        // Add output: Compute required heating adjustments.
    }

    public void simulateScenario11() {
        room.setPresenceSwitch(false);
        room.setOutsideTemp(23);
        room.setWindow(false);
        room.setRainSwitch(false);
        room.setTargetTemp(20);
        room.setRoomTemp(22);

        if (room.getRoomTemp() > room.getTargetTemp() + 1) {
            room.setTargetTemp(0); // Heater off
            // Add output: Room temperature exceeds target. Heater turned off.
        }
    }

    public void simulateScenario12() {
        boolean room1NeedsHeat = true;
        boolean room2NeedsHeat = false;
        boolean room3NeedsHeat = false;

        if (room1NeedsHeat || room2NeedsHeat || room3NeedsHeat) {
            // Add output: At least one room requires heat, water pump activated.
        }
    }

    public void simulateScenario13() {
        boolean room1NeedsHeat = true;
        boolean room2NeedsHeat = false;
        boolean room3NeedsHeat = true;
        boolean isPumpOn = true;

        room2NeedsHeat = true;

        if (isPumpOn) {
            // Add output: Water pump is already ON, no changes made.
        }
    }
}
