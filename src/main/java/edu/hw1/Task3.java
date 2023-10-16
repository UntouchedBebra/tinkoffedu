package edu.hw1;

import java.util.Arrays;

public class Task3 {
    private int[][] arrays;

    public Task3(int[] arr1, int[] arr2) {
        arrays = new int[2][];
        arrays[0] = arr1;
        arrays[1] = arr2;
    }

    public boolean arraysProcessing() {
        return (arrays[0] != null && arrays[1] != null)
               &&
               (arrays[0].length > 0 && arrays[1].length > 0)
               &&
               (
                   Arrays.stream(arrays[0]).min().getAsInt() > Arrays.stream(arrays[1]).min().getAsInt()
               )
               &&
               (
                   Arrays.stream(arrays[0]).max().getAsInt() < Arrays.stream(arrays[1]).max().getAsInt()
               );
    }

}

