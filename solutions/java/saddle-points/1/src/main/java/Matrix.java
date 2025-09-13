import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
 
class Matrix {
 private List<List<Integer>> matrix;
    Matrix(List<List<Integer>> values) {
        this.matrix = values;
    }
    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> result = new HashSet<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            indexes = getMaxInRow(row);
            for (int index : indexes) {
                if (isMinInColumn(index, row)){
                    MatrixCoordinate cell = new MatrixCoordinate(i + 1, index + 1);
                    result.add(cell);
                }
            }
        }
        return result;
    }
    private ArrayList<Integer> getMaxInRow(List<Integer> row) {
        ArrayList<Integer> result = new ArrayList<>();
        int current = row.get(0);
        for (int it : row) {
            if (it > current)
                current = it;
        }
        for (int i = 0; i < row.size(); i++) {
            if (row.get(i) == current){
                result.add(i);
            }
        }
        return result;
    }
    private boolean isMinInColumn(int index, List<Integer> row) {
        for (List<Integer> that : this.matrix) {
            if (row.get(index) > that.get(index))
                return false;
        }
        return true;
    }
}
