# Practical 9 - Graph Coloring Using Backtracking

## Aim
Solve the graph coloring problem for a given number of colors using backtracking.

## What This Practical Does
This practical reads a graph and a color limit `m`, then tries to assign colors to all vertices so that no adjacent vertices share the same color. If a valid assignment exists, the program prints the color chosen for each vertex.

## Files
- `P9.java`: m-coloring backtracking solution

## Key Concepts Covered
- graph coloring
- backtracking
- constraint satisfaction
- adjacency matrix representation

## How to Run
Compile:
```bash
javac -d . P9.java
```

Run:
```bash
java P9.P9
```

## Program Flow
1. input number of vertices, edges, and colors
2. build the graph as an adjacency matrix
3. try colors vertex by vertex
4. backtrack when a color assignment is invalid
5. print the solution if one exists

## Learning Outcome
After this practical, you can understand how recursive backtracking is applied to the graph coloring problem.
