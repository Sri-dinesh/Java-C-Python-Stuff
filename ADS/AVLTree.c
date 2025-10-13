#include<stdio.h>
#include<stdlib.h>

Struct node {
  int key;
  int height;
  struct node *left;
  struct node *right;
}

int main() {
  struct node *root = NULL;
  root = insert(root, 9);
  root = insert(root, 20);
  root = insert(root, 5);
  root = insert(root, 10);
  root = insert(root, 0);
  root = insert(root, 6);
  root = insert(root, 1);
  root = insert(root, 2);

  root = delete(root, 1);

  preorder(root);
  inorder(root);
  postorder(root);
}

struct node *delete(struct node *r, int key) {

}
