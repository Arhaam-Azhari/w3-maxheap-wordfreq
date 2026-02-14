# W3 MaxHeap - WordFreq

## Description
This program stores survey phrases as WordFreq objects and builds a max-heap
based on frequency. A higher frequency represents higher priority in the heap.

The heap is constructed using the bottom-up buildMaxHeap method, which calls
maxHeapify starting from the last non-leaf node up to the root.

## Program Behavior
1. The initial array of survey phrases is created.
2. The array is printed before heap construction.
3. buildMaxHeap is called to enforce the max-heap property.
4. The heapified array is printed.

## How to Run
javac Main.java
java Main


## Concepts Used
- Max Heap
- Heapify
- Bottom-up heap construction
- Array-based binary heap representation