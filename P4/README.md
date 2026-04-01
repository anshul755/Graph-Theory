# Practical 4 - Eulerian Traversal Style Itinerary Reconstruction

## Aim
Reconstruct a valid itinerary from flight tickets using graph traversal.

## What This Practical Does
This practical implements the classic itinerary reconstruction problem. Each ticket is treated as a directed edge from one airport to another, and the algorithm builds the lexicographically smallest valid route starting from `JFK`.

The solution uses depth-first traversal with priority queues, which is closely related to Eulerian path construction.

## Files
- `P4.java`: itinerary reconstruction solution

## Key Concepts Covered
- directed graph modeling
- depth-first search
- priority queue ordering
- Eulerian-path-style traversal

## How to Run
Compile:
```bash
javac -d . P4.java
```

Run:
This file mainly contains the solution logic class and can be integrated with a driver or online judge style input setup.

## Program Flow
1. build a directed graph from ticket pairs
2. keep destinations in lexical order using a priority queue
3. recursively visit the next airport
4. build the final itinerary in reverse traversal order

## Learning Outcome
After this practical, you can model routing problems as graph traversal tasks and understand how DFS can be combined with ordered edge selection.
