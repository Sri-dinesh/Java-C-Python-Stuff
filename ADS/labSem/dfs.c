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
1.  Global Variables:
    ->   n: Number of vertices.
    ->   visited[MAX]: Array to keep track of visited nodes (0 = not visited, 1 = visited).
    ->   adj[MAX][MAX]: Adjacency matrix to store the graph connections (1 = edge exists).

2.  Create Graph Function (create_graph):
    ->   Input: Ask for the number of vertices (n).
    ->   Loop: Run a loop for maximum possible edges (n -> (n-1)).
    ->   Edge Input: Ask for origin and destin for each edge.
    ->   Exit Condition: If user enters -1 -1, break the loop.
    ->   Validation: Check if vertices are valid (0 to n-1). If invalid, decrement counter c and retry.
    ->   Store: Set adj[origin][destin] = 1 to mark the edge.

3.  DFS Function (dfs(int i)):
    ->   Print & Mark: Print the current node i and mark it as visited (visited[i] = 1).
    ->   Explore Neighbors: Loop through all possible vertices (j from 0 to n).
    ->   Condition: If node j is NOT visited AND there is an edge from i to j (adj[i][j] == 1).
    ->   Recurse: Call dfs(j) to go deeper.

Easy Memory Trick:
->   Setup: Remember 3 globals: n, visited[], adj[][].
->   Graph Creation: Just a loop asking for "from" and "to" until "-1 -1".
->   DFS Logic: "Visit, Print, Loop".
    1. Print current.
    2. Mark current.
    3. Loop neighbors: If (Not Visited && Connected) -> Go there dfs(j).
*/