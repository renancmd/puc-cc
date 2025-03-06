#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool isPalindrome(const char *input, int left, int right) 
{
    bool resp;
    if (left >= right)
    {
        resp = true;
    } else if (input[left] != input[right])
    {
        resp = false;
    } else
    {
        resp = isPalindrome(input, left + 1, right - 1);
    }

    return resp;
}

int main()
{
    char input[1000];
    while (fgets(input, sizeof(input), stdin)) {
        input[strcspn(input, "\n")] = 0;

        if (isPalindrome(input, 0, strlen(input) - 1)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }

    return 0;
}