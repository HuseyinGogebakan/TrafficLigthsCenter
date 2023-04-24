import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class TrafficLigthSystem {
    private static HashMap<Places_Be,HashMap<String,TrafficLight>> database_be;
    private static Scanner scan= new Scanner(System.in);

    public static void control_Panel(){
        LocalDateTime start = LocalDateTime.now();
        boolean flag = true;
        while (flag){
            menu();
            int option = intcheck();
            switch (option){
                case 1-> TrafficPanel_Ops.addTrafficLight(database_be);
                case 2-> TrafficPanel_Ops.deleteTrafficLight(database_be);
                case 3-> TrafficPanel_Ops.getTrafficLight(database_be);
                case 4-> TrafficPanel_Ops.updateTrafficLightState(database_be);
                case 5-> TrafficPanel_Ops.getTrafficLightsByLocation(database_be);
                case 6-> TrafficPanel_Ops.getAllTrafficLights(database_be);
                case 7-> TrafficPanel_Ops.CheckTraffocLigthStatus(database_be);
                case 0-> flag =false;
                default->
                    System.out.println("invalid value");
            }


        }
        LocalDateTime end = LocalDateTime.now();
        System.out.println("Your changes are made and sucessfully exited. The time panel used is "
                + (end.getHour() - start.getHour()) + " hr" + (end.getMinute() - start.getMinute()) + " min"
                + (end.getSecond() - start.getSecond()) + " sec");
    }



    private static void menu() {
        System.out.println("\033[1;36m" // Bold cyan color
                + "Traffic Light Management System\n"
                + "\033[0;32m" // Green color
                + "--------------------------------\n"
                + "1. Add Traffic Light\n"
                + "2. Delete Traffic Light\n"
                + "3. Get Traffic Light\n"
                + "4. Update Traffic Light State\n"
                + "5. Get Traffic Lights by Location\n"
                + "6. Get All Traffic Lights\n"
                + "7. Check Traffic Light Status\n"
                + "0. Exit\n"
                + "\033[0m");
    }


    public  static int intcheck() {
        int option;
            try{
                option = scan.nextInt();
            }catch (IllegalArgumentException x){
                System.out.println("please enter the digits you see near the menu");
                menu();
                option = scan.nextInt();
            }
            return option;

    }
}
