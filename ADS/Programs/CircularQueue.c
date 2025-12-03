#include <stdio.h>
#include <malloc.h>

struct node {
    int data;
    struct node *next;
} *front = NULL, *rear = NULL, *newnode, *temp;

void enqueue(int);
void display();
void dequeue();
void first();
void last();

void main() {
    enqueue(34);
    enqueue(10);
    enqueue(23);
    display();
    dequeue();
    first();
    last();
}

void enqueue(int x) {
    newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = x;
    
    if (rear == NULL) {
        rear = front = newnode;
        rear->next = front;  // Point to itself (circular)
    } else {
        rear->next = newnode;
        rear = newnode;
        rear->next = front;  // Maintain circular link
    }
}

void dequeue() {
    temp = front;
    
    if ((rear == NULL) && (front == NULL))
        printf("Queue is empty\n");
    else if (front == rear) {
        front = rear = NULL;
        printf("The deleted element is %d\n", temp->data);
        free(temp);
    } else {
        front = front->next;
        rear->next = front;  // Update circular link
        printf("The deleted element is %d\n", temp->data);
        free(temp);
    }
}

void first() {
    if ((rear == NULL) && (front == NULL))
        printf("Queue is empty\n");
    else
        printf("The front element is %d\n", front->data);
}

void last() {
    if ((rear == NULL) && (front == NULL))
        printf("Queue is empty\n");
    else
        printf("The last element is %d\n", rear->data);
}

void display() {
    temp = front;
    
    if ((rear == NULL) && (front == NULL))
        printf("Queue is empty\n");
    else {
        printf("The elements are ");
        do {
            printf("%3d", temp->data);
            temp = temp->next;
        } while (temp != front);
        printf("\n");
    }
}

/*

📌 WHAT IS A CIRCULAR QUEUE?
----------------------------
- A queue where the last node points back to the first node (forms a circle)
- Uses two pointers: FRONT (for deletion) and REAR (for insertion)
- Unlike linear queue, no space is wasted!

📌 KEY OPERATIONS:
------------------
1. ENQUEUE (Insert at rear)
   - Create new node
   - If empty: front = rear = newnode, rear->next = front
   - Else: rear->next = newnode, rear = newnode, rear->next = front
   
2. DEQUEUE (Delete from front)
   - If empty: print "Queue empty"
   - If single node: front = rear = NULL, free node
   - Else: front = front->next, rear->next = front, free old front

3. FIRST/LAST: Simply return front->data or rear->data

4. DISPLAY: Use do-while loop, stop when temp == front again

📌 EASY REMEMBER FORMULA:
-------------------------
┌─────────────────────────────────────────────────────────┐
│  ENQUEUE: Add at REAR, link back to FRONT               │
│  DEQUEUE: Remove from FRONT, update REAR's link         │
│  CIRCULAR RULE: rear->next = front (ALWAYS!)            │
│  EMPTY CHECK: front == NULL && rear == NULL             │
│  SINGLE NODE: front == rear                             │
└─────────────────────────────────────────────────────────┘

*/