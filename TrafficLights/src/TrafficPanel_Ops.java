import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Locale;
import java.util.Scanner;

public class TrafficPanel_Ops {
    public static Scanner scan = new Scanner(System.in);

    public static void CheckTraffocLigthStatus(HashMap<Places_Be, HashMap<String, TrafficLight>> database_be) {


        TrafficLight trf_ligth = select_Traffic_Light(database_be);
        System.out.println("Traffic light statu (" + trf_ligth.getUniqe_trafficlamp_code() + ") is " + trf_ligth.getState());


    }


    public static void getTrafficLightsByLocation(HashMap<Places_Be, HashMap<String, TrafficLight>> database_be) {

        Places_Be place = provinceToSelect(database_be);
        System.out.println();
        System.out.println("The available ids are: ");

        System.out.println("you have selected all status of the all traficligts in " + place + " : ");
        for (String id : database_be.get(place).keySet()) {
            System.out.print(database_be.get(place).get(id).getUniqe_trafficlamp_code() + " is " + database_be.get(place).get(id).getStatu() + " : ");
        }
    }

    public static void getAllTrafficLights(HashMap<Places_Be, HashMap<String, TrafficLight>> database_be) {
        System.out.println("you have selected to see all  traffic ligths : ");
        System.out.println();
        for (Places_Be place : database_be.keySet()) {
            for (String id : database_be.get(place).keySet()) {
                System.out.print(database_be.get(place).get(id).getUniqe_trafficlamp_code() + " is " + database_be.get(place).get(id).getStatu() + " : ");
            }
        }
    }

    public static void updateTrafficLightState(HashMap<Places_Be, HashMap<String, TrafficLight>> database_be) {
        TrafficLight selectedtf = select_Traffic_Light(database_be);
        System.out.println("enter the  trafficlightstate to update the current " + selectedtf.getUniqe_trafficlamp_code());
        TrafficLightState lightState = TrafficLightState.valueOf(scan.next());
        selectedtf.setState(lightState);
        System.out.println("the traffic-light (" + selectedtf.getUniqe_trafficlamp_code() + ") is updated to " + lightState);
    }

    private static TrafficLight select_Traffic_Light(HashMap<Places_Be, HashMap<String, TrafficLight>> databaseBe) {
        Places_Be place = provinceToSelect(databaseBe);
        System.out.println();
        System.out.println("The available ids are: ");
        for (String id : databaseBe.get(place).keySet()) {
            System.out.print(id + " ");
        }
        System.out.println();
        System.out.print("enter the unique traffic id : ");
        String option = scan.next();
        return databaseBe.get(place).get(option);

    }

    public static void getTrafficLight(HashMap<Places_Be, HashMap<String, TrafficLight>> database_be) {
        TrafficLight selected = select_Traffic_Light(database_be);
        System.out.println("the traffic-light (" + selected.getUniqe_trafficlamp_code() + ") is " + selected.getStatu());
    }

    public static void deleteTrafficLight(HashMap<Places_Be, HashMap<String, TrafficLight>> database_be) {
        TrafficLight selectedtodel = select_Traffic_Light(database_be);
        System.out.println("pls enter the province once again");
        Places_Be place = provinceToSelect(database_be);
        boolean is_progressed = false;
        for (String id : database_be.get(place).keySet()) {
            if (id.equalsIgnoreCase(selectedtodel.getUniqe_trafficlamp_code())) {
                database_be.get(place).remove(id);
                is_progressed = true;
                return;
            }
        }

        System.out.println("we couldnt find the id \n (couldn't match the province and trafficligt");
        deleteTrafficLight(database_be);

    }

    public static void addTrafficLight(HashMap<Places_Be, HashMap<String, TrafficLight>> database_be) {
        System.out.println("please select province: ");
        Places_Be place = provinceToSelect(database_be);
        System.out.println("please select statu: ");
        for (TrafficLightState statu : TrafficLightState.values()) System.out.print( statu.ordinal()+". "+statu);
        TrafficLightState  state = TrafficLightState.valueOf(scan.next().toUpperCase());

        TrafficLight tf_new = new TrafficLight(place,state);
        HashMap<String, TrafficLight> keydata = new HashMap<>();
        keydata.put(tf_new.getUniqe_trafficlamp_code(),tf_new);
        database_be.put(place,keydata);
        System.out.println("successfully saved");
    }


    public static Places_Be provinceToSelect(HashMap<Places_Be, HashMap<String, TrafficLight>> database_be) {
        System.out.print("Please enter the locations available are : ");
        for (Places_Be place : database_be.keySet()) {
            System.out.print(place + " ");
        }
        System.out.println();
        System.out.print("enter the name:");
        return Places_Be.valueOf(scan.next().toUpperCase());

    }
}
