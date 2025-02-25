#include <stdio.h>
#include <string.h>

int palindrome(char string[]);

int main(void)
{
    char inputLine[300];

    while (fgets(inputLine, sizeof(inputLine), stdin) != NULL)
    {
        if (palindrome(inputLine))
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
    }

    return 0;
}

int palindrome(char string[])
{
    int n = strlen(string);
    int resp;

    if (string[n - 1] == '\n')
    {
        n--;
    }
    for (int i = 0; i < n / 2; i++)
    {
        if (string[i] != string[n - i - 1])
        {
            resp = 0;
        }
    }
    resp = 1;
    return resp;
}