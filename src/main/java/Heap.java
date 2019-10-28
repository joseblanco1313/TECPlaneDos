//
public class Heap extends Pasajero{

    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public Heap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    // Function to return the position of 
    // the parent for the node currently 
    // at pos 
    private int parent(int pos) {
        return pos / 2;
    }

    // Function to return the position of the 
    // left child for the node currently at pos 
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Function to return the position of 
    // the right child for the node currently 
    // at pos 
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Function that returns true if the passed 
    // node is a leaf node 
    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Function to swap two nodes of the heap 
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Function to heapify the node at pos 
    private void minHeapify(int pos) {

        // If the node is a non-leaf node and greater 
        // than any of its child 
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)]
                    || Heap[pos] > Heap[rightChild(pos)]) {

                // Swap with the left child and heapify 
                // the left child 
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } // Swap with the right child and heapify 
                // the right child 
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    // Function to insert a node into the heap 
    public void insert(Pasajero element) {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element.getnumero_prioridad();
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int insert_dos(int element) {
 
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        return element;
    }

    // Function to print the contents of the heap 
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    // Function to build the min heap using 
    // the minHeapify 
    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    // Function to remove and return the minimum 
    // element from the heap 
    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        System.out.println("Borrado : " + popped);
        return popped;

    }
    
    public int ELIMINAR(){
        int eliminado = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        System.out.println("BORRADO: " + eliminado);
        return eliminado;
    }

    public int numero() {

        int num = Heap[FRONT];
        minHeapify(FRONT);
        return num;
    }

    public void sort(int arrA[]) {
        int size = arrA.length;

        // Build heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arrA, size, i);
        }

        // One by one extract (Max) an element from heap and
        // replace it with the last element in the array
        for (int i = size - 1; i >= 0; i--) {

            //arrA[0] is a root of the heap and is the max element in heap
            int x = arrA[0];
            arrA[0] = arrA[i];
            arrA[i] = x;

            // call max heapify on the reduced heap
            heapify(arrA, i, 0);
        }
    }

    public void heapify(int arrA[], int heapSize, int i) {
        int largest = i; // Initialize largest as root
        int leftChildIdx = 2 * i + 1; // left = 2*i + 1
        int rightChildIdx = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (leftChildIdx < heapSize && arrA[leftChildIdx] > arrA[largest]) {
            largest = leftChildIdx;
        }

        // If right child is larger than largest so far
        if (rightChildIdx < heapSize && arrA[rightChildIdx] > arrA[largest]) {
            largest = rightChildIdx;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arrA[i];
            arrA[i] = arrA[largest];
            arrA[largest] = swap;

            // Recursive call to  heapify the sub-tree
            heapify(arrA, heapSize, largest);
        }
    }
    
}
