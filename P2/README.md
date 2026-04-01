# Practical 2 - Graph Operations on Two Graphs

## Aim
Implement common graph operations and compare relationships between two input graphs.

## What This Practical Does
This practical takes two graphs as input and performs set-style graph operations on them. The program also reports whether the graphs are vertex-disjoint, edge-disjoint, or identical.

The implementation supports:
- union
- intersection
- difference
- complement with respect to a universal graph
- ring sum (symmetric difference)
- fusion of two vertices

The folder also contains an additional maze-based BFS program.

## Files
- `P2.java`: graph operations and fusion on labeled graphs
- `P2b.java`: BFS-based path finding in a randomly generated maze

## Key Concepts Covered
- graph union
- graph intersection
- graph difference
- complement graph
- ring sum
- fusion of vertices
- breadth-first search
- path reconstruction

## How to Run
Compile:
```bash
javac -d . P2.java P2b.java
```

Run graph operations:
```bash
java P2.P2
```

Run maze BFS:
```bash
java P2.P2b
```

## Program Flow
`P2.java`:
1. accepts two graphs from the user
2. stores them as adjacency lists with labeled edges
3. performs the selected graph operation
4. prints the resulting graph

`P2b.java`:
1. generates a random maze with obstacles
2. runs BFS from a start cell to an end cell
3. reconstructs and displays the path if one exists

## Learning Outcome
After this practical, you can work with binary graph operations, compare graph relationships, and see how BFS can be used to solve path-finding problems on grid graphs.
