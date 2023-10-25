package edu.hw3.task8;

import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private final List<T> store;
    private int pointer;

    public BackwardIterator(List<T> store) {
        this.store = store;
        pointer = this.store.size() - 1;
    }

    @Override public boolean hasNext() {
        return pointer > -1;
    }

    @Override public T next() {
            return store.get(pointer--);
    }
}
