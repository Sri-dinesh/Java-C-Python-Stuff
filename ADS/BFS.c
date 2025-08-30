#include <stdio.h>
#include <stdlib.h>

#define MAX 20

int adj[MAX][MAX];  // adjacency matrix
int visited[MAX];
int queue[MAX];
int front = 1, rear = -1;
int n;  // number of vertices

void bfs(int s) {
    // reset 
    for (int i = 0; i < n; i++) {
        visited[i] = 0;
    }

    // enqueue start node
    rear++;
    queue[rear] = s;
    visited[s] = 1;

    while (front <= rear) {
        int node = queue[front];
        front++;
        printf("%d ", node);

        // check all neighbors
        for (int i = 0; i < n; i++) {
            if (adj[node][i] == 1 && visited[i] == 0) {
                rear++;
                queue[rear] = i;
                visited[i] = 1;
            }
        }
    }
}

int main() {
    int start;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter adjacency matrix (%d x %d):\n", n, n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &adj[i][j]);
        }
    }

    printf("Enter starting vertex: ");
    scanf("%d", &start);

    printf("BFS Traversal: ");
    bfs(start);

    return 0;
}

