import java.util.*;

class RelativeDistance {

    private final Map<String, Set<String>> adjacency = new HashMap<>();

    RelativeDistance(Map<String, List<String>> familyTree) {
        // Build undirected graph from directed parent->children map
        for (Map.Entry<String, List<String>> entry : familyTree.entrySet()) {
            String parent = entry.getKey();
            List<String> children = entry.getValue();
            for (String child : entry.getValue()) {
                adjacency.computeIfAbsent(parent, k -> new HashSet<>()).add(child);
                adjacency.computeIfAbsent(child, k -> new HashSet<>()).add(parent);
            }

            // Sibling <-> sibling (all children of same parent are degree 1 apart)
            for (int i=0; i < children.size(); i++) {
                for (int j = i + 1; j < children.size(); j++) {
                    String a  = children.get(i);
                    String b = children.get(j);
                    adjacency.computeIfAbsent(a, k -> new HashSet<>()).add(b);
                    adjacency.computeIfAbsent(b, k -> new HashSet<>()).add(a);
                }
            }
        }
    }

    int degreeOfSeparation(String personA, String personB) {
        if (personA.equals(personB)) {
            return 0;
        }
        if (!adjacency.containsKey(personA) || !adjacency.containsKey(personB)) {
            return -1;
        }

        // BFS from personA, find the shortest path to personB
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();

        queue.add(personA);
        visited.put(personA, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDegree = visited.get(current);

            for (String neighbor : adjacency.getOrDefault(current, Set.of())) {
                if (neighbor.equals(personB)) {
                    return currentDegree + 1;
                }
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, currentDegree + 1);
                    queue.add(neighbor);
                }
            }
        }

        return -1; // no connection found
    }
}
