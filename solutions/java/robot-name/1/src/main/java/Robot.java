import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

class Robot {

    private static final Set<String> USED_NAMES = ConcurrentHashMap.newKeySet();
    private String name;

    Robot() {
        this.name = generateUniqueName();
    }

    String getName() {
        return name;
    }

    void reset() {
        this.name = generateUniqueName();
    }

    private String generateUniqueName() {
        String newName;
        do {
            newName = generateRandomName();
        } while (!USED_NAMES.add(newName));
        return newName;
    }

    private String generateRandomName() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        char firstLetter = (char) (random.nextInt(0, 26) + 'A');
        char secondLetter = (char) (random.nextInt(0, 26) + 'A');

        int number = random.nextInt(1000);
        return "" + firstLetter + secondLetter + String.format("%03d", number);
    }

}