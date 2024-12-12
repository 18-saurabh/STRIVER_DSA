
public class floorCeilInSortedArray {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int floor = -1;
        int ceil = -1;
        // Binary search for floor and ceil
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == x) {
                // If x is found, it's both floor and ceil
                floor = a[mid];
                ceil = a[mid];
                break;
            } else if (a[mid] < x) {
                // If a[mid] < x, update floor and search in the right half
                floor = a[mid];
                low = mid + 1;
            } else {
                // If a[mid] > x, update ceil and search in the left half
                ceil = a[mid];
                high = mid - 1;
            }
        }
        return new int[] { floor, ceil };
    }
}
