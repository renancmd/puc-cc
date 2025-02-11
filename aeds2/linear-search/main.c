#include <stdio.h>

int main(void) {
    int myArray[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int length = sizeof(myArray) / sizeof(myArray[0]);
    int target = 5;

    for (int i = 0; i < length; i++) {
        if (target == myArray[i]) {
            printf("Target found. target: %d\n", myArray[i]);
            i = length;
        }
    }
}