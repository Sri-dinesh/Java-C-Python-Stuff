// #include <stdio.h>
// #include <stdlib.h>

// #define MAX 20

// int adj[MAX][MAX];  // adjacency matrix
// int visited[MAX];
// int queue[MAX];
// int front = 1, rear = -1;
// int n;  // number of vertices

// void bfs(int s) {
//     // reset 
//     for (int i = 0; i < n; i++) {
//         visited[i] = 0;
//     }

//     // enqueue start node
//     rear++;
//     queue[rear] = s;
//     visited[s] = 1;

//     while (front <= rear) {
//         int node = queue[front];
//         front++;
//         printf("%d ", node);

//         // check all neighbors
//         for (int i = 0; i < n; i++) {
//             if (adj[node][i] == 1 && visited[i] == 0) {
//                 rear++;
//                 queue[rear] = i;
//                 visited[i] = 1;
//             }
//         }
//     }
// }

// int main() {
//     int start;

//     printf("Enter number of vertices: ");
//     scanf("%d", &n);

//     printf("Enter adjacency matrix (%d x %d):\n", n, n);
//     for (int i = 0; i < n; i++) {
//         for (int j = 0; j < n; j++) {
//             scanf("%d", &adj[i][j]);
//         }
//     }

//     printf("Enter starting vertex: ");
//     scanf("%d", &start);

//     printf("BFS Traversal: ");
//     bfs(start);

//     return 0;
// }


#include <stdio.h>
#include <stdlib.h>

#define MAX 20

// Global variables
int adj[MAX][MAX];  // Adjacency matrix
int visited[MAX];   // Visited array
int queue[MAX];     // Array to act as a queue
int n;              // Number of vertices

// Function for Breadth-First Search
void bfs(int s) {
    // --- FIX 2: Initialize queue pointers here for reusability ---
    int front = 0;
    int rear = -1;

    // Reset the visited array for the current traversal
    for (int i = 0; i < n; i++) {
        visited[i] = 0;
    }

    // Enqueue the starting node
    rear++;
    queue[rear] = s;
    visited[s] = 1;

    // Loop until the queue is empty
    while (front <= rear) {
        // Dequeue the node at the front
        int node = queue[front];
        front++;

        printf("%d ", node);

        // Explore all neighbors of the dequeued node
        for (int i = 0; i < n; i++) {
            // If a neighbor exists and has not been visited, enqueue it
            if (adj[node][i] == 1 && visited[i] == 0) {
                rear++;
                queue[rear] = i;
                visited[i] = 1;
            }
        }
    }
    printf("\n");
}

int main() {
    int start;

    printf("Enter number of vertices: ");
    scanf("%d", &n);
    
    // --- IMPROVEMENT: Basic input validation ---
    if (n <= 0 || n > MAX) {
        printf("Invalid number of vertices. Must be between 1 and %d.\n", MAX);
        return 1;
    }

    printf("Enter adjacency matrix (%d x %d):\n", n, n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &adj[i][j]);
        }
    }

    printf("Enter starting vertex (0 to %d): ", n - 1);
    scanf("%d", &start);

    // --- IMPROVEMENT: Basic input validation ---
    if (start < 0 || start >= n) {
        printf("Invalid starting vertex.\n");
        return 1;
    }

    printf("BFS Traversal: ");
    bfs(start);

    return 0;
}