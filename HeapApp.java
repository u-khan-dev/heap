public class HeapApp {
    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.insert(4, "E");
        heap.insert(7, "F");
        heap.insert(13, "Z");
        heap.insert(11, "K");
        heap.insert(60, "J");
        heap.insert(12, "M");
        heap.insert(100, "A");
        heap.insert(55, "P");
        heap.insert(74, "R");
        heap.insert(29, "T");
        heap.insert(1, "Q");

        heap.print();

        System.out.println("\nPopping the minimum value: " + heap.remove());

        heap.print();

        System.out.println("\nPopping the minimum value: " + heap.remove());

        heap.print();

        System.out.println("\nPopping the minimum value: " + heap.remove());

        heap.print();
    }
}
