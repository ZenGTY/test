package org.hospital.util;

import java.util.Random;

/**
 * Created by pismery on 2017-10-21.
 */
public class Test {

    public static void main(String[] args) {

        //所有排序从小到大
        int[] arr = randomArray(1, 10000, 10000);
        printArray(arr);

        for (int i = 0; i < 10; i++) {
            //bubbleSort1(arr);
            // bubbleSort2(arr);
           // bubbleSort3(arr);
           // selectionSort(arr);
            insertionSort(arr);
            insertionSort2(arr);
            System.out.println();
        }

    }


    /**
     * 插入排序
     * @param arr
     */
    public static void insertionSort2(int[] arr) {
        int[] array = getNewArray(arr);

        long startTime = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i -1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
            //printArray(array);
        }
        long endTime = System.nanoTime();
       // printArray(array);
        System.out.println("插入排序2 时间：" + (endTime - startTime) + "ns");
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        int[] array = getNewArray(arr);

        long startTime = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] >= temp) {
                    array[j + 1] = array[j];
                    array[j] = temp;
                }else {
                    array[j + 1] = temp;
                    break;
                }
            }
            //printArray(array);
        }
        long endTime = System.nanoTime();
       // printArray(array);
        System.out.println("插入排序1 时间：" + (endTime - startTime) + "ns");
    }

    /**
     * 选择排序算法
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        int[] array = getNewArray(arr);

        long startTime = System.nanoTime();
        int temp;
        int index;
        for (int i = 0; i < array.length - 1; i++) {
            index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        long endTime = System.nanoTime();
        //printArray(array);
        System.out.println("选择排序 时间：" + (endTime - startTime) + "ns");

    }

    /**
     * 冒泡排序法改良版3 ：--- 每趟排序只要比较到上一趟排序最后交换的位置
     *
     * @param arr
     */
    public static void bubbleSort3(int[] arr) {
        int[] array = getNewArray(arr);

        long startTime = System.nanoTime();
        int postion = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            int endIndex = 0;
            for (int j = 0; j < postion; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    endIndex = j;
                }
            }
            if (endIndex == 0) {
                break;
            }
            postion = endIndex;
        }

        long endTime = System.nanoTime();
        // printArray(array);
        System.out.println("改进版冒泡排序2 时间：" + (endTime - startTime) + "ns");
    }

    /**
     * 冒泡排序改良版 当一次循环没有任何移动则排序完毕；
     *
     * @param arr
     * @return
     */
    public static void bubbleSort2(int[] arr) {
        int[] array = getNewArray(arr);

        long startTime = System.nanoTime();
        boolean isEnd;
        for (int i = 0; i < array.length - 1; i++) {
            isEnd = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isEnd = false;
                }
            }
            if (isEnd) {
                break;
            }
        }
        long endTime = System.nanoTime();
        // printArray(array);
        System.out.println("改进版冒泡排序1 时间：" + (endTime - startTime) + "ns");
    }

    /**
     * 冒泡排序普通版
     *
     * @param arr
     */
    public static void bubbleSort1(int[] arr) {

        int[] array = getNewArray(arr);

        long startTime = System.nanoTime();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        // printArray(array);
        System.out.println("普通冒泡排序时间：" + (endTime - startTime) + "ns");
    }

    public static int[] randomArray(int min, int max, int n) {
        int len = max - min + 1;

        if (max < min || n > len) {
            return null;
        }
        // 初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min + len; i++) {
            source[i - min] = i;
        }
        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            // 待选数组0到(len-2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            // 将随机到的数放入结果集
            result[i] = source[index];
            // 将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }

    public static int randomInt(int min, int max) {
        int result = 0;
        if (max < min) {
            return -1;
        }
        Random rd = new Random();
        result = rd.nextInt(max - min + 1) + min;
        return result;
    }

    public static void printArray(int[] array) {
        System.out.print("array = [");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.println(array[i] + "]");
            } else {
                System.out.print(array[i] + ",");
            }

        }
    }

    public static int[] getNewArray(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
}
