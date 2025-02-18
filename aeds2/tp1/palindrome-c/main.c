#include <stdio.h>
#include <string.h>

int palindrome(char string[]);

int main(void) 
{
    FILE *test;
    
    test = fopen("./pubs/pub.in", "r");

    char inputFile[400];

    fgets(inputFile, 400, test);

    // while (scanf("%s", inputFile) != EOF)
    // {
        // int isPalindrome = palindrome(inputFile);

        // if (isPalindrome == 0) {
        //     printf("NAO\n");
        // } else
        // {
        //     printf("SIM\n");
        // }
    // }

    while (fgets(inputFile, 400, test))
    {
        int isPalindrome = palindrome(inputFile);

        if (isPalindrome == 0) {
            printf("NAO\n");
        } else
        {
            printf("SIM\n");
        }
    }

    fclose(test);


}

int palindrome(char string[])
{
    int length = strlen(string);
    int resp = 1; // 0 for false and 1 for true

    for (int i = 0; i < length - 1; i++)
    {
        if (string != string[(length - 1) - i])
        {
            resp = 0;
            printf("%c %c", string[i], string[(length -1) - i]);
        }
    }
    return resp;
}