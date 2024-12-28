import java.util.Scanner;

public class ScenarioSimulator {
    int PresenceTemp = 20;
    int AwayTemp = 15;
    int InsideTime = 5;
    int Awaytime = 15;
    int HeatingTime = 10;

   Room room = new Room(false, 10, false, false, 20, 18);

    public int getPresenceTemp() {
        return PresenceTemp;
    }

    public void setPresenceTemp(int presenceTemp) {
        PresenceTemp = presenceTemp;
    }

    public int getAwayTemp() {
        return AwayTemp;
    }

    public void setAwayTemp(int awayTemp) {
        AwayTemp = awayTemp;
    }

    public int getInsideTime() {
        return InsideTime;
    }

    public void setInsideTime(int insideTime) {
        InsideTime = insideTime;
    }

    public int getAwaytime() {
        return Awaytime;
    }

    public void setAwaytime(int awaytime) {
        Awaytime = awaytime;
    }

    public int getHeatingTime() {
        return HeatingTime;
    }

    public void setHeatingTime(int heatingTime) {
        HeatingTime = heatingTime;
    }


 public void scenario1 (){
     char c;
     Scanner scanner = new Scanner(System.in);
     System.out.println("Heating System :\n" +
             "1. Inside Time\n" +
             "2. Heating Time\n" +
             "3. Presence Temperature\n" +
             "4. Away Temperature\n" +
             "5. Away Time\n" +
             "6. See all the values");
     while (true) {
         String input = scanner.next();
         if (input.length() == 1 && input.charAt(0) >= '1' && input.charAt(0) <= '6') {
             c = input.charAt(0);
             break;
         } else {
             System.out.println("Please enter a number from 1 to 6.");
         }
     }
     switch (c) {
         case '1':
             System.out.println("Enter the inside time: ");
                 InsideTime = scanner.nextInt();
                System.out.println("Inside time set to " + InsideTime + " minutes.");
                 break;
         case '2':
             while (true) {
                 System.out.println("Enter the heating time: ");
                 int heatingTime = scanner.nextInt();
                 if (heatingTime < InsideTime + 5) {
                     System.out.println("Error: Heating time should be at least 5 minutes more than inside time.");
                 } else {
                     HeatingTime = heatingTime;
                     System.out.println("Heating time set to " + HeatingTime + " minutes.");
                     break;
                 }
             }
             break;
         case '3':
             System.out.println("Enter the presence temperature: ");
                 PresenceTemp = scanner.nextInt();
             System.out.println("Presence temperature set to " + PresenceTemp + " degrees.");
                 break;
         case '4':
                System.out.println("Enter the away temperature: ");
                    AwayTemp = scanner.nextInt();
             System.out.println("Away temperature set to " + AwayTemp + " degrees.");
                    break;
         case '5':
                System.out.println("Enter the away time: ");
                    Awaytime = scanner.nextInt();
                System.out.println("Away time set to " + Awaytime + " minutes.");
                    break;
         case '6':
             System.out.println("Current Values:");
             System.out.println("Inside Time: " + InsideTime + " minutes");
             System.out.println("Heating Time: " + HeatingTime + " minutes");
             System.out.println("Presence Temperature: " + PresenceTemp + " degrees");
             System.out.println("Away Temperature: " + AwayTemp + " degrees");
             System.out.println("Away Time: " + Awaytime + " minutes");
             System.out.println("Do you want to change any value? (yes/no)");
             String response = scanner.next();
             if (response.equalsIgnoreCase("yes")) {
                 scenario1();
             }
             break;
     }

 }

    public static void main(String[] args) {
        ScenarioSimulator simulator = new ScenarioSimulator();
        simulator.scenario1();
    }




}