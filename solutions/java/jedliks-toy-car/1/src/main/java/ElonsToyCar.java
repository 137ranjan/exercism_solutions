public class ElonsToyCar {
    
    private int distance = 0;
    private int battery = 100;
    
    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + distance + " meters";
    }

    public String batteryDisplay() {
        if(battery > 0){
            return "Battery at " + battery + "%";
        }
        return "Battery empty";
    }

    public void drive() {
        if(battery > 0){
            distance += 20;
            battery -= 1;
        }
    }
}
