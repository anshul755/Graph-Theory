# Graph Theory Lab

This repository contains Graph Theory lab practicals implemented in Java. Each practical is organized in its own folder (`P1` to `P9`) and is also tracked branch-wise in sprint format (`s1` to `s9`) for clean academic progress and GitHub history.

## Repository Structure
- `P1`: Graph representations and basic graph update operations
- `P2`: Graph operations, graph relationships, and maze BFS
- `P3`: Graph isomorphism checking
- `P4`: Itinerary reconstruction using graph traversal
- `P5`: Graphical sequence verification and construction
- `P6`: Prufer code, tree encoding/decoding, and spanning tree generation
- `P7`: Graph analysis using articulation points, bridges, and min cut
- `P8`: Planarity checking using graph bounds
- `P9`: Graph coloring using backtracking

## Sprint-Based Branches
This repository also follows sprint-based branch organization:
- `s1`: Practical 1
- `s2`: Practical 2
- `s3`: Practical 3
- `s4`: Practical 4
- `s5`: Practical 5
- `s6`: Practical 6
- `s7`: Practical 7
- `s8`: Practical 8
- `s9`: Practical 9

Each sprint branch represents the progress up to that practical. The `main` branch contains all practicals merged together.

## Practical Overview

### Practical 1
Focuses on graph creation using adjacency matrix, adjacency list, and incidence matrix. It also includes edge deletion and vertex deletion operations.

### Practical 2
Implements graph operations such as union, intersection, difference, complement, ring sum, and fusion. It also includes a BFS-based maze path finder.

### Practical 3
Checks whether two graphs are isomorphic by comparing graph properties and validating possible vertex mappings.

### Practical 4
Solves the itinerary reconstruction problem using depth-first traversal with lexical ordering.

### Practical 5
Verifies whether a degree sequence is graphical and constructs a valid graph when possible.

### Practical 6
Works with Prufer code to:
- decode a tree from a Prufer sequence
- generate a Prufer code from a tree
- generate all labeled spanning trees for `n` vertices

### Practical 7
Builds and analyzes a graph using:
- articulation points
- bridges
- Karger's minimum cut algorithm

### Practical 8
Performs a planarity check using bipartite testing and standard planar graph edge bounds.

### Practical 9
Solves the graph coloring problem using recursive backtracking.

## How to Run
Make sure Java JDK is installed.

Compile a practical:
```bash
javac -d . P1/P1.java
```

Run a practical:
```bash
java P1.P1
```

Use the same pattern for other practicals, for example:
```bash
javac -d . P5/P5.java
java P5.P5
```

For folders with multiple files such as `P6` and `P7`, compile all Java files in that folder.

## Documentation
Each practical folder contains its own `README.md` explaining:
- the aim of the practical
- what the code does
- the files included
- important graph theory concepts covered
- how to compile and run it

## Purpose of This Repository
This repository is intended for Graph Theory lab work, academic submission tracking, and clean sprint-wise version control using Git and GitHub.
