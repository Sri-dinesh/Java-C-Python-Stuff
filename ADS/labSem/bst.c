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

/*
================================================================================
                    BINARY SEARCH TREE (BST) - ALGORITHM
================================================================================

STRUCTURE:
----------
    struct node {
        int data
        struct node *left, *right
    }

--------------------------------------------------------------------------------
ALGORITHM: INSERT(root, x)
--------------------------------------------------------------------------------
    Step 1: IF root == NULL THEN
                Create new node with data = x
                left = right = NULL
                RETURN new node
            ENDIF
    Step 2: IF x > root->data THEN
                root->right = INSERT(root->right, x)
            ELSE
                root->left = INSERT(root->left, x)
            ENDIF
    Step 3: RETURN root

--------------------------------------------------------------------------------
ALGORITHM: SEARCH(root, x)
--------------------------------------------------------------------------------
    Step 1: IF root == NULL OR root->data == x THEN
                RETURN root
            ENDIF
    Step 2: IF x > root->data THEN
                RETURN SEARCH(root->right, x)
            ELSE
                RETURN SEARCH(root->left, x)
            ENDIF

--------------------------------------------------------------------------------
ALGORITHM: DELETE(root, x)
--------------------------------------------------------------------------------
    Step 1: IF root == NULL THEN RETURN NULL
    
    Step 2: IF x > root->data THEN
                root->right = DELETE(root->right, x)
            ELSE IF x < root->data THEN
                root->left = DELETE(root->left, x)
            ELSE                          // Found the node to delete
                CASE 1: No children (Leaf)
                    FREE root, RETURN NULL
                    
                CASE 2: One child
                    temp = (left != NULL) ? left : right
                    FREE root, RETURN temp
                    
                CASE 3: Two children
                    temp = FIND_MIN(root->right)  // Inorder successor
                    root->data = temp->data
                    root->right = DELETE(root->right, temp->data)
            ENDIF
    Step 3: RETURN root

--------------------------------------------------------------------------------
ALGORITHM: FIND_MIN(root)
--------------------------------------------------------------------------------
    Step 1: IF root == NULL THEN RETURN NULL
    Step 2: IF root->left != NULL THEN
                RETURN FIND_MIN(root->left)
            ELSE
                RETURN root
            ENDIF

--------------------------------------------------------------------------------
ALGORITHM: TRAVERSALS
--------------------------------------------------------------------------------
    INORDER(root):    Left → Root → Right    (Gives SORTED order)
    PREORDER(root):   Root → Left → Right    (Root FIRST)
    POSTORDER(root):  Left → Right → Root    (Root LAST)

================================================================================
📌 QUICK MEMORY TRICK:
================================================================================
    ✓ BST RULE: Left < Root < Right
    ✓ INSERT: Compare → Go Left/Right → Create at NULL
    ✓ SEARCH: Compare → Go Left/Right → Found or NULL
    ✓ DELETE 3 CASES:
        1. Leaf: Just remove
        2. One child: Replace with child
        3. Two children: Replace with INORDER SUCCESSOR (min of right)
    ✓ TRAVERSAL TRICK: 
        - INorder = IN the middle (L-Root-R)
        - PREorder = Root comes FIRST (Root-L-R)
        - POSTorder = Root comes LAST (L-R-Root)
================================================================================
*/