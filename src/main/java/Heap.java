

public class Heap {

    private int[] heap;
    private int size;
    private static final int FRONT = 1;

    public Heap(int maxSize) {
        heap = new int[maxSize + 1];
        size = 0;
    }

    private int getParent(int position) {
        return position / 2;
    }

    private int getLeftChild(int position) {
        return position * 2;
    }

    private int getRightChild(int position) {
        return position * 2 + 1;
    }

    private void swap(int position1, int position2) {
        int temp = heap[position1];
        heap[position1] = heap[position2];
        heap[position2] = temp;
    }

    private boolean isLeaf(int position) {
        if (position > size / 2) {
            return true;
        }
        return false;
    }

    public void insert(Pasajero data) {
        heap[++size] = data.getnumero_prioridad();
        int currentItemIndex = size;
        while (heap[currentItemIndex] < heap[getParent(currentItemIndex)]) {
            swap(currentItemIndex, getParent(currentItemIndex));
            currentItemIndex = getParent(currentItemIndex);
        }
    }

    public int delete() {
        int item = heap[FRONT];
        swap(FRONT, size--); // heap[FRONT] = heap[size--];
        heapify(FRONT);
        return item;
    }

    private void heapify(int position) {
        if (isLeaf(position)) {
            return;
        }
        if (heap[position] > heap[getLeftChild(position)]
                || heap[position] > heap[getRightChild(position)]) {
            // if left is smaller than right
            if (heap[getLeftChild(position)] < heap[getRightChild(position)]) {
                // swap with left
                swap(heap[position], heap[getLeftChild(position)]);
                heapify(getLeftChild(position));
            } else {
                // swap with right
                swap(heap[position], heap[getRightChild(position)]);
                heapify(getRightChild(position));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= size / 2; i++) {
            output.append("Parent :" + heap[i]);
            output
                    .append("LeftChild : " + heap[getLeftChild(i)] + " RightChild :" + heap[getRightChild(i)])
                    .append("\n");
        }
        return output.toString();
    }

    public int numero() {
        int num = heap[FRONT];
        heapify(FRONT);
        return num;
    }
}
