import java.util.Arrays;

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

    private static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int value = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > value) {
                numbers[j + 1] = numbers[j];
                j -= 1;
            }
            numbers[j + 1] = value;
        }
    }

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

    public static void main(String[] args) {
        int[] arr = {-5, 13, -32, 7, -3, 17, 23, 12, -35, 19};

        insertionSortRec(arr);

        System.out.println(Arrays.toString(arr));
    }

}
