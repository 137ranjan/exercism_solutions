import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class KindergartenGarden {

    private final Map<String, List<Plant>> studentPlants = new HashMap<>();
    private static final String[] STUDENT_NAMES = {
        "Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph",
        "Kincaid","Larry"
    };
    KindergartenGarden(String garden) {
        this(garden, STUDENT_NAMES);
    }

    KindergartenGarden(String garden, String[] students){
        String[] rows = garden.split("\n");
        if (rows.length != 2){
            throw new IllegalArgumentException("Garden must have tow rows.");
        }
        String row1 = rows[0];
        String row2 = rows[1];

        List<String> sortedStudents = new ArrayList<>(Arrays.asList(students));
        sortedStudents.sort(String::compareTo);

        int numberOfStudents = sortedStudents.size();
        int cupsPerStudent = 2;
        
        for (int i = 0; i<numberOfStudents; i++){
            String studentName = sortedStudents.get(i);
            List<Plant> plants = new ArrayList<>();

            int startIndex = i * cupsPerStudent;

            if(startIndex < row1.length()){
                plants.add(Plant.getPlant(row1.charAt(startIndex)));
            }
            if(startIndex + 1 < row1.length()){
                plants.add(Plant.getPlant(row1.charAt(startIndex + 1)));
            }
            if(startIndex < row2.length()){
                plants.add(Plant.getPlant(row2.charAt(startIndex)));
            }
            if(startIndex + 1 < row2.length()){
                plants.add(Plant.getPlant(row2.charAt(startIndex + 1)));
            }
            studentPlants.put(studentName, plants);
        }       
    }

    List<Plant> getPlantsOfStudent(String student) {
        return studentPlants.get(student);
    }

}
