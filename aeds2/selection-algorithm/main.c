#include <stdio.h>

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

int main(void)
{
    int myArray[10] = {4, 8, 2, 1, 9, 6, 10, 5, 3, 7};
    int length = sizeof(myArray) / sizeof(myArray[0]);

    for (int i = 0; i < length - 1; i++)
    {
        int menor = i;
        for (int j = (menor + 1); j < length; j++)
        {
            if (myArray[menor] > myArray[j])
            {
                menor = j;
            }
        }
        swap(&myArray[menor], &myArray[i]);
    }

    for (int i = 0; i < length; i++) {
        printf("%d ", myArray[i]);
    }
    printf("\n");
}