package task1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();

        hashSet.add("Hello");
        hashSet.add("World");
        hashSet.add(new MyOwnClass());
        hashSet.add(new MyOwnClass());
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        System.out.println("\nDisplay with iterator: ");
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nDisplay with forEach: ");
//        hashSet.forEach(object -> System.out.println(object));
        hashSet.forEach(System.out::println); // the same as above

        String[] stringArr = {"hello", "hello", "world", "bye", "world"};
        Set<String> hashSetString = new HashSet<>(List.of(stringArr));
        List<String> duplicates = new ArrayList<>(List.of(stringArr));

        System.out.println("\nStrings in the set: ");
        for (String stringObj : hashSetString) {
            duplicates.remove(stringObj); // the remaining elements are duplicates
            System.out.println(stringObj);
        }

        System.out.println("\nDuplicate strings: ");
        for (String dup : duplicates) {
            System.out.println(dup);
        }
    }
}
