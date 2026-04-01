# Practical 1 - Graph Representations and Basic Graph Updates

## Aim
Build graphs using standard representations and perform basic update operations on the generated structure.

## What This Practical Does
This practical provides a menu-driven Java program to work with graphs using:
- adjacency matrix input
- adjacency list input
- incidence matrix input for directed and undirected graphs
- edge deletion in undirected graphs
- edge deletion in directed graphs
- vertex deletion from the graph

Internally, the graph is displayed as an adjacency-list-style structure.

## Files
- `P1.java`: main implementation for graph creation, conversion, display, and deletion operations

## Key Concepts Covered
- graph representation
- adjacency matrix
- adjacency list
- incidence matrix
- directed and undirected graphs
- edge deletion
- vertex deletion

## How to Run
Compile:
```bash
javac -d . P1.java
```

Run:
```bash
java P1.P1
```

## Program Flow
The program shows a menu and lets the user choose one graph task at a time. Based on the selected option, it:
1. accepts graph input
2. converts it into an adjacency-list-style structure
3. performs the requested operation
4. prints the resulting graph

## Sample Features
- create a graph from an adjacency matrix
- create a graph from adjacency list input
- create a graph from an incidence matrix
- remove an undirected edge
- remove a directed edge
- delete a vertex and update the graph

## Learning Outcome
After completing this practical, you can understand how the same graph can be represented in different forms and how simple graph modification operations affect the stored structure.
