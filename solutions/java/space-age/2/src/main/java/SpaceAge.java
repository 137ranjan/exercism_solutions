import java.util.Map;
import java.util.HashMap;

class SpaceAge {

    private Map<String, Double> map;
    private double ageInSeconds;
    private static final double EARTH_YEAR_IN_SECONDS = 31557600d;
    SpaceAge(double seconds) {
        ageInSeconds = seconds;
        map = new HashMap<>();
        map.put("Mercury", 0.2408467);
        map.put("Venus", 0.61519726);
        map.put("Earth", 1.0);
        map.put("Mars", 1.8808158);
        map.put("Jupiter", 11.862615);
        map.put("Saturn", 29.447498);
        map.put("Uranus", 84.016846);
        map.put("Neptune", 164.79132);
    }

    double getSeconds() {
        return ageInSeconds;
    }

    double onEarth() {
        return ageInSeconds/(EARTH_YEAR_IN_SECONDS*map.get("Earth"));
    }

    double onMercury() {
          return ageInSeconds/(EARTH_YEAR_IN_SECONDS*map.get("Mercury"));
    }

    double onVenus() {
        return ageInSeconds/(EARTH_YEAR_IN_SECONDS*map.get("Venus"));
    }

    double onMars() {
        return ageInSeconds/(EARTH_YEAR_IN_SECONDS*map.get("Mars"));
    }

    double onJupiter() {
        return ageInSeconds/(EARTH_YEAR_IN_SECONDS*map.get("Jupiter"));
    }

    double onSaturn() {
        return ageInSeconds/(EARTH_YEAR_IN_SECONDS*map.get("Saturn"));
    }

    double onUranus() {
        return ageInSeconds/(EARTH_YEAR_IN_SECONDS*map.get("Uranus"));
    }

    double onNeptune() {
        return ageInSeconds/(EARTH_YEAR_IN_SECONDS*map.get("Neptune"));
    }

}
