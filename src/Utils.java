import java.util.Arrays;
import java.util.Random;

class Utils {
    
    static void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
    
    // end is inclusive, middle is inclusive end of first half
    static void merge(int[] numbers, int start, int end, int middle, int[] helper) {
        int leftIndex = start;
        int rightIndex = middle + 1;
        for (int i = start; i <= end; i++) {
            if (leftIndex > middle) {
                helper[i] = numbers[rightIndex++];
            } else if (rightIndex > end) {
                helper[i] = numbers[leftIndex++];
            } else {
                if (numbers[leftIndex] <= numbers[rightIndex]) {
                    helper[i] = numbers[leftIndex++];
                } else {
                    helper[i] = numbers[rightIndex++];
                }
            }
        }
        System.arraycopy(helper, start, numbers, start, end + 1 - start);
    }
    
    static int[] getExampleArray() {
        return new int[]{-5, 13, -32, 7, -3, 17, 23, 12, -35, 19};
    }
    
    static int[] getRandomArray(int n) {
        int[] arr = new int[n];
        var random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }

        return arr;
    }
    
    static long testSortingAlgorithm(int[] arr, SortingAlgorithm algorithm) {
        long before = System.currentTimeMillis();
        algorithm.sort(arr);
        long after = System.currentTimeMillis();
        return after - before;
    }
    
    static void printArray(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }
}
