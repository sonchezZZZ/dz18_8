package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnClassTest {
    OwnList subject;

    @BeforeEach
    public void setUp() {
        subject = new OwnList();
        subject.add(10);
        subject.add(11);
        subject.add(12);
        subject.add(13);
    }

    @Test
    public void createObjectTest() {
        OwnList underTest = new OwnList();
        int actual = underTest.size();
        int expected = 0;
        Assertions.assertEquals(expected, actual, "Size must be zero");
    }

    @Test
    public void getIndexByValueTest() {
        int[] actual = new int[]{0, 1, 2};
        int[] expected = new int[3];
        int value = 10;
        for (int i = 0; i < 3; i++) {
            expected[i] = subject.getIndexByValue(value + i);
        }
        Assertions.assertArrayEquals(expected, actual, "Indices must be equal");
    }

    @Test
    public void RemoveValueByIndexTest() {
        int expected = subject.getByIndex(2);
        subject.removeByIndex(1);
        int actual = subject.getByIndex(1);
        Assertions.assertEquals(expected, actual, "After deleting an element, the index has not shifted");
    }

    @Test
    public void getElementByIndexGreaterThanSize() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            subject.getByIndex(5);
        });
    }

    @Test
    public void sublistMethodShouldReturnSublist() {
        IntList actual = subject.subList(0, 2);
        int[] expected = new int[]{10, 11};
        Assertions.assertArrayEquals(expected, actual.toArray(), "SubList must be 10,11");
    }

    @Test
    public void getSizeTest() {
        int expected = 4;
        int actual = subject.size();
        Assertions.assertEquals(expected, actual, "Size must = 4");
    }

    @Test
    public void getCapacityTest() {
        int expected = 10;
        int actual = subject.capacity();
        Assertions.assertEquals(expected, actual, "Capacity must be 10 before increase array");
    }

    @Test
    public void containsMethodReturnTrue() {
        Assertions.assertTrue(subject.contains(10));
    }

    @Test
    public void containsMethodReturnFalse() {
        Assertions.assertFalse(subject.contains(25));
    }

    @Test
    public void toArrayMethodDontUpdateSubject() {
        int[] array = subject.toArray();
        array[0] = 99;
        int[] actual = subject.toArray();
        int[] expected = {10, 11, 12, 13};
        Assertions.assertArrayEquals(expected, actual, "Array must be 10 11 12 13");
    }

}
