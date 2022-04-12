package fp.topic9.print;

import java.util.Random;
class SumThread extends Thread {
    private int[] arr;
    private int startIndex;
    private int endIndex;
    private double sum = 0;

    public SumThread(int[] arr, int startIndex, int endIndex) {
        this.arr = arr;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            sum += Math.sin(arr[i]);
        }
    }

    public double getSum() {
        return sum;
    }
}
public class Main {
    /**
     * Sum the sine of the elements of an array.
     *
     * @param arr array to sum
     * @return sum of the array's elements
     */
    public static double multiThreadTotal(int[] arr, int numThreads) {
        int len = arr.length;
        double sum = 0;
        // Create and start threads.
        SumThread[] threadArr = new SumThread[len];
        for (int i = 0; i < numThreads; i++) {
            int start = i * len / numThreads;
            int end = (i + 1) * (len / numThreads);
            if (i == numThreads - 1) {
                end = len;
            }

            threadArr[i] = new SumThread(arr, start, end);
            threadArr[i].start();
        }

        // Wait for the threads to finish and sum their results.
        for (int i = 0; i < numThreads; i++) {
            try {
                threadArr[i].join();
                sum += threadArr[i].getSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return sum;
    }

    // Method to calculate the sum of an array sequentially
    private static double sequentialTotal(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.sin((arr[i]));
        }
        return sum;
    }

    public static void main(String[] args) {
        Random r = new Random(32313);
        int[] arr = new int[5000000];

        // Initialize the array with random numbers.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }

        // Calculate the sum sequentially and take note of its execution time
        long timeBefore = 0;
        long seqTime = 0;
        double seqSum = 0;

        timeBefore = System.currentTimeMillis();
        seqSum = sequentialTotal(arr);
        seqTime = System.currentTimeMillis() - timeBefore;


        // Get the number of available processors for multi-threading
        int numThreads = Runtime.getRuntime().availableProcessors();

        double multiThreadSum = 0;
        long multiThreadTime = 0;
        System.out.println("Number of threads: " + numThreads);
        // Calculate the sum using multiple threads and take note of its execution time
        timeBefore = System.currentTimeMillis();
        multiThreadSum = multiThreadTotal(arr, numThreads);
        multiThreadTime = System.currentTimeMillis() - timeBefore;

        System.out.println("Sequential time = " + seqTime);
        System.out.println("Multi-threading time = " + multiThreadTime);

//     System.out.println(seqSum);
//     System.out.println(multiThreadedSum);

        //Compare the result
        if (Math.abs(seqSum - multiThreadSum) < 0.00001)
            System.out.println("Correct!!!");
    }
}