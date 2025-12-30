# Overview
This project contains a Java implementation for creating and representing graphs using various data structures. It serves as a practical demonstration of graph theory concepts, specifically focusing on graph representations and conversions.

## Features
The program provides a command-line interface (CLI) with a menu-driven system to create graphs using three different methods:

1.  **Adjacency Matrix**:
    - Users can input a square matrix (NxN) where an entry acts as a weight or existence indicator (non-zero implies an edge).
    - Converts the matrix into an internal Adjacency List representation.

2.  **Adjacency List**:
    - Users establish a graph by specifying the degree (number of neighbors) and the specific neighbors for each vertex.
    - Directly builds the graph structure.

3.  **Incidence Matrix**:
    - Supports both **Directed** and **Undirected** graphs.
    - **Directed**: Uses `1` for outgoing edges and `-1` for incoming edges.
    - **Undirected**: Uses `1` to indicate incidence (an edge responding to two vertices).
    - Converts the incidence matrix into an internal Adjacency List representation.

## How to Run
1.  **Prerequisites**: Ensure you have Java (JDK) installed on your system.
2.  **Compilation**:
    Open your terminal or command prompt in the source directory and run:
    ```bash
    javac -d . P1.java
    ```
3.  **Execution**:
    Run the compiled class file:
    ```bash
    java graphTheoryP1.P1
    ```

## Usage
Upon running the program, you will be presented with a menu:
```text
--- Graph Creation Menu ---
1. Adjacency Matrix
2. Adjacency List
3. Incidence Matrix
0. Exit
Enter your choice: 
```
Select an option by entering the corresponding number and follow the on-screen prompts to input your graph data. The program will then display the generated graph structure as an adjacency list.