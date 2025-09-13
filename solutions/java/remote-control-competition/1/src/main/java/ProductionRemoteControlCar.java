class ProductionRemoteControlCar implements Comparable<ProductionRemoteControlCar>,RemoteControlCar{
    private int distanceTravelled = 0;
    private int numberOfVictories;
    public void drive() {
        distanceTravelled += 10;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar car){
        return  car.getNumberOfVictories() - this.getNumberOfVictories();
    }
}
