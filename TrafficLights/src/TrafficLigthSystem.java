import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class TrafficLigthSystem implements Check {
    private static HashMap<Places_Be,HashMap<String,TrafficLight>> database_be;
    private static Scanner scan= new Scanner(System.in);

    public static void control_Panel(){
        LocalDateTime start = LocalDateTime.now();
        boolean flag = true;
        while (flag){
            menu();
            int option = intcheck();
            switch (option){
                case 1-> addTrafficLight();
                case 2-> deleteTrafficLight();
                case 3-> getTrafficLight();
                case 4-> updateTrafficLightState();
                case 5-> getTrafficLightsByLocation();
                case 6-> getAllTrafficLights();
                case 7-> CheckTraffocLigthStatus();
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

    private static void CheckTraffocLigthStatus() {

    }

    private static void getTrafficLightsByLocation() {

    }

    private static void getAllTrafficLights() {

    }

    private static void updateTrafficLightState() {

    }

    private static void getTrafficLight() {

    }

    private static void deleteTrafficLight() {

    }

    private static void addTrafficLight() {

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
