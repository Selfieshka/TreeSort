package ru.kpfu.itis.kirillakhmetov.work;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BinaryTreeTest {

    @Test
    void testSort() throws IOException {
        FileReader fileReader = new FileReader("InputData.txt");
        Scanner scanner = new Scanner(fileReader);
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            BinaryTree tree = new BinaryTree();
            List<Integer> listElems = new ArrayList<>();
            String[] line = scanner.nextLine()
                    .replace("\n", "")
                    .split(" ");

            for (String str : line) {
                Integer elem = Integer.parseInt(str);
                listElems.add(elem);
                tree.add(elem);
            }

            List<Integer> sorted = tree.sort();

            Assertions.assertArrayEquals(listElems.stream().sorted().toArray(), sorted.toArray());
        }

        fileReader.close();
    }

    @Test
    void testEmptyTreeException() {
        BinaryTree tree = new BinaryTree();
        Assertions.assertThrows(EmptyTreeException.class, tree::sort);
    }

    @Test
    void testOneElemTreeSort() {
        BinaryTree tree = new BinaryTree();
        List<Integer> list = new ArrayList<>();
        list.add(5);
        tree.add(5);
        Assertions.assertArrayEquals(list.toArray(), tree.sort().toArray());
    }

    @Test
    void testAddNullElem() {
        BinaryTree tree = new BinaryTree();
        Assertions.assertThrows(NullPointerException.class, () -> tree.add(null));
    }

    @Test
    void testDuplicateElementException() {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(7);
        tree.add(13);
        tree.add(1);
        tree.add(4);
        Assertions.assertThrows(DuplicateElementException.class, () -> tree.add(5));
    }
}
