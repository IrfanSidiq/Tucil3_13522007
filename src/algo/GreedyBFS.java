package algo;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import algo.structs.*;
import algo.util.Calculator;

public class GreedyBFS extends Algorithm {
    public GreedyBFS() {
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

        pq.add(startNode);
        searchTree.set(startNode, startNode);
        Node currentNode = startNode;

        while (!pq.isEmpty()) {
            currentNode = pq.poll();
            pq.clear();

            String currentWord = currentNode.getWord();
            if (visited.contains(currentWord)) {
                continue;
            }

            for (int i = 0; i < wordLength; i++)
            {
                StringBuilder searchWord = new StringBuilder(currentWord);
                for (int j = 0; j < 26; j++)
                {
                    char c = (char) ((int)'a' + j);
                    if (currentWord.charAt(i) == c) {
                        continue;
                    }

                    searchWord.setCharAt(i, c);
                    if (searchWord.toString().equals(endWord)) {
                        solutionNode = new Node(endWord, 0, 0);
                        searchTree.set(solutionNode, currentNode);
                        foundSolution = true;
                        break;
                    }

                    if (!visited.contains(searchWord.toString()) && wordList.contains(searchWord.toString())) {
                        int heuristicValue = Calculator.calculateDistance(searchWord.toString(), endWord);
                        Node searchNode = new Node(searchWord.toString(), 0, heuristicValue);
                        pq.add(searchNode);
                        searchTree.set(searchNode, currentNode);
                    }
                }

                if (foundSolution) {
                    break;
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
