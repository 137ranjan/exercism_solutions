import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Collections;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return cards.stream().collect(Collectors.toSet());
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        boolean flag1 = false, flag2 = false;
        for(String s: myCollection){
            if(!theirCollection.contains(s)){
                flag1 = true;
                break;
            }
        }
        for(String s: theirCollection){
            if(!myCollection.contains(s)){
                flag2 = true;
                break;
            }
        }
        return flag1 && flag2;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        if(collections == null || collections.isEmpty()){
            return Collections.emptySet();
        }
        Set<String> common = new HashSet<>(collections.get(0));
        for(Set<String> collection: collections){
            common.retainAll(collection);
        }
        return common;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        return collections.stream().flatMap(Set::stream).collect(Collectors.toSet());
    }
}
