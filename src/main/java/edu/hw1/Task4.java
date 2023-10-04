package edu.hw1;

public class Task4 {
    private final String initialString;

    public Task4(String initialString) {
        this.initialString = initialString;
    }

    public String fixString() {
        if (!initialString.isEmpty()
            && initialString != null) {
            char[] symbolsArray = initialString.toCharArray();
            char bucket;
            for (int i = 0; i < initialString.length() - 1; ) {
                swap(symbolsArray, i, i + 1);
                i += 2;
            }
            return new String(symbolsArray);
        } else {
            return null;
        }
    }

    private void swap(char[] arr, int ind1, int ind2) {
        char bucket = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = bucket;
    }

}
