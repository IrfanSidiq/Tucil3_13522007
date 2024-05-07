package algo.structs;

import java.util.*;

public class Tree {
    // Hashmap tree with key = child, value = parent
    private Map<Node, Node> map;

    public Tree() {
        map = new HashMap<>();
    }

    public Tree(Tree other) {
        this.map = other.map;
    }

    public void set(Node child, Node parent) {
        map.put(child, parent);
    }

    public Node get(Node child) {
        return map.get(child);
    }

    public List<String> makePath(Node node) {
        List<String> path = new ArrayList<>();
        
        Node childNode = node;
        Node parentNode = map.get(node);
        
        String childWord = childNode.getWord();
        String parentWord = parentNode.getWord();
        path.add(childWord);

        while (!childWord.equals(parentWord)) {
            childNode = parentNode;
            parentNode = map.get(childNode);
            
            childWord = childNode.getWord();
            parentWord = parentNode.getWord();

            path.add(childWord);
        }

        return path;
    }
}
