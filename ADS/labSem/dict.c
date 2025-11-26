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
Step-by-Step Explanation to Remember and Write the Program:

1. Structure Definition (struct Node):
   - key: The unique identifier (like a word in a dictionary).
   - value: The data associated with the key (like the meaning).
   - next: Pointer to the next node (linked list).
   - head: Global pointer to the start of the list.

2. Insert Function (insert(int key, int value)):
   - Step 1 - Check for Existing Key: Loop through the list. If key already exists, UPDATE the value and return.
   - Step 2 - Create New Node: Allocate memory, set key, value, and next = NULL.
   - Step 3 - Add to List:
       - If head == NULL (empty list): Make new node the head.
       - Else: Traverse to the end and link the new node.

3. Delete Function (deleteKey(int key)):
   - Track Two Pointers: temp (current) and prev (previous).
   - Loop and Find: Traverse until you find the key.
   - Delete:
       - If prev == NULL (deleting head): Move head to head->next.
       - Else: Bypass the node (prev->next = temp->next).
   - Free Memory: free(temp).

4. Search Function (search(int key)):
   - Loop through the list.
   - If key matches, return the value.
   - If not found, return -1.

5. Display Function (display()):
   - Loop through the list and print each key and value.

Easy Memory Trick (Dictionary = Linked List):
   - Node: key, value, next.
   - Insert: Find if exists (update) -> Else create and add at end.
   - Delete: Find node, bypass it, free it. (Remember prev pointer!)
   - Search: Loop until key matches, return value.
   - Display: Loop and print.
*/