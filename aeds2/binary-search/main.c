#include <stdio.h>

int main(void) {
    int myArray[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int length = sizeof(myArray) / sizeof(myArray[0]);
    int target = 10; // Element to search
    int left = 0; // Index from the first element of the array
    int right = length - 1; // Index from the last element of the array
    // OBS: The reason for subtracting 1 from the right variable is that the length represents the number of elements in the array, not the highest index.
    int counter = 0;

    // scanf("%d", &target);

    while(left <= right) {
        int mid = (left + right) / 2; // Get the middle index of the array
        int diff = target - myArray[mid]; // Get the difference between the target and middle value of the array
        counter++;

        if (diff == 0) { // If the difference is 0, then the target value was found
            printf("Target found! target: %d repetition: %d\n", myArray[mid], counter);
            left = length; // Stop the loop, 'cause target value was found
        } else if (diff > 0) { // If the difference is greater than 0, set mid + 1 in left variable and back to the mid operation (line 14)
            left = mid + 1;
        } else { // If the difference is less than 0, set mid - 1 in right variable and back to the mid operation (line 14)
            right = mid - 1;
        }
    }


    return 0;
}