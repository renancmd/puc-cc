#include <stdio.h>

void swap(int *x, int *y);
void quicksort(int array[], int length);
void quicksort_recursion(int array[], int low, int high);
int partition(int array[], int low, int high);

int main(void)
{
    int myArray[10] = {4, 8, 2, 1, 9, 6, 10, 5, 3, 7};
    int length = sizeof(myArray) / sizeof(myArray[0]);

    quicksort(myArray, length);

    for (int i = 0; i < length; i++)
    {
        printf("%d ", myArray[i]);
    }
    printf("\n");

    return 0;
}

void swap(int *x, int *y)
{
     int temp = *x;
    *x = *y;
    *y = temp;
}

void quicksort(int array[], int length)
{
    quicksort_recursion(array, 0, length - 1);
}

void quicksort_recursion(int array[], int low, int high)
{
    if (low <= high)
    {
        int pivot_index = partition(array, low, high);
        quicksort_recursion(array, low, pivot_index - 1);
        quicksort_recursion(array, pivot_index + 1, high);
    }
}

int partition(int array[], int low, int high)
{
    int pivot_value = array[high];
    int i = low;

    for (int j = low; j < high; j++)
    {
        if (array[j] <= pivot_value) 
        {
            swap(&array[i], &array[j]);
            i++;
        }
    }
    swap(&array[i], &array[high]);
    return i;
}