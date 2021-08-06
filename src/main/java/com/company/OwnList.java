package com.company;

public class OwnList implements IntList {

    int[] list = new int[10];
    int top = -1;

    public void add(int i) {
        top++;
        if (top == list.length - 1) {
            increaseArray();
        }
        list[top] = i;

    }

    //    вставим в индекс, все остальное сдвинем вправо
    @Override
    public void insert(int index, int value) {
        int[] spareList = list.clone();
        if (top == list.length - 1) {
            increaseArray();
        }
        if (index <= top) {
            list[index] = value;
            top++;
            for (int i = index + 1; i <= top; i++) {
                list[i] = spareList[i - 1];
            }

        }
    }

    //
    @Override
    public void set(int index, int value) {
        if (index <= top) {
            list[index] = value;
        }

    }

    public int size() {
        return top + 1;
    }

    @Override
    public int capacity() {
        return list.length;
    }


    //    получаем значение ячейки по индексу
    @Override
    public int getByIndex(int index) throws ArrayIndexOutOfBoundsException{
        if (index <= top) {
            return list[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index out of massive size");
        }

    }

    // или индекс, или нул возвращаем
    @Override
    public Integer getIndexByValue(int value) {
        Integer index = null;
        for (int i = 0; i <= top; i++) {
            if (value == list[i]) {
                index = i;
                break;
            }
        }

        return index;
    }

    @Override
    public boolean contains(int value) {
        boolean result = false;
        for (int i = 0; i <= top; i++) {
            if (value == list[i]) {
                result = true;
                break;
            }
        }
        return result;

    }

    //ищем элемент и удалим его (все что справа сдвигается влево)
    @Override
    public void removeValue(int value) {
        int index = 0;
        for (int i = 0; i <= top; i++) {
            if (value == list[i]) {
                index = i;
                deleteIndex(index);
                break;
            }
        }


    }

    @Override
    public void removeByIndex(int index) {
        if (index <= top) {
            deleteIndex(index);
        }


    }

    // вернуть объект класса OwnList which implements IntList
//    создать новый инлист, и его вернуть
//    IntList sub = new IntListImpl();
//    add elements from arrays
    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList sub = new OwnList();
        for (int i = fromIndex; i < toIndex; i++) {
            sub.add(list[i]);
        }
        return sub;

    }

    // нужно вернуть массив, как вариант с помощью дополнительного массива
    @Override
    public int[] toArray() {
        int[] array = new int[top + 1];
        System.arraycopy(list, 0, array, 0, top + 1);
        return array;
    }

    private void increaseArray() {
        int[] spareList = new int[top + top / 2];
        System.arraycopy(list, 0, spareList, 0, list.length);
        list = spareList;
    }

    private void deleteIndex(int index) {
        if (index < top) {
            for (int j = index; j < top; j++) {
                list[j] = list[j + 1];
            }
            top--;
        } else if (index == top) {
            top--;
        }

    }
}
