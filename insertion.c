#include <stdio.h>

void display(int num[],int count)
{
    for(int i=0;i<count;i++)
    {
        printf("%d ",num[i]);
    }
}

void insertionSort(int num[],int count)
{
    for(int i=1;i<count;i++)
    {
        int current=num[i];
        int j=i-1;
        while(j>=0 && num[j]>current)
        {
            num[j+1]=num[j];
            j--;
        }
        num[j+1]=current;
    }
    display(num,count);
}


int main(int argc, char const *argv[])
{
    printf("Enter the no of element in the array = ");
    int count;
    scanf("%d",&count);
    int num[count];
    printf("Start entering the numbers ");
    for(int i=0;i<count;i++)
    {
        scanf("%d",&num[i]);
    }
    insertionSort(num,count);
    return 0;
}
