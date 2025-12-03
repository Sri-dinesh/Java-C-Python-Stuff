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
================================================================================
                HASH TABLE (Linear Probing) - ALGORITHM
================================================================================

GLOBAL VARIABLES:
-----------------
    hashTable[SIZE] : Array to store keys
    SIZE = 10       : Size of hash table
    EMPTY = -1      : Marker for empty slots

--------------------------------------------------------------------------------
ALGORITHM: INIT_HASH_TABLE()
--------------------------------------------------------------------------------
    Step 1: FOR i = 0 TO SIZE-1 DO
                hashTable[i] = -1         // Mark all as empty
            ENDFOR
    Step 2: END

--------------------------------------------------------------------------------
ALGORITHM: HASH_FUNCTION(key)
--------------------------------------------------------------------------------
    Step 1: RETURN key % SIZE

--------------------------------------------------------------------------------
ALGORITHM: INSERT(key)
--------------------------------------------------------------------------------
    Step 1: index = HASH_FUNCTION(key)
    Step 2: WHILE hashTable[index] != -1 DO   // Collision handling
                index = (index + 1) % SIZE    // Linear Probing
            ENDWHILE
    Step 3: hashTable[index] = key
    Step 4: END

--------------------------------------------------------------------------------
ALGORITHM: SEARCH(key)
--------------------------------------------------------------------------------
    Step 1: index = HASH_FUNCTION(key)
    Step 2: WHILE hashTable[index] != -1 DO
                IF hashTable[index] == key THEN
                    RETURN index              // Found!
                ENDIF
                index = (index + 1) % SIZE
            ENDWHILE
    Step 3: RETURN -1                         // Not found

--------------------------------------------------------------------------------
ALGORITHM: DELETE(key)
--------------------------------------------------------------------------------
    Step 1: index = SEARCH(key)
    Step 2: IF index != -1 THEN
                hashTable[index] = -1         // Mark as empty
                PRINT "Deleted"
            ELSE
                PRINT "Not found"
            ENDIF
    Step 3: END

--------------------------------------------------------------------------------
ALGORITHM: DISPLAY()
--------------------------------------------------------------------------------
    Step 1: FOR i = 0 TO SIZE-1 DO
                PRINT "[" + i + "] -> "
                IF hashTable[i] != -1 THEN
                    PRINT hashTable[i]
                ELSE
                    PRINT "Empty"
                ENDIF
            ENDFOR
    Step 2: END

================================================================================
📌 QUICK MEMORY TRICK:
================================================================================
    ✓ HASH FUNCTION: key % SIZE (remainder gives index)
    
    ✓ LINEAR PROBING: When collision occurs
        index = (index + 1) % SIZE
        Keep moving until empty slot found
    
    ✓ INSERT: Calculate index → Probe if occupied → Place key
    
    ✓ SEARCH: Calculate index → Check → Probe if mismatch → Return index or -1
    
    ✓ DELETE: Search first → If found, mark as -1
    
    ✓ EMPTY MARKER: -1 (means slot is available)
    
    ✓ WHY % SIZE in probing?
        - To wrap around (circular behavior)
        - If index = 9 and SIZE = 10, next = (9+1) % 10 = 0
================================================================================
*/