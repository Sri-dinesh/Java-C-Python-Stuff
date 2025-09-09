#include<stdio.h>
#include<stdlib.h>

// Standard structure for a node in a singly linked list
struct node {
    int data;
    struct node* next;
} *head = NULL; // Global head pointer, initialized to NULL

// Function prototypes
void create();
void insertBeg();
void insertEnd();note
void insertPos();
void deleteBeg();
void deleteEnd();
void deletePos(); // Added a function to delete from a specific position
void display();

// Use int main() instead of void main() for standard compliance
int main() {
    int ch;
    while (1) {
        printf("\n--- Singly Linked List Menu ---\n");
        printf("1. Create List\n");
        printf("2. Insert at Beginning\n");
        printf("3. Insert at End\n");
        printf("4. Insert at Position\n");
        printf("5. Delete from Beginning\n");
        printf("6. Delete from End\n");
        printf("7. Delete from Position\n"); // Added menu option for deletePos
        printf("8. Display List\n");
        printf("9. Exit\n");
        printf("-----------------------------\n");
        printf("Enter your choice: ");
        scanf("%d", &ch);

        switch (ch) {
            case 1: create(); break;
            case 2: insertBeg(); break;
            case 3: insertEnd(); break;
            case 4: insertPos(); break;
            case 5: deleteBeg(); break;
            case 6: deleteEnd(); break;
            case 7: deletePos(); break; // Added function call for deletePos
            case 8: display(); break;
            case 9: exit(0);
            default: printf("\nInvalid choice! Please enter a valid option.\n");
        }
    }
    return 0;
}

void create() {
    int n, i;
    printf("\nEnter how many nodes you want to create: ");
    scanf("%d", &n);
    if (n <= 0) {
        printf("Number of nodes must be positive.\n");
        return;
    }
    
    // Clear any existing list before creating a new one
    while(head != NULL) {
        struct node *temp = head;
        head = head->next;
        free(temp);
    }

    for (i = 1; i <= n; i++) {
        struct node *newNode = (struct node*)malloc(sizeof(struct node));
        // FIX: Check if malloc was successful
        if (newNode == NULL) {
            printf("Memory allocation failed!\n");
            return;
        }

        printf("Enter node %d data: ", i);
        scanf("%d", &newNode->data);
        newNode->next = NULL;

        if (head == NULL) {
            head = newNode;
        } else {
            struct node *temp = head;
            while (temp->next != NULL) {
                temp = temp->next;
            }
            temp->next = newNode;
        }
    }
    printf("List created successfully.\n");
}

void insertBeg() {
    struct node *newNode = (struct node*)malloc(sizeof(struct node));
    // FIX: Check if malloc was successful
    if (newNode == NULL) {
        printf("Memory allocation failed!\n");
        return;
    }
    printf("\nEnter node data: ");
    scanf("%d", &newNode->data);
    newNode->next = head;
    head = newNode;
    printf("Node inserted at the beginning.\n");
}

void insertEnd() {
    struct node *newNode = (struct node*)malloc(sizeof(struct node));
    // FIX: Check if malloc was successful
    if (newNode == NULL) {
        printf("Memory allocation failed!\n");
        return;
    }
    printf("\nEnter node data: ");
    scanf("%d", &newNode->data);
    newNode->next = NULL;

    // FIX: Handle insertion into an empty list
    if (head == NULL) {
        head = newNode;
    } else {
        struct node *temp = head;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newNode;
    }
    printf("Node inserted at the end.\n");
}

void insertPos() {
    int pos, i = 1;
    struct node *newNode, *temp = head;

    printf("\nEnter position to insert: ");
    scanf("%d", &pos);

    // FIX: Add validation for the position
    if (pos < 1) {
        printf("Invalid position!\n");
        return;
    }

    if (pos == 1) {
        insertBeg(); // Use existing function for position 1
        return;
    }

    // Traverse to the node just BEFORE the desired position
    while (i < pos - 1 && temp != NULL) {
        temp = temp->next;
        i++;
    }

    // FIX: Check if the position is valid (i.e., not too far)
    if (temp == NULL) {
        printf("Position out of bounds!\n");
        return;
    }

    newNode = (struct node *)malloc(sizeof(struct node));
    // FIX: Check if malloc was successful
    if (newNode == NULL) {
        printf("Memory allocation failed!\n");
        return;
    }
    printf("\nEnter node data: ");
    scanf("%d", &newNode->data);

    newNode->next = temp->next;
    temp->next = newNode;
    printf("Node inserted at position %d.\n", pos);
}

void deleteBeg() {
    if (head == NULL) {
        printf("\nList is empty! Nothing to delete.\n");
        return;
    }
    struct node *temp = head;
    printf("\nDeleted node data is: %d\n", temp->data);
    head = head->next;
    free(temp); // Free the memory of the deleted node
}

void deleteEnd() {
    if (head == NULL) {
        printf("\nList is empty! Nothing to delete.\n");
        return;
    }
    
    struct node *temp = head;
    struct node *prev = NULL;

    // FIX: Handle deletion from a single-node list
    if (head->next == NULL) {
        printf("\nDeleted node data is: %d\n", head->data);
        free(head);
        head = NULL;
        return;
    }

    // Traverse to the last node, keeping track of the previous one
    while (temp->next != NULL) {
        prev = temp;
        temp = temp->next;
    }

    // FIX: Free the memory of the last node and unlink it
    printf("\nDeleted node data is: %d\n", temp->data);
    prev->next = NULL;
    free(temp);
}

// BONUS: A function to delete from any valid position
void deletePos() {
    if (head == NULL) {
        printf("\nList is empty! Nothing to delete.\n");
        return;
    }
    
    int pos, i = 1;
    printf("\nEnter position of node to delete: ");
    scanf("%d", &pos);

    if (pos < 1) {
        printf("Invalid position!\n");
        return;
    }

    if (pos == 1) {
        deleteBeg();
        return;
    }

    struct node *temp = head;
    struct node *prev = NULL;

    while (i < pos && temp != NULL) {
        prev = temp;
        temp = temp->next;
        i++;
    }

    if (temp == NULL) {
        printf("Position out of bounds!\n");
        return;
    }

    printf("\nDeleted node data is: %d\n", temp->data);
    prev->next = temp->next;
    free(temp);
}


void display() {
    if (head == NULL) {
        printf("\nList is empty!\n");
        return;
    }

    struct node *temp = head;
    printf("\nList elements: HEAD -> ");
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}