#include<stdio.h>
#include<stdlib.h>

// Definition -> maximum no of nodes in complete binary tree is 2^(h+1) - 1
// -> the mininum  no of nodes in complete binary tree is 2^h
    // -> the minimum height of a complete binary tree is [log^(n+1)base(2)-1]
    // -> the maximum height of binary tree is  log^(n)base2
    // -> the perfect binary tree is a binary tree if all the internal nodes have 2 chilren and all the leaf nodes are at the same level..
    // -> degenerate binary tree: left skew, right skew; is a tree in which all the internal have only 1 children, it can be left skew or right skew binary tree.
    // -> balanced binary tree : is a tree where left & right sub treee heights differ by not more than .
    // -> ex: avl, red block, b, b+    


    // -> Binary search tree: is a node based 
    struct BinaryTree
    {
        int data;
        struct BinaryTree* right;
        struct BinaryTree* left;
    };

    int main() {


        void insert() {
            
        }

        void search(struct BinaryTree *root, key) {
            struct node *temp = root;
            while(temp!= NULL) {

                if(temp == key) {
                    print("No elements");
                } else if( temp > key) {
                    temp = temp-> right;
                }   else {
                    temp = tem -> left;
                }

            }
        }

    
    }   