package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        recurseMass(array, 0);

        OwnList list = new OwnList();
        for (int i = 0; i <= 20; i++) {
            list.add(i);
        }
        String a = Arrays.toString(list.toArray());
        System.out.println(a);


    }

    public static void recurseMass(int[] array, int start) {
        if (start == array.length - 1) {
            System.out.print(array[start]);
            return;
        } else {
            System.out.print(array[start] + ",");
            start++;
            recurseMass(array, start);
        }
    }


}
