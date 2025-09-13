public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        if(speed >=0 && speed <=4){
            return (speed * 221);
        }
        if(speed >=5 && speed <=8){
            return ((speed * 221) * 0.9); 
        }
        if(speed == 9){
            return ((speed * 221) * 0.8);
        }
        else{
            return ((speed * 221) * 0.77);
        }
    }

    public int workingItemsPerMinute(int speed) {
        int ratePerHour = (int)productionRatePerHour(speed);
        return ratePerHour/60;
    }
}
