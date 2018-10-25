import java.util.Arrays;
import java.util.Random;

interface SortingAlgorithm {
    void sort(int[] numbers);
}

public class Aufgabe1and2 {
    private static void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    private static void insertionSortBackwards(int[] numbers) {
        for (int i = numbers.length - 2; i >= 0; i--) {
            int value = numbers[i];
            int j = i + 1;
            while (j < numbers.length && numbers[j] < value) {
                numbers[j - 1] = numbers[j];
                j += 1;
            }
            numbers[j - 1] = value;
        }
    }

    private static void bubbleSortBackwards(int[] numbers) {
        for (int end = numbers.length; end >= 0; end--) {
            for (int i = 0; i < end - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    swap(numbers, i, i + 1);
                }
            }
        }
    }

    private static void selectionSortBackwards(int[] numbers) {
        for (int i = numbers.length - 1; i >= 0; i--) {
            int largestIndex = i;
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[largestIndex]) {
                    largestIndex = j;
                }
            }
            swap(numbers, i, largestIndex);
        }
    }

    private static Random random = new Random();

    private static void quickSortRandom(int[] numbers) {
        quickSortRandom(numbers, 0, numbers.length - 1);
    }

    private static void quickSortRandom(int[] numbers, int start, int end) {
        if (end - start < 1) {
            return;
        }
        int pivotIndex = random.nextInt(end - start + 1) + start;
        int pivot = numbers[pivotIndex];
        // move pivot to the start
        swap(numbers, start, pivotIndex);
        int endSmaller = start;
        for (int i = start + 1; i <= end; i++) {
            if (numbers[i] < pivot) {
                endSmaller += 1;
                swap(numbers, i, endSmaller);
            }
        }
        // put pivot at the right place
        swap(numbers, start, endSmaller);
        quickSortRandom(numbers, start, endSmaller - 1);
        quickSortRandom(numbers, endSmaller + 1, end);
    }

    private static int[] getExampleArray() {
        return new int[]{-5, 13, -32, 7, -3, 17, 23, 12, -35, 19};
    }

    private static long testSortingAlgorithm(int[] arr, SortingAlgorithm algorithm) {
        long before = System.currentTimeMillis();
        algorithm.sort(arr);
        long after = System.currentTimeMillis();
        return after - before;
    }

    private static int[] getRandomArray(int n) {
        int[] arr = new int[n];
        var random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }

        return arr;
    }

    public static void main(String[] args) {
        final int N = 510_000_000;
        long millis = testSortingAlgorithm(getRandomArray(N), Aufgabe1and2::quickSortRandom);
        System.out.println(millis);
    }
}
