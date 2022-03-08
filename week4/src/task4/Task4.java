package task4;

import java.util.HashMap;

public class Task4 {
    public static void main(String[] args) {
        String[] stringArr = {"a", "b", "a", "c", "d", "f", "a", "c"};

        HashMap<String, Integer> frequencies = new HashMap<>();

        for (String string : stringArr) {
            if (!frequencies.containsKey(string)) {
                frequencies.put(string, 1);
            } else {
                frequencies.put(string, frequencies.get(string) + 1);
            }
        }

        System.out.println("The number of distinct words: " + frequencies.size());
        for (String word : frequencies.keySet()) {
            if (frequencies.get(word) == 1) {
                System.out.println("Only one word of " + word);
                continue;
            }

            System.out.printf("There are %d words of %s\n", frequencies.get(word), word);
        }
    }
}
