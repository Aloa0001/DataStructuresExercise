package lectures.searching_and_sorting_L5;

import java.util.Hashtable;

public class BinarySearch_<E> {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(binarySearch(a, 9));
        System.out.println(X());

    }

    private static String X() {
        Hashtable<Integer, String> h = new Hashtable<>();
        h.put(32,"asdas");
        h.put(123,"fdgsdfg");
        h.put(324,"dafsdf");
        h.put(43,"sdafds");
        h.put(53,"sdafds");
        h.put(63,"sdafds");
        h.put(73,"sdafds");
        return h.toString();
    }

    private static <E extends Comparable<? super E>> boolean binarySearch(E[] a, E x) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private static int interpolationSearch(int arr[], int n, int i) {
        int x = 0;
        int lo = 0, hi = (n - 1);
        while (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            int pos = lo + (((hi - lo) / (arr[hi] - arr[lo])) * (x - arr[lo]));

            if (arr[pos] == x)
                return pos;

            if (arr[pos] < x)
                lo = pos + 1;
            else
                hi = pos + 1;
        }
        return -1;
    }

}
