#include <stdio.h>

int main(void)
{
    int myArray[10] = {4, 8, 2, 1, 9, 6, 10, 5, 3, 7};
    int length = sizeof(myArray) / sizeof(myArray[0]);

    for (int i = 1; i < length; i++)
    {
        int currentElement = myArray[i]; // Current element to through into the loop
        int previousIndex = i - 1; // Previous index relative to the current one
        while ((previousIndex >= 0) && (currentElement < myArray[previousIndex])) // Check previous element is greater than the current element
//                                                                                // and also do the same for others previous befores 
        {
            myArray[previousIndex + 1] = myArray[previousIndex];
            previousIndex--;
        }
        myArray[previousIndex + 1] = currentElement;
    }

    for (int i = 0; i < length; i++)
    {
        printf("%d ", myArray[i]);
    }
    printf("\n");

    return 0;
}