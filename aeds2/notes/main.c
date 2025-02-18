#include <stdio.h>
#include <stdbool.h>

int linearSort(int arr[], int n);
void sequentialSearch(int arr[], int target, int arrLength);
void binarySearch(int arr[], int x, int n);
void swap(int *a, int *b);

int main(void)
{
    int myArray[20] = {42, 87, 15, 63, 98, 34, 76, 21, 59, 11, 90, 27, 53, 68, 4, 82, 39, 71, 25, 99};
    int length = sizeof(myArray) / sizeof(myArray[0]);
    int target;

    scanf("%d", &target);
    // linearSort(myArray, length);
    binarySearch(myArray, target, length);
    // sequentialSearch(myArray, target, length);
    // for (int i = 0; i < length - 1; i++)
    // {
    //     printf("%d ", myArray[i]);
    // }
    // printf("\n");

    return 0;
}

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void sequentialSearch(int arr[], int target, int arrLength)
{
    bool resp = false;
    for (int i = 0; i < arrLength - 1; i++)
    {
        if (arr[i] == target)
        {
            resp = true;
            i = arrLength;
        }
    }
    if (resp)
    {
        printf("Target found; target: %d\n", target);
    }
    else
    {
        printf("Target doesn't exist into dataset.\n");
    }
}

void binarySearch(int arr[], int x, int n)
{   
    int left = 0;
    int right = n - 1;
    
    while (left <= right)
    {
        int mid = (left + right) / 2;
        int diff = x - arr[mid];

        if (diff == 0) {
            printf("Target found | target: %d", x);
            left = n;
        } else if (diff > 0)
        {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
}

int linearSort(int arr[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        int low = i;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[low] > arr[j])
            {
                low = j;
            }
        }
        swap(&arr[low], &arr[i]);
    }
}
