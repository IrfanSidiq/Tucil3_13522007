import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import algo.*;

public class AlgorithmHandler {
    private Set<String>[] dictionary;
    private List<String> solutionPath;
    private int numberOfNodesVisited;
    private boolean foundSolution;
    private long executionTime;

    public AlgorithmHandler(Set<String>[] dictionary) {
        this.solutionPath = new ArrayList<>();
        this.dictionary = dictionary;
        this.numberOfNodesVisited = 0;
        this.executionTime = 0;
    }

    public void run(String startWord, String endWord, int chosenAlgorithm) {
        Algorithm algo;
        switch (chosenAlgorithm) {
            case 1:
                System.out.println("\nMemulai pencarian dengan algoritma Uniform Cost Search...");
                algo = new UCS();
                break;
            case 2:
                System.out.println("\nMemulai pencarian dengan algoritma Greedy Best-First Search...");
                algo = new GreedyBFS();
                break;
            default:
                assert chosenAlgorithm == 3;
                System.out.println("\nMemulai pencarian dengan algoritma A*...");
                algo = new AStar();
                break;
        }

        this.solutionPath = algo.runSearch(startWord, endWord, dictionary[startWord.length()-1]);
        this.foundSolution = algo.isFoundSolution();
        this.numberOfNodesVisited = algo.getNumberOfNodesVisited();
        this.executionTime = algo.getExecutionTime();
    }

    public List<String> getSolutionPath() {
        return solutionPath;
    }

    public int getNumberOfSteps() {
        return solutionPath.size() - 1;
    }

    public int getNumberOfNodesVisited() {
        return numberOfNodesVisited;
    }

    public boolean isFoundSolution() {
        return foundSolution;
    }

    public long getExecutionTime() {
        return executionTime;
    }
}
