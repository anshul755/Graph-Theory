# Practical 6 - Prufer Code and Spanning Tree Generation

## Aim
Work with Prufer code representations of trees and generate spanning trees from them.

## What This Practical Does
This practical includes three related programs:
- convert a Prufer sequence into a tree
- generate the Prufer code from a tree
- generate all labeled spanning trees for `n` vertices using all possible Prufer sequences

## Files
- `P6a.java`: converts a Prufer code into its corresponding tree edges
- `P6b.java`: generates a Prufer code from an input tree
- `P6c.java`: generates all spanning trees for `n` labeled vertices

## Key Concepts Covered
- trees
- Prufer sequence
- tree encoding
- tree decoding
- Cayley's formula
- spanning tree generation

## How to Run
Compile:
```bash
javac -d . P6a.java P6b.java P6c.java
```

Run:
```bash
java P6.P6a
java P6.P6b
java P6.P6c
```

## Program Flow
`P6a.java` decodes a Prufer sequence into tree edges.

`P6b.java` reads a tree and repeatedly removes the smallest leaf to produce the Prufer code.

`P6c.java` generates every possible Prufer sequence for a given `n` and prints the corresponding spanning tree.

## Learning Outcome
After this practical, you can move between trees and their Prufer representations and relate labeled trees to combinatorial generation.
