package edu.hw3;

import java.util.ArrayDeque;
import java.util.ArrayList;

public final class Task2 {

    private Task2() {

    }

    public static ArrayList<String> getBalancedClustersPointers(String messyBrackets) {

        ArrayList<String> clustersStore = new ArrayList<>();

        int clusterBalance = 0;

        int startIndexOfCluster = 0;
        int endIndexOfCluster = 0;

        for (char bracket : messyBrackets.toCharArray()) {
            clusterBalance = (bracket == '(') ? ++clusterBalance : --clusterBalance;
            endIndexOfCluster++;
            if (clusterBalance == 0) {
                clustersStore.add(messyBrackets.substring(startIndexOfCluster, endIndexOfCluster));
                startIndexOfCluster = endIndexOfCluster;
            }
        }

        return clustersStore;
    }

    public static ArrayList<String> getBalancedClustersStack(String messyBrackets) {
        ArrayDeque<Character> bracketStack = new ArrayDeque<>();

        ArrayList<String> clustersStore = new ArrayList<>();
        StringBuilder newCluster = new StringBuilder();


        for (char bracket : messyBrackets.toCharArray()) {
            if (bracket == '(') {
                bracketStack.push(bracket);
            } else {
                bracketStack.pop();
            }

            newCluster.append(bracket);

            if (bracketStack.isEmpty()) {
                clustersStore.add(newCluster.toString());
                newCluster = new StringBuilder();
            }

        }
        return clustersStore;
    }

}
