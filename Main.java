// CS151 W3 Assignment - Max Heap Construction using Word Frequencies
public class Main {

    /*
     * WordFreq represents one survey phrase and the number of times
     * it appears in the data. The frequency determines priority
     * in the max-heap (higher frequency = higher priority).
     */
    static class WordFreq {
        String word;
        int frequency;

        // Constructor to initialize phrase and its frequency
        WordFreq(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        /*
         * toString() is overridden so printing the object shows
         * readable output instead of memory addresses.
         * Example: "happy"(400)
         */
        @Override
        public String toString() {
            return "\"" + word + "\"(" + frequency + ")";
        }
    }

    /*
     * BUILD-MAX-HEAP
     *
     * Converts an unsorted array into a max-heap.
     * A max-heap ensures that every parent node has
     * a frequency greater than or equal to its children.
     *
     * We start from the last non-leaf node and move upward
     * because leaf nodes already satisfy the heap property.
     */
    // buildMaxHeap constructs the max heap using bottom-up heapification,
// starting from the last non-leaf node up to the root.
    static void buildMaxHeap(WordFreq[] heap) {
        int n = heap.length;

        // Last non-leaf node is at index (n/2) - 1
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(heap, n, i);
        }
    }

    /*
     * MAX-HEAPIFY
     *
     * Ensures the subtree rooted at index i satisfies
     * the max-heap property.
     *
     * If one of the children has a larger frequency than
     * the parent, we swap and recursively fix the subtree.
     */
    // maxHeapify compares a parent with its children and restores
// the max-heap property if the parent is smaller than a child.
    static void maxHeapify(WordFreq[] heap, int heapSize, int i) {

        // Left and right child indices in array representation
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Assume current index is largest initially
        int largest = i;

        // Check if left child exists and has larger frequency
        if (left < heapSize &&
            heap[left].frequency > heap[largest].frequency) {
            largest = left;
        }

        // Check if right child exists and has larger frequency
        if (right < heapSize &&
            heap[right].frequency > heap[largest].frequency) {
            largest = right;
        }

        /*
         * If largest is not the parent, swap the parent
         * with the larger child and continue heapifying
         * the affected subtree.
         */
        if (largest != i) {
            swap(heap, i, largest);
            maxHeapify(heap, heapSize, largest);
        }
    }

    /*
     * Swaps two elements in the array.
     * Used when heap property is violated.
     */
    static void swap(WordFreq[] heap, int i, int j) {
        WordFreq temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /*
     * Utility method to print the array with indices.
     * Helps visualize heap structure after heap construction.
     */
    static void printArray(WordFreq[] heap) {
        for (int i = 0; i < heap.length; i++) {
            System.out.println(i + ": " + heap[i]);
        }
    }

    public static void main(String[] args) {

        /*
         * Step 1:
         * Create array of WordFreq objects using the
         * survey phrases and frequencies provided
         * in the assignment.
         */
        WordFreq[] survey = new WordFreq[] {
                new WordFreq("happy", 400),
                new WordFreq("satisfied", 100),
                new WordFreq("neutral", 300),
                new WordFreq("would buy again", 200),
                new WordFreq("terrible", 160),
                new WordFreq("inconvenient", 900),
                new WordFreq("difficult to use", 100),
                new WordFreq("easy to use", 140),
                new WordFreq("would recommend to friends", 800),
                new WordFreq("visit the store", 700)
        };

        // Print original array before heap construction
        System.out.println("=== Before heapify ===");
        printArray(survey);

        /*
         * Step 2:
         * Convert array into a max-heap using
         * bottom-up heap construction.
         */
        buildMaxHeap(survey);

        // Print array after heapify to show heap order
        System.out.println("\n=== After buildMaxHeap (heapified order) ===");
        printArray(survey);
    }
}
