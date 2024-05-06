#include <stdio.h>
#include <time.h>

void display(int num[], int count) {
    for (int i = 0; i < count; i++) {
        printf("%d ", num[i]);
    }
}

void selectionSort(int num[], int count) {
    for (int i = 0; i < count; i++) {
        int smallest = i;
        for (int j = i + 1; j < count; j++) {
            if (num[j] < num[smallest]) {
                smallest = j;
            }
        }
        int temp = num[smallest];
        num[smallest] = num[i];
        num[i] = temp;
    }
    display(num, count);
}

int main(int argc, char const *argv[]) {
    printf("Enter the number of elements in the array: ");
    int count;
    scanf("%d", &count);
    int num[count];
    printf("Start entering the numbers: ");
    for (int i = 0; i < count; i++) {
        scanf("%d", &num[i]);
    }

    time_t start, end;
    double elapsed_ms;

    start = time(NULL);

    selectionSort(num, count);

    end = time(NULL);

    elapsed_ms = difftime(end, start) * 1000;

    printf("\nRunning time: %.2f milliseconds\n", elapsed_ms);

    return 0;
}
