import java.time.LocalDate;

public class TrafficLight {
    private static String uniqecode_list= "1";
    private String uniqe_trafficlamp_code;

    private Places_Be provinces;
    private  TrafficLightState state;
    private  String statu;


    public TrafficLight( Places_Be provinces, TrafficLightState state) {
        setUniqe_trafficlamp_code();
        this.provinces = provinces;
        this.state = state;
        this.statu = "active";
    }



    private void setUniqe_trafficlamp_code() {
        this.uniqe_trafficlamp_code = uniqecode_list;
        uniqecode_list = String.valueOf(Integer.parseInt(uniqecode_list)+1);
    }



    private void setProvinces(Places_Be provinces) {
        this.provinces = provinces;
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }
    public void retire(){
        this.statu = "retired at "+ LocalDate.now();
    }

    public static String getUniqecode_list() {
        return uniqecode_list;
    }

    public String getUniqe_trafficlamp_code() {
        return uniqe_trafficlamp_code;
    }

    public Places_Be getProvinces() {
        return provinces;
    }

    public TrafficLightState getState() {
        return state;
    }

    public String getStatu() {
        return statu;
    }

    @Override
    public String toString() {
        if (statu.contains("retired"))  return  uniqe_trafficlamp_code+" lamp is "+statu;
        return
                " " + uniqe_trafficlamp_code +
                ": " + provinces +
                ": " + state +
                ": '" + statu;
    }
}
