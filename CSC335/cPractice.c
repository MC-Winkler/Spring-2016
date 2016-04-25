#include <stdio.h>
#include <stdlib.h>

void stringCopy(char* in, char* out){
    while(*in != '\0'){
        *out = *in;
        out++;
        in++;
    }
    
}

void reverse(char* string, int size){
    char* string2 = malloc(size);
    stringCopy(string, string2);
    
    //this bit sets string2 to point to the last
    //non-null value in the string
    string2 += size;
    
    while(*string != '\0'){
        *string = * string2;
        string++;
        string2--;
    }
}
    
int count(char* string, char letter){
    int count = 0;
    while(*string != '\0'){
        if (*string == letter){
            count++;
        }
        string++;
    }
    return count;
}

void printArray(int array[], int size){
    int i;
    for(i=0; i<size; i++){
        printf("%d\t",array[i]);
    }
}

int addAll(int* array, int size){
    int sum = 0;
    int i;
    for (i=0; i<size; i++){
        sum += *array;
        array++;
    }
    return sum;
}

void negFirst(int array[], int size, int output[]){
    int i;
    for (i=0;i<size;i++){
        if(array[i] < 0){
            *output = array[i];
            output++;
        }
    }
    
    for(i=0;i<size;i++){
        if(array[i] >= 0){
            *output = array[i];
            output++;
        }
    }
}

int main()
{

}

