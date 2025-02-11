public class Main {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 8;
        int left, right;
        left = 0;
        right  = myArray.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int diff = target - myArray[mid];

            if (diff == 0) {
                System.err.println("Target found. target: " + myArray[mid]);
                left = myArray.length;
            } else if (diff > 0) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        
    }
}