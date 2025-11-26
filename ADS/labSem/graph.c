#include <stdio.h>

int main() {
    int n, e;
    int i, j, v1, v2;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter number of edges: ");
    scanf("%d", &e);

    int adj[20][20];

    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            adj[i][j] = 0;
        }
    }

    printf("\nEnter edges (u v) as vertex numbers (0 to %d):\n", n - 1);
    for (i = 0; i < e; i++) {
        printf("Edge %d: ", i + 1);
        scanf("%d %d", &v1, &v2);

        adj[v1][v2] = 1;
        adj[v2][v1] = 1;

        // If you want a directed graph, comment next line.
        // adj[v2][v1] = 0;  
    }

    printf("\nAdjacency Matrix:\n   ");
    for (i = 0; i < n; i++)
        printf("%3d", i);
    printf("\n");

    for (i = 0; i < n; i++) {
        printf("%3d", i);
        for (j = 0; j < n; j++) {
            printf("%3d", adj[i][j]);
        }
        printf("\n");
    }

    return 0;
}