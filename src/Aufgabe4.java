import java.util.Arrays;
import java.util.stream.IntStream;

final class IntStack {
    private int[] stack = new int[10];
    private int size;
    
    final boolean isEmpty() {
        return this.size == 0;
    }
    
    
    final void push(int element) {
        if (this.size >= this.stack.length) {
            this.stack = Arrays.copyOf(this.stack, this.stack.length * 2);
        }
        
        this.stack[this.size] = element;
        this.size++;
    }
    
    final int peek() {
        return this.stack[this.size - 1];
    }
    
    final int pop() {
        int result = this.stack[this.size - 1];
        this.size--;
        return result;
    }
}

public class Aufgabe4 {
    
    private static void insertionSortRec(int[] numbers) {
        insertionSortRec(numbers, 1, 0, numbers[1]);
    }
    
    private static void insertionSortRec(int[] numbers, int i, int j, int value) {
        if (i >= numbers.length) {
            return;
        }
        if (!(j >= 0 && numbers[j] > value)) {
            numbers[j + 1] = value;
            
            if (i + 1 >= numbers.length) {
                return;
            }
            insertionSortRec(numbers, i + 1, i, numbers[i + 1]);
        } else {
            numbers[j + 1] = numbers[j];
            insertionSortRec(numbers, i, j - 1, value);
        }
    }
    
    private static void merge(int[] numbers, int start, int end, int middle, int[] helper) {
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
    
    private static void mergeSort(int[] numbers) {
        mergeSort(numbers, 0, numbers.length - 1, new int[numbers.length]);
    }
    
    private static void mergeSort(int[] numbers, int start, int end, int[] helper) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(numbers, start, middle, helper);
            mergeSort(numbers, middle + 1, end, helper);
            merge(numbers, start, end, middle, helper);
        }
    }
    
    private static void mergeSortIterative(int[] numbers) {
        var helper = new int[numbers.length];
        
        for (int step = 1; step < numbers.length; step *= 2) {
            for (int i = 0; i <= numbers.length - step; i += step * 2) {
                int end = Math.min(i + step * 2, numbers.length);
                int middle = i + step;
                merge(numbers, i, end - 1, middle - 1, helper);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {-5, 13, -32, 7, -3, 17, 23, 12, -35, 19};
        
        mergeSort(arr);
        
        System.out.println(Arrays.toString(arr));
    }
    
}
