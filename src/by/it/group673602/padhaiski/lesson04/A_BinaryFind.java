package by.it.group673602.padhaiski.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
В первой строке источника данных даны:
        - целое число 1<=n<=100000 (размер массива)
        - сам массив A[1...n] из n различных натуральных чисел,
          не превышающих 10E9, в порядке возрастания,
Во второй строке
        - целое число 1<=k<=10000 (сколько чисел нужно найти)
        - k натуральных чисел b1,...,bk не превышающих 10E9 (сами числа)
Для каждого i от 1 до kk необходимо вывести индекс 1<=j<=n,
для которого A[j]=bi, или -1, если такого j нет.
        Sample Input:
        5 1 5 8 12 13
        5 8 1 23 1 11
        Sample Output:
        3 1 -1 1 -1
(!) Обратите внимание на смещение начала индекса массивов JAVA относительно условий задачи
*/

public class A_BinaryFind {
    int[] findIndex(InputStream stream) throws FileNotFoundException {
        Scanner scanner = new Scanner(stream);
        int n = scanner.nextInt(); // size of array
        int[] a=new int[n]; // array
        for (int i = 1; i <= n; i++) {
            a[i-1] = scanner.nextInt();
        }

        int k = scanner.nextInt(); // size of index array
        int[] result=new int[k];
        for (int i = 0; i < k; i++) {
            int value = scanner.nextInt();
            result[i] = binarySearch(a, 0, a.length-1, value);
        }
        return result;
    }

    private int binarySearch(int[] array, int first, int last, int value) {
        int position;
        position = (first + last)/2;
        while ((array[position]!=value) && first<=last){
            if(array[position] > value){
                last = position-1;
            }
            else{
                first = position + 1;
            }
            position = (first + last)/2;
        }
        if(first<=last){
            return ++position;
        }
        return -1;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group673602/prakhotsky/lesson04/dataA.txt");
        A_BinaryFind instance = new A_BinaryFind();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.findIndex(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}