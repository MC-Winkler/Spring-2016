#include <stdio.h>
#include <stdlib.h>

int stringLength(char* string){
    int count = 0;
    while (*string != '\0'){
        string++;
        count++;
    }
    return count;
}

void reverse2(char* string, char* string2){
    char* stringCopy = string;
    
    //this bit sets string2 to point to the last
    //non-null value in the string
    while (*stringCopy != '\0'){
        string2++;
        stringCopy++;
    }    
    string2--;
    
    while(*string != '\0'){
        *string2 = *string;
        string++;
        string2--;
    }
}

int firstVowel(char* string){
    int index = -1;
    while (*string != '\0'){
        index++;
        if (*string == 'a' || *string == 'e' || *string == 'i'
        || *string == 'o' || *string == 'u'){
            return index;
        }
        string++;
    }
    return -1;
}

char* concat(char* first, char* second){
    int newSize = stringLength(first) + stringLength(second) + 1;
    char* newString= malloc(newSize);
    while(*first != '\0'){
        *newString=*first;
        first++;
        newString++;
    }
    while(*second!='\0'){
        *newString = *second;
        newString++;
        second++;
    }
    newString -= (newSize-1);
    return newString;
}

char* substring(char* original, int start, int end){
    int diff = end - start;
    int newSize = (diff + 1);
    char* newString = malloc(newSize);
    int i;
    for (i=0; i<start; i++){
        original++;
    }
    for (i=0; i<diff; i++){
        *newString = *original;
        original++;
        newString++;
    }
    newString -= diff;
    return newString;
}

char* pigLatin(char* original){
    int wordSize = 0;
    char* originalCopy = original;
    while (*originalCopy != '\0'){
        wordSize++;
        originalCopy++;

    }

    char* newWord = malloc(wordSize+2);
    char* tempWord = malloc(wordSize);
    char* ay = malloc(2);
    *ay = 'a';
    ay++;
    *ay = 'y';
    ay--;
    
    
    int vowelIndex = firstVowel(original);
    char* oldBeginning = substring(original, 0, vowelIndex);
    char* oldEnd = substring(original, vowelIndex, wordSize+1);
    
    tempWord = concat(oldEnd, oldBeginning);
    newWord = concat(tempWord, ay);
    return newWord;
}

int main()
{
    printf(pigLatin("apple")); // "appleay"
    printf("\n");
    printf(pigLatin("dapple")); // "appleday" 
}

