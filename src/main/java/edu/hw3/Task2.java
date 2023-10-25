package edu.hw3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public final class Task2 {

    private Task2() {

    }

    public static ArrayList<String> getBalancedClustersStack(String messyBrackets) {
        if (isStringValid(messyBrackets)) {
            ArrayDeque<Character> bracketStack = new ArrayDeque<>();

            ArrayList<String> clustersStore = new ArrayList<>();
            StringBuilder newCluster = new StringBuilder();

            for (char bracket : messyBrackets.toCharArray()) {
                if (bracket == '(') {
                    bracketStack.push(bracket);
                } else {
                    try {
                        bracketStack.pop();
                    } catch (NoSuchElementException exception) {
                        throw new RuntimeException("Кластеризация невозможна", exception);
                    }
                }

                newCluster.append(bracket);

                if (bracketStack.isEmpty()) {
                    clustersStore.add(newCluster.toString());
                    newCluster = new StringBuilder();
                }

            }
            return clustersStore;
        } else {
            throw new RuntimeException("Невалидная строка");
        }
    }

    private static boolean isStringValid(String inputString) {
        return inputString != null && !inputString.isEmpty() && stringContainsOnlyRoundBrackets(inputString);
    }

    private static boolean stringContainsOnlyRoundBrackets(String inputString) {
        for (char symbol : inputString.toCharArray()) {
            if (symbol != '(' && symbol != ')') {
                return false;
            }
        }
        return true;
    }

}
