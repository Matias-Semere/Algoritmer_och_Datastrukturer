package se.hig.aod.lab3;

import java.util.*;

public class SortingTest {
        public static void main(String[] args) {
                int[] arr = {4, 8, 1, 5, 1, 9, 2, 3, 7};

                List<Integer> inputList = new ArrayList<Integer>();
                
                for (int i = 0; i < arr.length; i++) {
                        inputList.add(arr[i]);
                }

                long start = System.currentTimeMillis();
                List<Integer> sortedList = HeapSorter.sort(inputList);
                System.out.println(System.currentTimeMillis() - start + "ms");

                System.out.println("Input array: " + inputList);
                System.out.println("Sorted array: " + sortedList);
        }
        
}
