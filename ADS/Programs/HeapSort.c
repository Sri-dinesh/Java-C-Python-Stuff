#include<stdio.h>
#include<stdlib.h>

struct node 
{
int data;
struct node *left;
struct node *right;
};


void heapSort(struct node *r) {
    if(!r->right && !r->left) {
        return;
        if(!r->right) {
            if(r->left->data > r->data) {
                swap(&r->left->data,&r->data);
            }
        }
        else {
            if(r->right->data > r->left->data) {
                if(r->right->data > r->data) {
                    swap(&r->right->data, &r->data);
                    heapSort(r->right);
                }
            } else {
                if(r->left->data > r->data){
                    swap(&r->left->data, &r->data);
                    heapSort(r->left);
                }
            }
        }
    } 
}


void swap(int *x, int *y) {
    if (*x > *y) {
        // swap using pointers
        int temp = *x;
        *x = *y;
        *y = temp;
    }
}


int main() {
   heapSort(10); 
}
