# Practical 8 - Planarity Check Using Graph Bounds

## Aim
Estimate whether an undirected graph is planar using standard edge bounds.

## What This Practical Does
This practical reads an undirected graph, checks whether it is bipartite, and then applies planarity bounds:
- for bipartite graphs: `E <= 2V - 4`
- for general simple planar graphs: `E <= 3V - 6`

For graphs with at most 4 vertices, the program directly reports the graph as planar.

## Files
- `P8.java`: planarity estimation program

## Key Concepts Covered
- planar graphs
- bipartite graphs
- breadth-first search coloring
- planar edge bounds

## How to Run
Compile:
```bash
javac -d . P8.java
```

Run:
```bash
java P8.P8
```

## Program Flow
1. input number of vertices and edges
2. build the adjacency list
3. check bipartiteness using BFS coloring
4. apply the relevant planarity inequality
5. print the result

## Learning Outcome
After this practical, you can use graph properties and theoretical bounds to quickly estimate planarity for input graphs.
