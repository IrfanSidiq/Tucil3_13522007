package algo;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import algo.structs.*;
import algo.util.Calculator;

public class AStar extends Algorithm {
    public AStar() {
        super();
    }

    @Override
    public List<String> runSearch(String startWord, String endWord, Set<String> wordList) {
        Instant start = Instant.now();

        if (startWord.equals(endWord)) {
            Instant end = Instant.now();
            this.executionTime = Duration.between(start, end).toMillis();
            foundSolution = true;

            return Arrays.asList(startWord);
        }

        int wordLength = startWord.length();
        Tree searchTree = new Tree();
        Node startNode = new Node(startWord, 0, Calculator.calculateDistance(startWord, endWord));
        Node solutionNode = null;
        Node currentNode = startNode;

        pq.add(startNode);
        searchTree.set(startNode, startNode);

        while (!pq.isEmpty()) {
            currentNode = pq.poll();

            String currentWord = currentNode.getWord();
            if (visited.contains(currentWord)) {
                continue;
            }
            if (currentWord.equals(endWord)) {
                solutionNode = currentNode;
                foundSolution = true;
                if (pq.peek().getTotalCost() == solutionNode.getTotalCost())
                    break;
            }
            
            for (int i = 0; i < wordLength; i++)
            {
                StringBuilder searchWord = new StringBuilder(currentWord);
                for (int j = 0; j < 26; j++)
                {
                    char c = (char) ((int)'a' + j);
                    if (currentWord.charAt(i) == c)
                    {
                        continue;
                    }

                    searchWord.setCharAt(i, c);
                    
                    if (!visited.contains(searchWord.toString()) && wordList.contains(searchWord.toString()))
                    {
                        int heuristicValue = Calculator.calculateDistance(searchWord.toString(), endWord);
                        Node searchNode = new Node(searchWord.toString(), currentNode.getGCost() + 1, heuristicValue);
                        pq.add(searchNode);
                        searchTree.set(searchNode, currentNode);
                    }
                }
            }

            visited.add(currentWord);
        }

        List<String> foundPath;
        if (foundSolution) {
            foundPath = searchTree.makePath(solutionNode);  
        } else {
            foundPath = searchTree.makePath(currentNode);
        }
        Collections.reverse(foundPath);

        Instant finish = Instant.now();
        executionTime = Duration.between(start, finish).toMillis();
        
        return foundPath;
    }
}
