# Trees by Striver [ https://youtu.be/_ANrF3FJm7I?feature=shared ]

## Order of the Tree problems

N -> No.of nodes in the tree.
H -> Height of the tree.
W -> Maximum width of the tree.

1.  DFS [ Preorder , Inorder , Postorder ]
2.  BFS / Level Order [https://leetcode.com/problems/binary-tree-level-order-traversal/description/]
3.  PreOrder [https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/] (Iterative approach , Single Stack)
4.  InOrder  [https://leetcode.com/problems/binary-tree-inorder-traversal/description/] (Iterative approach , Single Stack)
5.  PostOrder [https://leetcode.com/problems/binary-tree-postorder-traversal/description/] (Iterative approach , Single Stack)
6.  Pre,In,Post Order traveral in single shot [A_to_Z/Tree/Striver/preorder_inorder_postorder_in_single_shot.java] (Stack) [O(3N),O(H)]
7.  Height of a Tree recursion [https://leetcode.com/problems/maximum-depth-of-binary-tree/description/] (Recursion) [O(N),O(H)]
8.  Height of a Tree iterative [https://leetcode.com/problems/maximum-depth-of-binary-tree/description/] (Stack,PreOrder/PostOrder) [O(N),O(H)]
9.  Balanced Binary Tree [https://leetcode.com/problems/balanced-binary-tree/description/] (Height of a Tree) [O(N),O(H)]
10. Diameter of Binary Tree [https://leetcode.com/problems/diameter-of-binary-tree/description/] (Height of a Tree) [O(N),O(H)]
11. Binary Tree maximum path sum [https://leetcode.com/problems/binary-tree-maximum-path-sum/] (~ Height of a Tree ) [O(N),O(H)] 
12. Same Tree [https://leetcode.com/problems/same-tree/description/] (~Recursive approach) [O(N),O(H)]
13. Zig Zag Traversal of the Tree [https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/] (Level Order) [O(N),O(W)] 


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