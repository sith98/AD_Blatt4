import java.util.Arrays;

public class Aufgabe4 {
    
    private static void insertionSortRec(int[] numbers) {
        insertionSortRec(numbers, 1, 0, numbers[1]);
    }

    // j started bei i - 1 und läuft abwärts bis 0
    // sobald j 0 erreicht, wird i eins größer und läuft aufwärts bis n - 1
    // => Gaußsche Summenformel => O(n^2)
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

    // Merge Sort teilt Array erst in Teilarrays der Länge 1, dann 2, 4, 8, ...
    // Jedes Mal werden jeweils zwei nebeneinander liegende Teilarrays "gemergt"
    // Da Utils.merge beim i-ten Schleifenduchlauf in i Schritten in einem sortierten Teilarray resultiert,
    // enthält numbers nach i Schleifendurchläufen n / 2^i Teilarrays
    // Damit ist nach log(n) Schleifendurchläufen das Gesamtarray sortiert,
    // da es aus n / 2^log(n) = 1 Teilarrays besteht.
    // => O(n * log(n))
    private static void mergeSortIterative(int[] numbers) {
        var helper = new int[numbers.length];
        
        for (int step = 1; step < numbers.length; step *= 2) {
            for (int i = 0; i < numbers.length - step; i += step * 2) {
                int end = Math.min(i + step * 2, numbers.length);
                int middle = i + step;
                Utils.merge(numbers, i, end - 1, middle - 1, helper);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = Utils.getExampleArray();
        
        mergeSortIterative(arr);
        
        System.out.println(Arrays.toString(arr));
    }
    
}
