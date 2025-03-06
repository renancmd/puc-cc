#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define ALPHABET "abcdefghijklmnopqrstuvwxyz"
#define DIGITS "0123456789"

// Recursive function to apply the cipher
void caesarCipher(const char *msg, int index, char *cipher) {
    if (msg[index] == '\0') {
        cipher[index] = '\0'; // End the string
        return;
    }

    char currentChar = msg[index];
    bool isUpperCase = (currentChar >= 'A' && currentChar <= 'Z');
    bool found = false;
    int i;

    // Check if the character is a letter
    for (i = 0; i < strlen(ALPHABET); i++) {
        if (currentChar == ALPHABET[i] || currentChar == ALPHABET[i] - ('a' - 'A')) {
            int shiftPosition = (i + 3) % strlen(ALPHABET);
            char shiftedChar = ALPHABET[shiftPosition];
            cipher[index] = isUpperCase ? shiftedChar - ('a' - 'A') : shiftedChar;
            found = true;
            break;
        }
    }

    // Check if the character is a digit
    if (!found) {
        for (i = 0; i < strlen(DIGITS); i++) {
            if (currentChar == DIGITS[i]) {
                if (currentChar == '7') {
                    cipher[index] = ':';
                } else if (currentChar == '8') {
                    cipher[index] = ';';
                } else if (currentChar == '9') {
                    cipher[index] = '<';
                } else {
                    cipher[index] = DIGITS[(i + 3) % strlen(DIGITS)];
                }
                found = true;
                break;
            }
        }
    }

    // Check for special character mappings
    if (!found) {
        switch (currentChar) {
            case ' ': cipher[index] = '#'; break;
            case '-': cipher[index] = '0'; break;
            case '.': cipher[index] = '1'; break;
            case ',': cipher[index] = '/'; break;
            case '(': cipher[index] = '+'; break;
            case ')': cipher[index] = ','; break;
            case '!': cipher[index] = '$'; break;
            case '?': cipher[index] = 'B'; break;
            case ':': cipher[index] = '='; break;
            case '&': cipher[index] = ')'; break;
            case ';': cipher[index] = '>'; break;
            default: cipher[index] = currentChar; break;
        }
    }

    // Recursive call for the next character
    caesarCipher(msg, index + 1, cipher);
}

int main() {
    char input[1000], output[1000];

    while (fgets(input, sizeof(input), stdin)) {
        input[strcspn(input, "\n")] = '\0'; // Remove newline character
        caesarCipher(input, 0, output);
        printf("%s\n", output);
    }

    return 0;
}
