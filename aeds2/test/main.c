#include <stdio.h>
#include <string.h>

int palindrome(char string[]);

int main(void) 
{
    char inputFile[100];

    while (scanf("%s", inputFile) != EOF)
    {
        int isPalindrome = palindrome(inputFile);

        if (isPalindrome == 0) {
            printf("NÃO | %s\n", inputFile);
        } else
        {
            printf("SIM | %s\n", inputFile);
        }
    }
}

int palindrome(char string[])
{
    int length = strlen(string);
    int resp = 0; // 0 for false and 1 for true

    for (int i = 0; i < length - 1; i++)
    {
        if (string[i] != string[length - i])
        {
            resp = 0;
        } else 
        {
            resp = 1;
        }
    }
    return resp;
}
