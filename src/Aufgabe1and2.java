import java.util.Random;

public class Aufgabe1and2 {
    
    
    /**
     * Laufzeit (Worst Case):
     * T(n) = (n - 1) * n/2 = O(n^2)
     */
    private static void insertionSortBackwards(int[] numbers) {
        // Baue den sortierten Teil des Arrays auf der rechten Seite auf
        // Sortiere beim ersten Durchlauf das vorletzte Element ein, dann das vorvorletzte, ...
        for (int i = numbers.length - 2; i >= 0; i--) {
            int value = numbers[i];
            // Gehe durch alle Zahlen auf der rechten Seite des einzusortierenden Elementes
            // Fahre fort, bis das Ende des Arrays
            // oder die korrekte Position für die aktuelle Zahl gefunden erreicht wurde
            int j = i + 1;
            while (j < numbers.length && numbers[j] < value) {
                // Kopiere jede Zahl zur Position zu ihrer Linken
                numbers[j - 1] = numbers[j];
                j += 1;
            }
            // Füge die aktuelle Zahl ein
            numbers[j - 1] = value;
        }
    }
    
    /**
     * Laufzeit (Worst Case):
     * T(n) = (n + 1) * n / 2 = O(n^2)
     */
    private static void bubbleSortBackwards(int[] numbers) {
        // Beim ersten Durchlauf alle Elemente, dann alle bis auf das letzte, ...
        for (int end = numbers.length; end >= 0; end--) {
            // Gehe durch das Array von links nach rechts
            for (int i = 0; i < end - 1; i++) {
                // Vertausche zwei nebeneinander liegende Elemente, wenn sie falsch herum liegen
                if (numbers[i] > numbers[i + 1]) {
                    Utils.swap(numbers, i, i + 1);
                }
            }
        }
    }
    
    /**
     * Laufzeit (Worst Case):
     * T(n) = (n + 1) * n / 2 = O(n^2)
     */
    private static void selectionSortBackwards(int[] numbers) {
        // Füge jeweils das aktuell größte Element des nicht bereits sortierten Teil des Arrays ein
        for (int i = numbers.length - 1; i >= 0; i--) {
            int largestIndex = i;
            // Fined die höchste Zahl
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[largestIndex]) {
                    largestIndex = j;
                }
            }
            // Bewege sie ans Ende
            Utils.swap(numbers, i, largestIndex);
        }
    }
    
    private static Random random = new Random();
    
    private static void quickSortRandom(int[] numbers) {
        quickSortRandom(numbers, 0, numbers.length - 1);
    }
    
    
    // Funktioniert prinzipiell genau wie in der Vorlesung (Mit konstant vielen extra Schritten pro Durchlauf)
    /**
     * Laufzeit (Worst Case):
     * T(n) = O(n^2)
     * Laufzeit (Average Case):
     * T(n) = O(n * log(n))
     */
    private static void quickSortRandom(int[] numbers, int start, int end) {
        if (end - start < 1) {
            return;
        }
        int pivotIndex = random.nextInt(end - start + 1) + start;
        int pivot = numbers[pivotIndex];
        // Setze Pivot an den Anfang (einzige, neu hinzugekommene Zeile)
        Utils.swap(numbers, start, pivotIndex);
        int endSmaller = start;
        for (int i = start + 1; i <= end; i++) {
            if (numbers[i] < pivot) {
                endSmaller += 1;
                Utils.swap(numbers, i, endSmaller);
            }
        }
        // Setze Pivot an die richtige Stelle
        Utils.swap(numbers, start, endSmaller);
        quickSortRandom(numbers, start, endSmaller - 1);
        quickSortRandom(numbers, endSmaller + 1, end);
    }
    
    public static void main(String[] args) {
        final int N = 500_000_000;
//        long millis = Utils.testSortingAlgorithm(Utils.getRandomArray(N), Aufgabe1and2::quickSortRandom);
        final int N2 = 900_000;
        long millis2 = Utils.testSortingAlgorithm(Utils.getRandomArray(N2), Aufgabe1and2::insertionSortBackwards);
        System.out.println(millis2);
    }
}
