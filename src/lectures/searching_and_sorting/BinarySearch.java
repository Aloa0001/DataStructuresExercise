package lectures.searching_and_sorting;

public class BinarySearch<E> {
    public static void main(String[] args) {
        Integer[] a= {1,2,3,4,5,6,7};
        System.out.println(binarySearch(a, 6));
    }

    private static <E extends Comparable<? super E>> int binarySearch(E[] a, E x) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
