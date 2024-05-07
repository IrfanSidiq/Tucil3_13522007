package algo.structs;

public class Node {
    private String word;    
    private int g;             // Cost up until reaching this word
    private int h;             // Heuristic cost
    private int totalCost;

    /** Creates a new node to be expanded.
     * @param word  Word by which the node represent.
     * @param g The g(x) value of reaching the word.
     * @param h The h(x) heuristic value of the word.
    */
    public Node(String word, int g, int h) {
        this.word = word;
        this.g = g;
        this.h = h;
        this.totalCost = g + h;
    }

    public String getWord() {
        return word;
    }

    public int getGCost() {
        return g;
    }

    public int getHCost() {
        return h;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
