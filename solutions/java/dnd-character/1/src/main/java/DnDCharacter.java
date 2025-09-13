import java.util.List;
import java.util.ArrayList;

class DnDCharacter {

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;

    DnDCharacter(){
        strength = ability(rollDice());
        dexterity = ability(rollDice());
        constitution = ability(rollDice());
        intelligence = ability(rollDice());
        wisdom = ability(rollDice());
        charisma = ability(rollDice());
        hitpoints = 10 + modifier(constitution);
    }
    int ability(List<Integer> scores) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int score : scores){
            if(score < min){
                min = score;
            }
            sum += score;
        }
        return sum - min;
    }

    List<Integer> rollDice() {
        List<Integer> scores = new ArrayList<>();
        int max = 6;
        int min = 1;
        for(int i=0; i<4; i++){ 
            scores.add(min + (int)(Math.random()*((max - min) + 1)));
        } 
        return scores;
    }

    int modifier(int input) {
        return (int)Math.floor((input - 10)/2.0);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hitpoints;
    }
}
