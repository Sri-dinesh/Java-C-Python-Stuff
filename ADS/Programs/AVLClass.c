#include <stdio.h>
#include <stdlib.h>

sturct node {
  int key;
  struct node *left;
  struct node *right;
  int height;
}

struct node *insert(struct node *r, int key) {
  if(r == NULL) {
    return (newnode(key));
  }
  else if(key < r->key) {
    r->left = insert(r->left, key);
  }
  else if(key > r->key) {
    r->right = insert(r->right, key);
  }
  else 
    return r;

  r->height = 1 + (max(height(r->left), height(r->right)));
  int balancer = getBalance(r);

  if(balance > 1 && key < r->left->key) {
    return rightRotation(r);
  }
  else if(balance < -1 && key > r->right->key) {
    return leftRotation(r);
  }
  else if(balance > 1 && key > r->left->key) {
    leftRotation(r->left);
    return rightRotation(r);
  }
  else if(balance < -1 && key < r->right->key) {
    r->right = rightRotation(r->right);
    return leftRotation(r);
  }
  else 
    return r;
}

