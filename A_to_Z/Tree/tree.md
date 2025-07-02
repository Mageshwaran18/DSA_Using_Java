# Trees by Striver [ https://youtu.be/_ANrF3FJm7I?feature=shared ]

## Order of the Tree problems

1. DFS [ Preorder , Inorder , Postorder ]
2. BFS / Level Order [ ]
# Binary Trees Overview

This README provides an overview of binary trees, their components, and their types, based on the concepts outlined in Striver's video on Trees (YouTube Link).

## What is a Binary Tree?

A binary tree is a hierarchical data structure in which each node has at most two children.

## Key Components of a Binary Tree

- **Root**: The topmost node of a binary tree, from which all other nodes descend. It has no parent.
- **Children**: Nodes directly connected to a parent node. In a binary tree, a node can have up to two children (left and right).
- **Leaf Node**: A node with no children (i.e., both left and right child pointers are null).

## What is a Subtree?

A subtree is a portion of a binary tree consisting of a node and all its descendants (including the node itself).

## What are Ancestors?

The ancestors of a node are all the nodes along the path from the root to that node, excluding the node itself.

## What is a Left-Skewed and Right-Skewed Tree?

- **Left-Skewed Tree**: A binary tree where every node has only a left child (or no children), resembling a linked list slanting to the left.
- **Right-Skewed Tree**: A binary tree where every node has only a right child (or no children), resembling a linked list slanting to the right.

## Types of Binary Trees

### Full Binary Tree

- **Definition**: Every node has either 0 or 2 children.
- **Valid Example**:

  ```
      A
     / \
    B   C
   / \
  D   E
  ```
- **Invalid Example**:

  ```
      A
     /
    B
  ```

### Complete Binary Tree

- **Definition**: All levels are completely filled except the last level. 
                  The last level has all nodes as far left as possible.
- **Valid Example**:

  ```
      A
     / \
    B   C
   /
  D
  ```
- **Invalid Example**:

  ```
      A
     / \
    B   C
     \
      D
  ```
  - **Explanation**: Node D is on the right side of the last level, not as far left as possible.

### Perfect Binary Tree

- **Definition**: A binary tree where all internal nodes have two children and all leaf nodes are at the same level.
- **Valid Example**:

  ```
      A
     / \
    B   C
   / \ / \
  D  E F  G
  ```
- **Invalid Example**:

  ```
      A
     / \
    B   C
   /
  D
  ```
  - **Explanation**: Leaf nodes (D, C) are at different levels (D at level 2, C at level 1).

### Balanced Binary Tree

- **Definition**: The height of a tree at max should be O(log n), where n is the number of nodes in the tree.
- **Invalid Example**:

  ```
      A
     /
    B
   /
  C
  ```
  - **Explanation**: The height is 2 for 3 nodes, which is not O(log n), resembling a linear structure.

### Degenerate Tree

- **Definition**: A binary tree where each node has at most one child, effectively resembling a linked list (either left-skewed or right-skewed).
- **Valid Example**:

  ```
      A
       \
        B
         \
          C
  ```

### Traversal 

- **DFS** : DFS of a tree can be done by Inorder (Left,Root,Right), PreOrder , PostOrder. 
- **BFS** : In trees BFS can be done by Level order traversal.