class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int distanceDriven;
    private int battery;
    
    // TODO: define the constructor for the 'NeedForSpeed' class
    public NeedForSpeed(int speed, int batteryDrain){
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.distanceDriven = 0;
        this.battery = 100;
    }
    public boolean batteryDrained() {
        if(battery == 0){
            return true;
        }
        return false;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        if(!batteryDrained()){
            distanceDriven += speed;
            battery -= batteryDrain;
        }    
    }

    public static NeedForSpeed nitro() {
        NeedForSpeed nitroCar = new NeedForSpeed(50,4);
        return nitroCar;
    }
}

class RaceTrack {
    int distance;
    
    // TODO: define the constructor for the 'RaceTrack' class
    public RaceTrack(int distance){
        this.distance = distance;
    }
    
    public boolean tryFinishTrack(NeedForSpeed car) {
        while(car.distanceDriven() < distance && car.batteryDrained() == false){
            car.drive();
        }
        if(car.distanceDriven() < distance && car.batteryDrained() == true){
            return false;
        }else{
            return true;
        }
    }
}
