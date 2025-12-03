#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>

struct Node {
    int key;
    int value;
    struct Node* next;
} *head = NULL, *temp;

void insert(int key, int value) {
    temp = head;

    while(temp != NULL) {
        if(temp->key == key) {
            temp->value = value;
            return;
        }
        temp = temp->next;
    }

    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->key = key;
    newNode->value = value;
    newNode->next = NULL;

    if(head == NULL) {
        head = newNode;
    } else {
        temp = head;
        while(temp -> next != NULL)
            temp = temp->next;
        temp->next = newNode;
    }
}

void deleteKey(int key) {
    temp = head;
    struct Node* prev = NULL;
    while(temp != NULL) {
        if(temp->key == key) {
            if(prev == NULL)
                head = temp->next;
            else  
                prev->next = temp->next;
            free(temp);
            return;
        }
        prev = temp;
        temp = temp->next;
    }
}

int search(int key) {
    temp = head;
    while(temp != NULL) {
        if(temp->key == key)
            return temp->value;
        temp = temp->next;
    }
    return -1;
}

void display() {
    temp = head;
    while(temp != NULL) {
        printf("Key: %d, Value: %d\n", temp->key, temp->value);
        temp = temp->next;
    }
}

int main() {
    insert(1, 10);
    insert(2, 20);
    insert(3, 30);
    insert(4, 40);
    printf("Initial List:\n");
    display();
    int searchKey = 2;
    int searchResult = search(searchKey);
    printf("\nSearch result for the key %d: %d\n", searchKey, searchResult);
    deleteKey(2);
    printf("\nList after deleting key %d:\n", searchKey);
    display();
    return 0;
}

/*
================================================================================
                    DICTIONARY (Key-Value Store) - ALGORITHM
================================================================================

STRUCTURE:
----------
    struct Node {
        int key
        int value
        struct Node *next
    }
    Pointer: head (initially NULL)

--------------------------------------------------------------------------------
ALGORITHM: INSERT(key, value)
--------------------------------------------------------------------------------
    Step 1: temp = head
    Step 2: WHILE temp != NULL DO           // Check if key exists
                IF temp->key == key THEN
                    temp->value = value     // UPDATE existing
                    RETURN
                ENDIF
                temp = temp->next
            ENDWHILE
    Step 3: Create newNode with key, value, next = NULL
    Step 4: IF head == NULL THEN
                head = newNode
            ELSE
                Traverse to end of list
                lastNode->next = newNode
            ENDIF
    Step 5: END

--------------------------------------------------------------------------------
ALGORITHM: DELETE(key)
--------------------------------------------------------------------------------
    Step 1: temp = head, prev = NULL
    Step 2: WHILE temp != NULL DO
                IF temp->key == key THEN
                    IF prev == NULL THEN    // Deleting head
                        head = temp->next
                    ELSE
                        prev->next = temp->next  // Bypass node
                    ENDIF
                    FREE temp
                    RETURN
                ENDIF
                prev = temp
                temp = temp->next
            ENDWHILE
    Step 3: END

--------------------------------------------------------------------------------
ALGORITHM: SEARCH(key)
--------------------------------------------------------------------------------
    Step 1: temp = head
    Step 2: WHILE temp != NULL DO
                IF temp->key == key THEN
                    RETURN temp->value
                ENDIF
                temp = temp->next
            ENDWHILE
    Step 3: RETURN -1                       // Not found

--------------------------------------------------------------------------------
ALGORITHM: DISPLAY()
--------------------------------------------------------------------------------
    Step 1: temp = head
    Step 2: WHILE temp != NULL DO
                PRINT temp->key, temp->value
                temp = temp->next
            ENDWHILE
    Step 3: END

================================================================================
📌 QUICK MEMORY TRICK:
================================================================================
    ✓ DICTIONARY = Linked List with (key, value) pairs
    
    ✓ INSERT: "Check First, Then Add"
        - Loop to find existing key → UPDATE if found
        - Else create new node → Add at END
    
    ✓ DELETE: "Two Pointers - prev & temp"
        - prev tracks previous node
        - If deleting head: head = head->next
        - Else: prev->next = temp->next (bypass)
        - Don't forget to FREE!
    
    ✓ SEARCH: Loop until key matches, return value (or -1)
    
    ✓ DISPLAY: Simple loop → Print key:value pairs
================================================================================
*/