
#include <stdio.h>
#include <stdlib.h>

#define MAX 20

int stack[MAX], top = 0;
int visited[MAX];
int adj[MAX][MAX];  // adjacency matrix
int n;              // number of vertices

void dfs(int s) {
    stack[++top] = s;
    visited[s] = 1;

    while (top >= 0) {
        int node = stack[top--];
        printf("%d ", node);

        for (int i = n; i >= 1; i--) {
            if (adj[node][i] == 1 && visited[i] == 0) {
                stack[++top] = i;
                visited[i] = 1;
            }
        }
    }
}

int main() {
    printf("Enter number of vertice(nodes): ");
    scanf("%d", &n);

    printf("Enter adjacency matrix (%d x %d):\n", n, n);
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            scanf("%d", &adj[i][j]);
        }
    }

    // initialize visited array
    for (int i = 1; i <= n; i++) {
        visited[i] = 0;
    }

    int start;
    printf("Enter starting vertex(node): ");
    scanf("%d", &start);

    printf("DFS Traversal: ");
    dfs(start);

    return 0;
}

