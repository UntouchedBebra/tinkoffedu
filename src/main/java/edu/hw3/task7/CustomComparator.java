package edu.hw3.task7;

import com.sun.source.tree.Tree;
import java.util.Comparator;
import java.util.TreeMap;

public class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return 0;
        } else if (s1 == null) {
            return -1;
        } else if (s2 == null) {
            return 1;
        } else {
            return s1.compareTo(s2);
        }
    }

    public static void main(String[] args) {
        //TreeMap<String, Integer> treeMap = new TreeMap<>();

        TreeMap<String, Integer> treeMap = new TreeMap<>(new CustomComparator());
        treeMap.put(null, 0);

        System.out.println(treeMap.get(null));

        treeMap.put(null, 1000);
        System.out.println(treeMap.get(null));
    }
}
