#include <stdio.h>

#define INF 999999

int main() {
    int n;
    printf("Enter number of vertices: ");
    scanf("%d", &n);

    int cost[n][n];
    printf("Enter the cost adjacency matrix (use 0 if no edge):\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &cost[i][j]);
            if (cost[i][j] == 0)
                cost[i][j] = INF; // No edge -> infinity
        }
    }

    int visited[n];
    for (int i = 0; i < n; i++)
        visited[i] = 0;

    visited[0] = 1; // Start from vertex 0
    int edges = 0, minCost = 0;

    printf("\nEdges in the Minimum Spanning Tree:\n");

    while (edges < n - 1) {
        int min = INF, u = -1, v = -1;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && cost[i][j] < min) {
                        min = cost[i][j];
                        u = i;
                        v = j;
                    }
                }
            }
        }

        printf("%d - %d : %d\n", u, v, min);
        visited[v] = 1;
        minCost += min;
        edges++;
    }

    printf("\nTotal cost of MST = %d\n", minCost);

    return 0;
}
