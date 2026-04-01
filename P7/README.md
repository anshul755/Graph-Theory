# Practical 7 - Graph Analysis on a Generated Social Network

## Aim
Analyze a graph using articulation points, bridges, and minimum cut concepts.

## What This Practical Does
This practical builds a graph of GitHub users, generates edges to simulate a community network, prints the graph, and then analyzes it using:
- articulation point detection
- bridge detection
- Karger's randomized minimum cut algorithm

## Files
- `P7.java`: program entry point
- `Graph.java`: graph data structure
- `Edge.java`: edge model
- `User.java`: user model
- `GitHubUserService.java`: user-fetching service
- `GraphGenerator.java`: graph generation logic
- `GraphPrinter.java`: graph display logic
- `GraphAnalyzer.java`: articulation point, bridge, and min-cut algorithms

## Key Concepts Covered
- articulation points
- bridges
- minimum cut
- depth-first search
- randomized graph algorithms
- graph modeling

## How to Run
Compile all Java files in the folder:
```bash
javac -d . *.java
```

Run:
```bash
java P7.P7
```

## Program Flow
1. fetch user data
2. generate graph edges
3. print the graph
4. find articulation points
5. find bridges
6. estimate the minimum cut using repeated Karger trials

## Learning Outcome
After this practical, you can see how multiple graph analysis techniques work together on a real-world inspired network model.
