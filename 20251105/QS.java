public class QuickSortProgram {

    /**
     * The main function that implements QuickSort.
     * @param arr The array to be sorted.
     * @param low The starting index.
     * @param high The ending index.
     */
    public static void quickSort(int[] arr, int low, int high) {
        // Base case: If the sub-array has 0 or 1 element, it's already sorted.
        if (low < high) {
            
            // pi is partitioning index, arr[pi] is now at the right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after the partition index
            quickSort(arr, low, pi - 1);  // Sorts the left sub-array
            quickSort(arr, pi + 1, high); // Sorts the right sub-array
        }
    }

    /**
     * This function takes the last element as the pivot, places the pivot 
     * element at its correct position in sorted array, and places all smaller
     * (smaller than pivot) to the left of pivot and all greater elements to 
     * the right of pivot.
     * @param arr The array segment to partition.
     * @param low The starting index of the segment.
     * @param high The ending index of the segment (where the pivot is located).
     * @return The final index of the pivot element.
     */
    private static int partition(int[] arr, int low, int high) {
        // Choose the pivot (we select the rightmost element)
        int pivot = arr[high]; 
        
        // Index of smaller element and indicates the correct position of pivot found so far
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++; // Increment index of smaller element
                
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // Swap arr[i+1] and arr[high] (put the pivot in its correct place)
        swap(arr, i + 1, high);

        return i + 1; // Return the partitioning index
    }
    
    /**
     * A utility function to swap two elements in an array.
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // --- Main Method for Demonstration ---
    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5, 3};
        int n = data.length;

        System.out.println("Original Array:");
        printArray(data);

        // Call Quick Sort
        quickSort(data, 0, n - 1);

        System.out.println("\nSorted Array:");
        printArray(data);
    }
    
    /**
     * A utility function to print the array.
     */
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}