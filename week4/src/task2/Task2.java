package task2;

import java.util.TreeSet;

public class Task2 {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(new StringComparator());

        treeSet.add("hello");
        treeSet.add("world");
        treeSet.add("hi");
        treeSet.add("bye");
        treeSet.add("good morning");

        System.out.println("Strings in TreeSet: ");
        for (String str : treeSet) {
            System.out.println(str);
        }
    }
}
