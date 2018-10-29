public class Aufgabe3 {
    
    private static void heapify(int[] numbers, int rootIndex, int endIndex) {
        int leftChildIndex = rootIndex * 2 + 1;
        int rightChildIndex = rootIndex * 2 + 2;
        
        int root = numbers[rootIndex];
        
        if (leftChildIndex > endIndex) {
            // no children
            return;
        }
        
        int leftChild = numbers[leftChildIndex];
        if (rightChildIndex > endIndex) {
            // Only left child exists
            if (root < leftChild) {
                Utils.swap(numbers, rootIndex, leftChildIndex);
            }
        } else {
            // Both children exist
            int rightChild = numbers[rightChildIndex];
            if (root < rightChild && leftChild < rightChild) {
                // right child is the largest
                Utils.swap(numbers, rootIndex, rightChildIndex);
                heapify(numbers, rightChildIndex, endIndex);
            } else if (root < leftChild) {
                // left child is the largest
                Utils.swap(numbers, rootIndex, leftChildIndex);
                heapify(numbers, leftChildIndex, endIndex);
            }
        }
    }

    private static void betterHeapify(int[] numbers, int rootIndex, int endIndex) {
        int leftChildIndex = rootIndex * 2 + 1;
        int rightChildIndex = rootIndex * 2 + 2;

        int largest = rootIndex;
        if (leftChildIndex <= endIndex & numbers[leftChildIndex] > numbers[largest]) {
            largest = leftChildIndex;
        }
        if (rightChildIndex <= endIndex & numbers[rightChildIndex] > numbers[largest]) {
            largest = rightChildIndex;
        }
        if (largest != rootIndex) {
            Utils.swap(numbers, largest, rootIndex);
        }
    }
    
    private static void heapSort(int[] numbers) {
        int endIndex = numbers.length - 1;
        
        int firstIndexWithChildren = (endIndex - 1) / 2;
        
        // build heap
        for (int i = firstIndexWithChildren; i >= 0; i--) {
            betterHeapify(numbers, i, endIndex);
        }
        Utils.printArray(numbers);
        while (endIndex > 0) {
            Utils.swap(numbers, 0, endIndex);
            endIndex -= 1;
            heapify(numbers, 0, endIndex);
            Utils.printArray(numbers);
        }
    }
    
    private static void mergeSort(int[] numbers) {
        Utils.printArray(numbers);
        mergeSort(numbers, 0, numbers.length - 1, new int[numbers.length]);
    }
    
    private static void mergeSort(int[] numbers, int start, int end, int[] helper) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(numbers, start, middle, helper);
            mergeSort(numbers, middle + 1, end, helper);
            Utils.merge(numbers, start, end, middle, helper);
            Utils.printArray(numbers);
        }
    }
    
    public static void main(String[] args) {
        var array = Utils.getExampleArray();
        heapSort(array);
        Utils.printArray(array);
    }
}
