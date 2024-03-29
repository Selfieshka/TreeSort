package ru.kpfu.itis.kirillakhmetov.work;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        generateInputData();
//        generateOutputData();
    }

    public static void generateInputData() throws IOException {
        FileWriter file = new FileWriter("InputData.txt", false);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            Integer[] array = generateRandomIntArray(random.nextInt(9901) + 100);
            for (Integer el : array) {
                file.append(Integer.toString(el)).append(" ");
            }
            file.append("\n");
        }

        file.close();
    }

    public static void generateOutputData() throws IOException {
        FileReader fileReader = new FileReader("InputData.txt");
        FileWriter fileWriter = new FileWriter("OutputData.txt", false);
        Scanner scanner = new Scanner(fileReader);
        long timeStart;
        long timeEnd;

        fileWriter.append("Input")
                .append(" ")
                .append("Iterations")
                .append(" ")
                .append("Time(ns)")
                .append("\n");
        fileWriter.flush();

        while (scanner.hasNextLine()) {
            BinaryTree tree = new BinaryTree();
            String[] line = scanner.nextLine()
                    .replace("\n", "")
                    .split(" ");

            timeStart = System.nanoTime();
            for (String str : line) {
                tree.add(Integer.parseInt(str));
            }

            tree.sort();
            timeEnd = System.nanoTime();

            fileWriter.append(Integer.toString(tree.getSize()))
                    .append(" ")
                    .append(Integer.toString(tree.getNumberIterations()))
                    .append(" ")
                    .append(Long.toString(timeEnd - timeStart))
                    .append("\n");
            fileWriter.flush();
        }

        fileWriter.close();
        fileReader.close();
    }

    private static Integer[] generateRandomIntArray(int size) {
        Integer[] array = new Integer[size];
        Set<Integer> generatedNumbers = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int num = random.nextInt();
            while (generatedNumbers.contains(num)) {
                num = random.nextInt();
            }
            array[i] = num;
            generatedNumbers.add(num);
        }

        return array;
    }
}