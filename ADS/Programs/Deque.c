// C Program to implement Deque using doubly linked list
#include <stdio.h>
#include <malloc.h>
struct node
{
int data;
struct node *prev, *next;
} *front = NULL, *rear = NULL, *newnode, *p, *q;
int size = 0;
void create()
{
int n, i;
printf("Enter the no of nodes\n");
scanf("%d", &n);
for (i = 1; i <= n; i++)
{
newnode = (struct node *)malloc(sizeof(struct node));
printf("Enter the data\n");
scanf("%d", &newnode->data);
newnode->next = NULL;
newnode->prev = NULL;
if (front == NULL)
front = rear = newnode;
else {
rear->next = newnode;
newnode->prev = rear;
rear = newnode;
}
size++;
}
}
void display() {
if (front == NULL) {
printf("Deque is empty\n");
return;
}
q = front;
p = rear;
printf("The elements are ");
while (q) {
printf("%3d", q->data);
q = q->next;
}
printf("\nThe elements in reverse order are ");
while (p) {
printf("%3d", p->data);
p = p->prev;
}
printf("\n");
}
void InsertFront(int x) {
newnode = (struct node *)malloc(sizeof(struct node));
newnode->data = x;
newnode->next = NULL;
newnode->prev = NULL;
if (front == NULL)
rear = front = newnode;
else {
newnode->next = front;
front->prev = newnode;
front = newnode;
}
size++;
}
void InsertRear(int x) {
newnode = (struct node *)malloc(sizeof(struct node));
newnode->data = x;
newnode->next = NULL;
newnode->prev = NULL;
if (front == NULL)
rear = front = newnode;
else {
newnode->prev = rear;
rear->next = newnode;
rear = newnode;
}
size++;
}
void DeleteFront() {
if (front == NULL)
printf("Deque is empty\n");
else {
p = front;
front = front->next;
if (front == NULL)
rear = NULL;
else
front->prev = NULL;
free(p);
size--;
}
}
void DeleteRear() {
if (front == NULL)
printf("Deque is empty\n");
else {
p = rear;
rear = rear->prev;
if (rear == NULL)
front = NULL;
else
rear->next = NULL;
free(p);
size--;
}
}
void getRear() {
if (front == NULL)
printf("Queue is empty\n");
else
printf("The rear element is %d\n", rear->data);
}
void getFront() {
if (front == NULL)
printf("Queue is empty\n");
else
printf("The front element is %d\n", front->data);
}
void qsize() {
printf("The no of nodes in queue are %d\n", size);
}
void erase() {
rear = NULL;
while (front != NULL) {
p = front;
front = front->next;
free(p);
}
size = 0;
}
void main()
{
create();
display();
InsertFront(23);
InsertRear(34);
display();
DeleteFront();
DeleteRear();
display();
getRear();
getFront();
qsize();
erase();
display();
}