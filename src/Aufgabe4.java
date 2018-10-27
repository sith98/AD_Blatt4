import java.util.Arrays;

public class Aufgabe4 {
    
    private static void insertionSortRec(int[] numbers) {
        insertionSortRec(numbers, 1, 0, numbers[1]);
    }
    
    private static void insertionSortRec(int[] numbers, int i, int j, int value) {
        if (i < numbers.length) {
            if (0 <= j && numbers[j] > value) {
                numbers[j + 1] = numbers[j];
                insertionSortRec(numbers, i, j - 1, value);
            } else {
                numbers[j + 1] = value;
                if (i + 1 < numbers.length) {
                    insertionSortRec(numbers, i + 1, i, numbers[i + 1]);
                }
            }
        }
    }
    
    private static void mergeSortIterative(int[] numbers) {
        var helper = new int[numbers.length];
        
        for (int step = 1; step < numbers.length; step *= 2) {
            for (int i = 0; i <= numbers.length - step; i += step * 2) {
                int end = Math.min(i + step * 2, numbers.length);
                int middle = i + step;
                Utils.merge(numbers, i, end - 1, middle - 1, helper);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {-5, 13, -32, 7, -3, 17, 23, 12, -35, 19};
        
        insertionSortRec(arr);
        
        System.out.println(Arrays.toString(arr));
    }
    
}
