package org.example;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Введите номер task'а");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        switch (n) {
            case (1):
                System.out.println("Введите N для суммирования N рандомных int элементов массива");
                Task1.taskOneMain();
                break;
            case (2):
                System.out.println("Введите N для сортировки N рандомных double элементов массива");
                Task2.taskTwoMain();
                break;
            case (3):
                System.out.println("Отфильтруем сотрудников с ЗП > 100000");
                Task3.taskThreeMain();
                break;
            case (4):
                System.out.println("Получаем Host");
                Task4.taskFourMain();
                break;
            case (5):
                System.out.println("Ищем открытые порты");
                Task5.taskFiveMain();
                break;
            default:
                System.out.println("No such task");
                break;
        }
    }
}
