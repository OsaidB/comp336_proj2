package com.example.comp336_proj2;

public class MinHeap {

    private TreeNode[] heap;
    private int size;
    private int capacity;

    public MinHeap() {
        this(1);
    }
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new TreeNode[capacity]; // Index 0 is not used for simplicity
        //The   (parent) of a node at index (i) is located at   { index i/2 }
        //The   (left child) is at                              { index 2*i }
        //The   (right child) is at                             { index 2*i + 1 }
    }

    public void insert(TreeNode treeNode) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert more elements.");
            return;
        }
//
//        size++;//make array (heap) bigger
////        heap[size] = treeNode;  //storing the new element in the next available position
//
//        int currentIndex = size;
//
//        int newFrequency=treeNode.frequency;
//        int parentFrequency=heap[currentIndex / 2].frequency;
//
//        while ((currentIndex > 1) && (newFrequency < parentFrequency)) {
//            heap[currentIndex]=heap[currentIndex / 2];
//            currentIndex /= 2;
//
////            swap(currentIndex, currentIndex / 2);   //swap current with parent
//
//
////            newFrequency=heap[currentIndex].frequency;
//            parentFrequency=heap[currentIndex / 2].frequency;
//        }
//        heap[currentIndex]=treeNode;

        int i = ++size;

        while ((i > 1) && treeNode.frequency < heap[i / 2].frequency) {

            heap[i] = heap[i / 2];
            i /= 2;

        }
        heap[i] = treeNode;
    }

    public TreeNode extractMin() {//get minimum element
        if (size == 0) {
            System.out.println("Heap is empty.");
            return null; // Assuming null is not a valid element in the heap
        }
//
//        TreeNode min = heap[1];
//
//        heap[1] = heap[size];
//        size--;
////        TreeNode last = heap[size--];
//
//        // Heapify down
//        int currentIndex = 1;//to compare it with its children
//        boolean flag=true;
//        while (flag) {
//
//            int leftChild = 2 * currentIndex;
//            int rightChild = 2 * currentIndex + 1;
//
//            int smallest = currentIndex;
//            ///////////////////////////////////
//            //1
//            int leftChildFrequency=heap[leftChild].frequency;
//
//            if ((leftChild <= size) && leftChildFrequency < heap[smallest].frequency) {
//                smallest = leftChild;
//            }
//            ///////////////////////////////////
//            //2
//            int rightChildFrequency=heap[rightChild].frequency;
//
//            if (rightChild <= size && rightChildFrequency < heap[smallest].frequency) {
//                smallest = rightChild;
//            }
//            ///////////////////////////////////
//            //3
//            if (smallest != currentIndex) {//swapping with the smallest child
//                swap(currentIndex, smallest);
//                currentIndex = smallest;
//            } else {
//                flag=false;
//            }
//            ///////////////////////////////////
//
//        }
//
//        return min;
        int child, i;

        TreeNode last, min = null;


        if (size != 0) {


            min = heap[1];
            last = heap[size--];
            for (i = 1; i * 2 <= size; i = child) {

                child = i * 2;
                if (child < size && heap[child].frequency > heap[child + 1].frequency)
                    child++;
                if (last.frequency > heap[child].frequency)
                    heap[i] = heap[child];
                else
                    break;
            }
            heap[i] = last;


        }
        return min;

    }

    private void swap(int i, int j) {
        TreeNode temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


    public TreeNode[] getHeapArray() {
        TreeNode[] ret = new TreeNode[size + 1];

        for (int i = 0; i < size + 1; i++)
            ret[i] = heap[i];

        return ret;
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i].treeChar + " ");
        }
        System.out.println();
    }


}
