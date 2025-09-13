public class Lasagna {
    // TODO: define the 'expectedMinutesInOven()' method
    public int expectedMinutesInOven(){
        return 40;
    }

    // TODO: define the 'remainingMinutesInOven()' method
    public int remainingMinutesInOven(int minutes){
        return expectedMinutesInOven() - minutes;
    }

    // TODO: define the 'preparationTimeInMinutes()' method
    public int preparationTimeInMinutes(int num){
        return 2*num;
    }

    // TODO: define the 'totalTimeInMinutes()' method
    public int totalTimeInMinutes(int num, int minutes){
        return preparationTimeInMinutes(num) + minutes;
    }
}
