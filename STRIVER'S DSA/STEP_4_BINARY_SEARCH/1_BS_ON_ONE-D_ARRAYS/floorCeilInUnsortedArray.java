

public class floorCeilInUnsortedArray {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code
        int floor = -1;
        int ceil = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                // Update floor if it's closer to x
                if (floor == -1 || arr[i] > floor) {
                    floor = arr[i];
                }
            }
            if (arr[i] >= x) {
                // Update ceil if it's closer to x
                if (ceil == -1 || arr[i] < ceil) {
                    ceil = arr[i];
                }
            }
        }
        return new int[] { floor, ceil };
    } 
}
