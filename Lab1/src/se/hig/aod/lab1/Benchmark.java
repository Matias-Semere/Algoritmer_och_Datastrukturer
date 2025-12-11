package se.hig.aod.lab1;

import java.io.*;
import java.util.*;

public class Benchmark {

        public static void main(String[] args) throws IOException {
                ArrayList<Integer> allData = null;
                try {
                        allData = loadListFromFile("Lab1/Data/unique_integers.txt");
                } catch (IOException e) {
                        System.err.println("Error loading data file: " + e.getMessage());
                        return;
                }
                int[] sizesToTry = {10_000, 20_000, 40_000, 80_000, 160_000, 320_000, 640_000, 1_280_000, 2_560_000};      
                for (int size : sizesToTry) {
                        size = Math.min(size, allData.size());
                        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
                        for (int i = 0; i < size; i++) {
                                tree.addElement(allData.get(i));
                        }
                        int totalTidFörVarjeSize = 0;
                        for (int i = 0; i < 10; i++) {
                                totalTidFörVarjeSize += benchmark(allData, size);
                        }
                }

        }

        public static int benchmark(List<Integer> list, int size) {
                int sökningTid = 0;
                long start = System.currentTimeMillis();


                
                
                long end = System.currentTimeMillis();
                return sökningTid;

        }

        private static ArrayList<Integer> loadListFromFile(String filename) throws IOException {
                ArrayList<Integer> data = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(filename));

                String line = reader.readLine();

                while (line != null) {
                        line = line.trim();
                        if (!line.isEmpty()) {
                                try {
                                        data.add(Integer.parseInt(line));
                                } catch (NumberFormatException e) {
                                }
                        }
                        line = reader.readLine();
                }
                reader.close();
                System.out.println("Loaded " + data.size() + " integers from " + filename + "\n");
                return data;
        }
}
