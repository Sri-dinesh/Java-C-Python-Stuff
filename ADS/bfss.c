#include<stdio.h>
#include<stdlib.h>
#define MAX 20



int adj[MAX][MAX];
int visited[MAX];
int queue[MAX];
int front = 0, rear = -1;
int n, i;  // number of vertices

void bfss(int s) {

        for(i = 0; i<= n; i++) {
            visited[i] = 0;
        }
            rear++;
            queue[rear] = s;
            visited[i] = 1;
            // front++;
            while(front <= rear ) {
                s = queue[front];
                printf("%d",s);
                front++;
                for(i = 0; i<= n; i++) {
                    if(adj[s][i] == 1 && visited[i] == 0) {
                        rear++;
                        queue[rear] = i;
                        visited[i] = 1;
                    }
                }
        }
    }


    int main() {
        printf("Enter number of vertices: ");
        scanf("%d", &n);
    
        printf("Enter adjacency matrix (%d x %d):\n", n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                scanf("%d", &adj[i][j]);
            }
        }
    
        int start;
        printf("Enter starting vertex: ");
        scanf("%d", &start);
    
        printf("BFS Traversal: ");
        bfss(start);
    
        return 0;
    }