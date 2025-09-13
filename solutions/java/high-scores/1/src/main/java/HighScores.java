import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

class HighScores {

    private List<Integer> highScores;
    private Integer highest;
    private Integer lastAdded;
    private List<Integer> topThree;
    public HighScores(List<Integer> highScores) {
        this.highScores = new ArrayList<>(highScores);
        Collections.sort(highScores);
        this.highest = highScores.get(highScores.size() - 1);
        this.lastAdded = this.highScores.get(this.highScores.size()-1);
        this.topThree = new ArrayList<>();
        for(int i=highScores.size()-1; i >= 0 && i>highScores.size()-4; i--){
            topThree.add(highScores.get(i));
        }
    }

    List<Integer> scores() {
        return highScores;
    }

    Integer latest() {
        return lastAdded;
    }

    Integer personalBest() {
        return highest;
    }

    List<Integer> personalTopThree() {
        return topThree;
    }

}
