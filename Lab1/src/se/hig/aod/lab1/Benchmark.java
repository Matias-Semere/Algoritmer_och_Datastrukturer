package se.hig.aod.lab1;

import java.io.*;
import java.util.*;

public class Benchmark {
        public static void main(String[] args) {
                ArrayList<Integer> allData = null;
                try {
                        allData = loadDataFromFile("Lab1/Data/unique_integers.txt");
                } catch (IOException e) {
                        System.err.println("Error loading data file: " + e.getMessage());
                        return;
                }

                String l = "%-10s|";

                System.out.printf(l + l + l + " (Time in nanosecounds)\n", "Size", "BST     ", "ArrayList");

        }

        private static ArrayList<Integer> loadDataFromFile(String filename) throws IOException {
                ArrayList<Integer> data = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(filename));

                String line = reader.readLine();

                while (line != null) {
                        line = line.trim();
                        if (!line.isEmpty()) {
                                try {
                                        data.add(Integer.parseInt(line));
                                } catch (NumberFormatException e) {}
                        }
                        line = reader.readLine();
                }
                reader.close();
                System.out.println("Loaded " + data.size() + " integers from " + filename + "\n");
                return data;
        }
}
