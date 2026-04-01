# Practical 3 - Graph Isomorphism Check

## Aim
Determine whether two graphs are isomorphic using structural comparison and mapping validation.

## What This Practical Does
This practical accepts two graphs and checks whether they are isomorphic. It first compares basic properties such as vertex count, edge count, and degree sequence, and then tries possible vertex mappings to verify structural equivalence.

## Files
- `P3.java`: graph isomorphism checker

## Key Concepts Covered
- graph isomorphism
- degree sequence
- edge comparison
- permutation-based mapping
- adjacency validation

## How to Run
Compile:
```bash
javac -d . P3.java
```

Run:
```bash
java P3.P3
```

## Program Flow
1. input Graph 1
2. input Graph 2
3. compare number of vertices and edges
4. compare sorted degree sequences
5. try mappings and verify whether edges are preserved

## Learning Outcome
After this practical, you can understand how graph isomorphism can be approached using graph invariants followed by explicit mapping verification.
