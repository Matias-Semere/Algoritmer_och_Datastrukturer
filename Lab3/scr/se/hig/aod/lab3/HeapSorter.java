package se.hig.aod.lab3;

import java.util.ArrayList;
import java.util.List;

public class HeapSorter {

        public static <T extends Comparable<? super T>> List<T> sort(List<T> inputList) {
                HeapPriorityQueue<T> heap = new HeapPriorityQueue<T>(inputList.size());

                for (T element : inputList) {
                        heap.enqueue(element);
                }

                List<T> sortedList = new ArrayList<T>();

                while (!heap.isEmpty()) {
                        sortedList.add(heap.dequeue());
                }


                return sortedList;
        }

}
