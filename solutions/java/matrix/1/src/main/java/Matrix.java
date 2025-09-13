import java.util.List;
import java.util.ArrayList;

class Matrix {

    private List<List<Integer>> matrix;
    
    Matrix(String matrixAsString) {
        List<List<Integer>> mat = new ArrayList<>();
        this.matrix = mat;
        String[] rowArr = matrixAsString.split("\n");
        for (String row : rowArr) {
            List<Integer> rowList = new ArrayList<>();
            String[] intArr = row.split(" ");
            for (String item : intArr) {
                rowList.add(Integer.parseInt(item));
            }
            this.matrix.add(rowList);
        }
    }

    int[] getRow(int rowNumber) {
        int size = matrix.get(rowNumber - 1).size();
        int[] result = new int[size];
        for(int i=0; i<size; i++){
            result[i] = matrix.get(rowNumber - 1).get(i);
        }
        return result;
    }

    int[] getColumn(int columnNumber) {
        List<Integer> resultList = new ArrayList<>();
        for(int i=0; i<matrix.size() ; i++){
            resultList.add(matrix.get(i).get(columnNumber - 1));
        }
        int size = resultList.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = resultList.get(i).intValue();
        }
        return result;
    }
}
