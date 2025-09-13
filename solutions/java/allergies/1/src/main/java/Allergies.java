import java.util.ArrayList;
import java.util.List;

class Allergies {

    private final int score;

    Allergies(int score) {
        this.score = score & 0xFF;
    }

    boolean isAllergicTo(Allergen allergen) {
        return ((score & allergen.getScore()) != 0);
    }

    List<Allergen> getList() {
        List<Allergen> allergens = new ArrayList<>();
        for (Allergen allergen : Allergen.values()) {
            if (isAllergicTo(allergen)) {
                allergens.add(allergen);
            }
        }
        return allergens;
    }
}
