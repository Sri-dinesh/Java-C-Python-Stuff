#include<stdio.h>
#include<stdlib.h>
#define SIZE 10

int hashTable[SIZE];

void initHashTable() {
    for(int i = 0; i < SIZE; i++) hashTable[i] = -1;
}


int hashFunction(int key) {
    return key % SIZE;
}

void insert(int key) {
    int index = hashFunction(key);
    while(hashTable[index] != -1)
        index = (index + 1) % SIZE;
    hashTable[index] = key;
    printf("Inserted %d at index %d\n", key, index);
}

int search(int key) {
    int index = hashFunction(key);
    while(hashTable[index] != -1) {
        if(hashTable[index] == key) 
            return index;
        index  = (index + 1) % SIZE;
    }
    return -1;
}


void delete(int key) {
    int index = search(key);
    if(index != -1) {
        hashTable[index] = -1;
        printf("Deleted key %d at index %d\n", key, index);
    } else 
        printf("Key %d not found in the hashTable\n", key);
}

void display() {
    printf("HashTable:\n");
    for(int i = 0; i < SIZE; i++) {
        printf("[%d] ->", i);
        if(hashTable[i] != -1) 
            printf("%d", hashTable[i]);
        else 
            printf("Empty");
        printf("\n");
    }
}

void main() {
    int x;
    initHashTable();
    insert(30);
    insert(40);
    insert(60);
    insert(50);

    x = search(60);
    if( x == -1)
        printf("Element not found\n");
    else 
    printf("Element found at index %d", x);

    printf("The Elements are:\n");
    display();
    delete(40);
    printf("After deleting, The elements are: \n");
    display();
}

/*
1. Global Setup:
   - hashTable[SIZE]: An array of integers to store keys.
   - SIZE = 10: The size of the hash table.
   - Empty slots are marked with -1.

2. initHashTable():
   - Loop through the array and set all values to -1 (means empty).

3. hashFunction(int key):
   - Returns: key % SIZE
   - This gives the index where the key should go.

4. insert(int key):
   - Step 1: Calculate index using hashFunction(key).
   - Step 2: If slot is occupied (not -1), move to next index: (index + 1) % SIZE.
   - Step 3: Keep moving until an empty slot is found.
   - Step 4: Place the key in that slot.
   - This is called "Linear Probing" for collision handling.

5. search(int key):
   - Step 1: Calculate index using hashFunction(key).
   - Step 2: Check if hashTable[index] equals the key.
   - Step 3: If not, move to next index: (index + 1) % SIZE.
   - Step 4: Stop when key is found (return index) or empty slot is hit (return -1).

6. delete(int key):
   - Step 1: Use search(key) to find the index.
   - Step 2: If found (index != -1), set hashTable[index] = -1.
   - Step 3: If not found, print "not found".

7. display():
   - Loop through the array.
   - Print index and value (or "Empty" if -1).

Easy Memory Trick:
   - Hash Function: key % SIZE (simple division remainder).
   - Collision: Linear Probing = (index + 1) % SIZE until empty.
   - Insert: Find spot, place key.
   - Search: Find spot, check key, move if collision.
   - Delete: Search first, then mark as -1.
   - Empty = -1.
*/