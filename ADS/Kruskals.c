#include <stdio.h>

#define MAX 30

// Structure to represent an edge
struct Edge {
    int u, v, w;
};

// Find parent function for Union-Find
int find(int parent[], int i) {
    while (parent[i] != i)
        i = parent[i];
    return i;
}

// Union function
void unionSet(int parent[], int u, int v) {
    int pu = find(parent, u);
    int pv = find(parent, v);
    parent[pu] = pv;
}

int main() {
    int n, e;
    struct Edge edges[MAX], temp;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter number of edges: ");
    scanf("%d", &e);

    printf("Enter edges (u v w):\n");
    for (int i = 0; i < e; i++) {
        scanf("%d %d %d", &edges[i].u, &edges[i].v, &edges[i].w);
    }

    // Sort edges by weight (simple bubble sort)
    for (int i = 0; i < e - 1; i++) {
        for (int j = 0; j < e - i - 1; j++) {
            if (edges[j].w > edges[j + 1].w) {
                temp = edges[j];
                edges[j] = edges[j + 1];
                edges[j + 1] = temp;
            }
        }
    }

    int parent[MAX];
    for (int i = 0; i < n; i++)
        parent[i] = i;

    int count = 0, cost = 0;

    printf("\nEdges in Minimum Spanning Tree:\n");
    for (int i = 0; i < e && count < n - 1; i++) {
        int u = edges[i].u;
        int v = edges[i].v;

        if (find(parent, u) != find(parent, v)) {
            printf("%d - %d : %d\n", u, v, edges[i].w);
            cost += edges[i].w;
            unionSet(parent, u, v);
            count++;
        }
    }

    printf("\nTotal cost of MST = %d\n", cost);

    return 0;
}
