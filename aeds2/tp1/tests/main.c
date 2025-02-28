#include <stdio.h>
#include <string.h>

int palindrome(char string[]);

int main(void) {
  char inputLine[300];

  while (fgets(inputLine, sizeof(inputLine), stdin) != NULL) {
    if (inputLine[strlen(inputLine) - 1] == '\n') {
      inputLine[strlen(inputLine) - 1] = '\0';
    }

    if (palindrome(inputLine) == 1) {
      printf("SIM\n");
    } else {
      printf("NAO\n");
    }
  }

  return 0;
}

int palindrome(char input[]) {
  int n = strlen(input);
  int resp = 1;

  for (int i = 0; i < n / 2; i++) {
    if (input[i] != input[n - i - 1]) {
      resp = 0;
      break;
    }
  }

  return resp;
}
