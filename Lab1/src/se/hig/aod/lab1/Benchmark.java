package se.hig.aod.lab1;

import java.io.*;
import java.util.*;

/**
 * A benchmarking utility for measuring BinarySearchTree performance.
 * 
 * @author Matias Semere
 * @version 1.0
 */
public class Benchmark {
        /**
         * The main entry point for the benchmark application.
         * 
         * @param args command line arguments (not used)
         * @throws IOException if there's an error reading the data file
         */
        public static void main(String[] args) throws IOException {
                ArrayList<Integer> allData = null;
                try {
                        allData = loadListFromFile("Lab1/Data/unique_integers.txt");
                } catch (IOException e) {
                        System.err.println("Error loading data file: " + e.getMessage());
                        return;
                }
                // final int[] sizesToTry = {10_000, 20_000, 40_000, 80_000, 160_000, 320_000, 640_000, 1_280_000, 2_560_000};
                final int[] sizesToTry = {10_000, 20_000};
                double[] avgSizeTimes = new double[sizesToTry.length];
                int index = 0;

                for (int size : sizesToTry) {
                        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
                        
                        for (int i = 0; i < size; i++) {
                                tree.addElement(allData.get(i));
                        }
                        
                        int totalTime = 0;
                        // Collections.shuffle(allData);
                        Collections.sort(allData);

                        for (int i = 0; i < 3; i++) {
                                // System.out.println(i+1);
                            totalTime += benchmark(tree, allData);
                        }
                        avgSizeTimes[index] = totalTime / 3;
                        System.out.println("Size: " + size + " Avg time: " + avgSizeTimes[index++] + " ms");
                }
                
                System.out.println("Average times for different sizes:");
                for (int i = 0; i < sizesToTry.length-1; i++) {
                        System.out.println(avgSizeTimes[i+1] / avgSizeTimes[i]);
                }
                
        }
        
        /**
         * Performs a single benchmark iteration by searching for all elements.
         * 
         * @param tree the BinarySearchTree to perform searches on
         * @param allData the list of elements to search from
         * @return the total time in milliseconds taken to complete all searches
         */
        public static int benchmark(BinarySearchTree<Integer> tree, List<Integer> allData) {
                int totalTid = 0;
                
                long start = System.currentTimeMillis();
                for (int element : allData) {
                        tree.searchElement(element);
                }
                long end = System.currentTimeMillis();
                long sökningTid = end - start;
                totalTid += sökningTid;
                return totalTid;
        }

        /**
         * Loads a list of integers from a text file.
         * 
         * @param filename the path to the file containing integers, one per line
         * @return an ArrayList containing all successfully parsed integers from the file
         * @throws IOException if there's an error reading the file
         */
        private static ArrayList<Integer> loadListFromFile(String filename) throws IOException {
                ArrayList<Integer> data = new ArrayList<>();
                Scanner reader = new Scanner(new File(filename));
                String line;
                while (reader.hasNextLine()) {
                        line = reader.nextLine().trim();
                        if (!line.isEmpty()) {
                                try {
                                        data.add(Integer.parseInt(line));
                                } catch (NumberFormatException e) {}
                        }
                }
                reader.close();
                System.out.println("Loaded " + data.size() + " integers from " + filename + "\n");
                return data;
        }
}
