package algo;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import algo.structs.*;

abstract public class Algorithm {
    protected Set<String> visited;
    protected PriorityQueue<Node> pq;
    protected boolean foundSolution;
    protected long executionTime;

    public Algorithm() {
        this.visited = new HashSet<>();
        this.pq = new PriorityQueue<Node>((Node n1, Node n2) -> n1.getTotalCost() - n2.getTotalCost());
        this.foundSolution = false;
        this.executionTime = 0;
    }

    abstract public List<String> runSearch(String startWord, String endWord, Set<String> wordList);
    
    /** Returns execution time in ms */
    public long getExecutionTime() {
        return executionTime;
    }

    public int getNumberOfNodesVisited() {
        return visited.size();
    }

    public boolean isFoundSolution() {
        return foundSolution;
    }
}
