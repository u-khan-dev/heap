import java.util.ArrayList;

public class Heap {
    private ArrayList<Entry> heap;

    private static final int FRONT = 1;

    class Entry {
        private int key;
        private String value;

        public Entry(int newKey, String newValue) {
            key = newKey;
            value = newValue;
        }
    }

    public Heap() {
        heap = new ArrayList();
        heap.add(new Entry(Integer.MIN_VALUE, "*"));
    }

    private int parent(int pos) { return pos / 2; }

    private int leftChild(int pos) { return 2 * pos; }

    private int rightChild(int pos) { return 2 * pos + 1; }

    private boolean isExternal(int pos) { return pos >= heap.size() / 2; }

    private boolean hasLeftChild(int pos) { return leftChild(pos) <= heap.size() - 1; }

    private boolean hasRightChild(int pos) { return rightChild(pos) <= heap.size() - 1; }

    public void insert(int key, String value) {
        heap.add(new Entry(key, value));
        upHeapBubble(heap.size() - 1);
    }

    public String remove() {
        Entry popped = heap.get(FRONT);
        heap.set(FRONT, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        downHeapBubble(FRONT);
        return "(" + popped.key + ", " + popped.value + ")";
    }

    private void upHeapBubble(int position) {
        int current = position;

        while (heap.get(current).key < heap.get(parent(current)).key) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void downHeapBubble(int position) {
        if (!isExternal(position)) {
            int swapPosition;
            int leftPosition = heap.get(leftChild(position)).key;
            int rightPosition = heap.get(rightChild(position)).key;

            if (Math.min(leftPosition, rightPosition) == rightPosition) {
                swapPosition = rightChild(position);
            } else {
                swapPosition = leftChild(position);
            }

            if (heap.get(position).key > heap.get(swapPosition).key) {
                swap(position, swapPosition);
                downHeapBubble(swapPosition);
            }
        }
    }

    private void swap(int firstPosition, int secondPosition) {
        Entry first = heap.get(firstPosition);
        heap.set(firstPosition, heap.get(secondPosition));
        heap.set(secondPosition, first);
    }

    public void print() {
        System.out.println();

        int size = heap.size();

        String par, left, right;

        for (int i = 1; i <= size / 2; i++) {
            par = "parent: (" + heap.get(i).key + ", " + heap.get(i).value + ")";

            if (hasLeftChild(i)) {
                left = " left child: (" + heap.get(leftChild(i)).key + ", " + heap.get(leftChild(i)).value + ")";
            } else {
                left = " left child: *";
            }

            if (hasRightChild(i)) {
                right = " right child: (" + heap.get(rightChild(i)).key + ", " + heap.get(rightChild(i)).value + ")";
            } else {
                right = " right child: *";
            }

            if (hasLeftChild(i)) System.out.println(par + ";" + left + ";" + right);
        }
    }





}
