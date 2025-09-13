import java.util.List;
import java.util.ArrayList;

class Flattener {

    <T> List<T> flatten(List<T> list) {
        List<T> flattenedList = new ArrayList<>();

        for(T element: list){
            if(element instanceof List){
                flattenedList.addAll(flatten((List<T>) element));
            }else if(element != null){
                flattenedList.add(element);
            }
        }

        return flattenedList;
    }

}