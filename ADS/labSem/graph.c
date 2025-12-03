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

/*
================================================================================
                    GRAPH (Adjacency Matrix) - ALGORITHM
================================================================================

VARIABLES:
----------
    n       : Number of vertices
    e       : Number of edges
    adj[][] : Adjacency matrix (2D array)

--------------------------------------------------------------------------------
ALGORITHM: CREATE GRAPH USING ADJACENCY MATRIX
--------------------------------------------------------------------------------
    Step 1: INPUT number of vertices (n)
    Step 2: INPUT number of edges (e)
    Step 3: Initialize adj[n][n] with all 0s
            FOR i = 0 TO n-1 DO
                FOR j = 0 TO n-1 DO
                    adj[i][j] = 0
                ENDFOR
            ENDFOR
    Step 4: FOR i = 1 TO e DO
                INPUT v1, v2              // Edge vertices
                adj[v1][v2] = 1           // Mark edge
                adj[v2][v1] = 1           // For undirected graph
            ENDFOR
    Step 5: END

--------------------------------------------------------------------------------
ALGORITHM: DISPLAY ADJACENCY MATRIX
--------------------------------------------------------------------------------
    Step 1: Print column headers (0 to n-1)
    Step 2: FOR i = 0 TO n-1 DO
                PRINT row number (i)
                FOR j = 0 TO n-1 DO
                    PRINT adj[i][j]
                ENDFOR
                PRINT newline
            ENDFOR
    Step 3: END

================================================================================
📌 QUICK MEMORY TRICK:
================================================================================
    ✓ ADJACENCY MATRIX = 2D array where:
        - adj[i][j] = 1 means edge from i to j
        - adj[i][j] = 0 means no edge
    
    ✓ UNDIRECTED GRAPH: adj[v1][v2] = adj[v2][v1] = 1 (symmetric matrix)
    ✓ DIRECTED GRAPH:   adj[v1][v2] = 1 only (one direction)
    
    ✓ STEPS TO REMEMBER:
        1. Get n (vertices) and e (edges)
        2. Initialize matrix with 0s
        3. For each edge, mark adj[v1][v2] = 1
        4. For undirected, also mark adj[v2][v1] = 1
    
    ✓ SPACE: O(n²) - Good for dense graphs
    ✓ TIME:  O(1) to check if edge exists
================================================================================
*/