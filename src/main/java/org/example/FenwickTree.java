package org.example;

public class FenwickTree {
    private int[] tree;
    private int iterations = 0;

    public int getIterations() {
        return iterations;
    }

    public FenwickTree(int size) {
        this.tree = new int[size + 1];
    }

    public void add(int index, int value) {
        while (index < tree.length) {
            tree[index] += value;
            index += index & -index;
            iterations++;
        }
    }

    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
            iterations++;
        }
        return sum;
    }

    public void remove(int index, int value) {
        while (index < tree.length) {
            tree[index] -= value;
            index += index & -index;
            iterations++;
        }
    }
}