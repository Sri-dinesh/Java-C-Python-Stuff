#include<stdio.h>
#define MAX 10

int n;
int visited[MAX];
int adj[MAX][MAX];

void create_graph();
void dfs(int i);

void main() {
    int v;
    create_graph();
    printf("Enter the starting vertex:\n");
    scanf("%d", &v);
    dfs(v);
}

void create_graph() {
    int origin, destin, c, max_edge;

    printf("Enter number of vertices: ");
    scanf("%d", &n);
    max_edge = n * (n - 1);

    for(c = 1; c <= max_edge; c++) {
        printf("Enter edge %d(-1 -1 to quit):", c);
        scanf("%d%d", &origin, &destin);

        if(origin == -1 && destin == -1)
            break;
        else if(origin >= n || destin >= n || origin < 0 || destin < 0) {
            printf("Inavlid edge!\n");
            c--;
        } else 
            adj[origin][destin] = 1;      
    }
}


void dfs(int i) {
    printf("%d", i);
    visited[i] = 1;
    for(int j = 0; j < n; j++) 
        if(!visited[j] && adj[i][j] == 1)
            dfs(j);
}

/*
================================================================================
                    DEPTH FIRST SEARCH (DFS) - ALGORITHM
================================================================================

GLOBAL VARIABLES:
-----------------
    n           : Number of vertices
    visited[]   : Array to track visited nodes (0 = not visited, 1 = visited)
    adj[][]     : Adjacency matrix (1 = edge exists, 0 = no edge)

--------------------------------------------------------------------------------
ALGORITHM: CREATE_GRAPH()
--------------------------------------------------------------------------------
    Step 1: INPUT number of vertices (n)
    Step 2: max_edge = n * (n - 1)
    Step 3: FOR c = 1 TO max_edge DO
                INPUT origin, destin
                IF origin == -1 AND destin == -1 THEN
                    BREAK
                ELSE IF origin or destin is INVALID THEN
                    PRINT "Invalid edge"
                    c = c - 1
                ELSE
                    adj[origin][destin] = 1
                ENDIF
            ENDFOR
    Step 4: END

--------------------------------------------------------------------------------
ALGORITHM: DFS(i)
--------------------------------------------------------------------------------
    Step 1: PRINT i
    Step 2: visited[i] = 1              // Mark as visited
    Step 3: FOR j = 0 TO n-1 DO
                IF visited[j] == 0 AND adj[i][j] == 1 THEN
                    DFS(j)              // Recursive call
                ENDIF
            ENDFOR
    Step 4: END

================================================================================
📌 QUICK MEMORY TRICK:
================================================================================
    ✓ DFS = "Go Deep Before Wide" (uses RECURSION/STACK)
    ✓ 3 GLOBALS: n, visited[], adj[][]
    
    ✓ DFS LOGIC - Remember "PML":
        P - PRINT current vertex
        M - MARK as visited (visited[i] = 1)
        L - LOOP through neighbors, if (not visited && connected) → recurse
    
    ✓ CREATE GRAPH:
        - Loop until -1 -1
        - Validate vertices (0 to n-1)
        - Set adj[origin][destin] = 1

    ✓ DFS vs BFS:
        - DFS uses STACK (recursion) → Goes DEEP first
        - BFS uses QUEUE → Goes WIDE first (level by level)
================================================================================
*/