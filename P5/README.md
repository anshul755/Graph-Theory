# Practical 5 - Graphical Sequence Verification

## Aim
Check whether a degree sequence is graphical and construct a corresponding graph when possible.

## What This Practical Does
This practical reads a degree sequence and applies a Havel-Hakimi style process to determine whether a simple graph can be formed from it. If the sequence is graphical, the program prints the resulting adjacency list.

## Files
- `P5.java`: graphical sequence checker and graph constructor

## Key Concepts Covered
- degree sequence
- graphical sequence
- Havel-Hakimi method
- adjacency list construction

## How to Run
Compile:
```bash
javac -d . P5.java
```

Run:
```bash
java P5.P5
```

## Program Flow
1. input the number of vertices
2. input the degree sequence
3. validate degree bounds and parity
4. repeatedly connect the highest-degree vertex
5. print whether the sequence is graphical
6. print the constructed adjacency list if valid

## Learning Outcome
After this practical, you can test degree sequences for validity and understand how constructive graph realization works.
