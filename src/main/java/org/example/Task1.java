package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    private final ArrayList<Integer> numbers;

    public Task1(int n) {
        numbers = getArrayWithRandomIntNumbers(n);
    }

    public static void taskOneMain() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Task1 randomArraySum = new Task1(n);
        randomArraySum.printArrayAndSum();
    }

    public ArrayList<Integer> getArrayWithRandomIntNumbers(int n) {
        Random random = new Random();
        var newArr = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++) {
            newArr.add(random.nextInt());
        }

        return newArr;
    }

    public long getPositiveSum(ArrayList<Integer> arrayToSum) {
        long sum = 0;

        for (int number : arrayToSum) {
            if (number > 0) {
                sum += number;
            }
        }
        return sum;
    }

    public void printArrayAndSum() {
        System.out.println("Array: " + numbers);
        System.out.println("Sum of positive numbers: " + getPositiveSum(numbers));
    }
}
