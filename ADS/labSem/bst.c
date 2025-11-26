#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>

struct node {
    int data;
    struct node *right;
    struct node *left;
} *root = NULL, *temp;


struct node* insert(struct node*, int);
struct node* search(struct node*, int);
struct node* delete(struct node*, int);
struct node* find_min(struct node*);
void inorder(struct node*);
void preorder(struct node*);
void postorder(struct node*);


void main() {
    root = insert(root, 1);
    insert(root, 4);
    insert(root, 2);
    insert(root, 5);
    insert(root, 12);
    insert(root, 7);

    root = delete(root, 4);

    if((search(root, 5)) == NULL) {
        printf("Element not found\n");
    } else {
        printf("Element found.");
    }

    printf("\nInorder Traversal: ");
    inorder(root);
    
    printf("\nPreorder Traversal: ");
    preorder(root);

    printf("\nPostorder Traversal: ");
    postorder(root);
}



struct node* insert(struct node* root, int x) {
    if(root == NULL) {
        temp = (struct node*)malloc(sizeof(struct node));
        temp->data = x;
        temp->left = NULL;
        temp->right = NULL;
        root = temp;
    } else if(x > root->data) 
        root->right = insert(root->right, x);
    else 
        root->left = insert(root->left, x);
    
    return root;
}

struct node* search(struct node* root, int x) {

    if(root == NULL || root->data == x) 
        return root;
    else if(x > root->data)
        return search(root->right, x);
    else 
        return search(root->left, x);
}


void inorder(struct node* root) {
    if(root != NULL) {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);
    }
}
void preorder(struct node* root) {
    if(root != NULL) {
        printf("%d ", root->data);
        preorder(root->left);
        preorder(root->right);
    }
}
void postorder(struct node* root) {
    if(root != NULL) {
        postorder(root->left);
        postorder(root->right);
        printf("%d ", root->data);
    }
}


struct node* delete(struct node* root, int x) {
    if(root == NULL)
        return root;
    if(x > root->data) 
        root->right = delete(root->right, x);
    else if(x < root->data)
        root->left = delete(root->left, x);
    else {
        if(root->left == NULL && root->right == NULL) {
            free(root);
            return NULL;
        } else if(root->left == NULL || root->right == NULL ) {
            struct node* temp;
            if(root->left == NULL)
                temp = root->right;
            else
                temp = root->left;

            free(root);
            return temp;
        } else {
            struct node *temp = find_min(root->right);
            root->data = temp->data;
            root->right = delete(root->right, temp->data);
        }
        return root;
    }
}


struct node* find_min(struct node* root) {
    if(root == NULL)
        return NULL;
    else if(root->left != NULL) 
        return find_min(root->left);
    return root;
}