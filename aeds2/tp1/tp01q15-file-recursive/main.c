#include <stdio.h>

void inverseFile(FILE *file, long pos) {
    if (pos < 0) return;
    
    double value;
    fseek(file, pos, SEEK_SET);
    fread(&value, sizeof(double), 1, file);
    printf("%g\n", value);
    
    inverseFile(file, pos - sizeof(double));
}

int main() {
    FILE *file = fopen("data.bin", "wb");
    if (!file) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }

    int n;
    scanf("%d", &n);
    
    double value;
    for (int i = 0; i < n; i++) {
        scanf("%lf", &value);
        fwrite(&value, sizeof(double), 1, file);
    }
    
    fclose(file);
    
    file = fopen("data.bin", "rb");
    if (!file) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }
    
    fseek(file, 0, SEEK_END);
    long fileSize = ftell(file);
    
    inverseFile(file, fileSize - sizeof(double));
    
    fclose(file);
    return 0;
}
