#include <stdio.h>

int main(void) {
    int x ;
    while (scanf("%d", &x) != EOF) {
        printf("consegui ler: %d", x);
    }
    return 0;
}
