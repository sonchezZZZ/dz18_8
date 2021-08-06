package com.company;

public interface IntList {
    void add(int i);

    /**
     * git remote add origin git@github.com:sonchezZZZ/dz8.git
     */
    void insert(int index, int value);

    /**
     * Overwrite value by index
     */
    void set(int index, int value);

    /**
     * @return actual number of elements in the list
     */
    int size();

    /**
     * @return how many elements list can contain
     */
    int capacity();

    int getByIndex(int index);

    /**
     * @return index of first value occurrence. Return null if no value in the list.
     */
    Integer getIndexByValue(int value);

    boolean contains(int value);

    void removeValue(int value);

    void removeByIndex(int index);

    IntList subList(int fromIndex, int toIndex);

    int[] toArray();
}
