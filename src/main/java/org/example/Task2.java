package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    private final ArrayList<Double> numbers;

    public Task2(int n) {
        numbers = getArrayWithRandomDoubleNumbers(n);
    }

    public static void taskTwoMain() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Task2 randomArraySorter = new Task2(n);
        randomArraySorter.printOriginalAndSortedArray();
    }

    public ArrayList<Double> getArrayWithRandomDoubleNumbers(int n) {
        Random random = new Random();
        var newArr = new ArrayList<Double>(n);
        for (int i = 0; i < n; i++) {
            newArr.add(random.nextDouble());
        }
        return newArr;
    }

    public void insertionSort(ArrayList<Double> arrayToSort) {
        for (int i = 1; i < arrayToSort.size(); i++) {
            double current = arrayToSort.get(i);
            int j = i - 1;

            while (j >= 0 && arrayToSort.get(j) > current) {
                arrayToSort.set(j + 1, arrayToSort.get(j));
                j--;
            }
            arrayToSort.set(j + 1, current);
        }
    }

    public void printOriginalAndSortedArray() {
        System.out.println("Original List: " + numbers);

        ArrayList<Double> sortedNumbers = new ArrayList<>(numbers);
        insertionSort(sortedNumbers);
        System.out.println("Sorted List: " + sortedNumbers);
    }
}