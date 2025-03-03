package Tree;
import java.util.*;

/* LeetCode:- 103  https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/ */

public class zig_zag_traversal {
    
    public static class Node {
        int data;
        Node left;
        Node right;

        Node() {}

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Tree {
        private Node root;

        Tree() {
            this.root = null;
        }

        public void insert(int data) {
            Node nn = new Node(data);
            if (root == null) {
                root = nn;
            } else {
                Node cur = root;
                Node parent = null;
                while (true) {
                    parent = cur;
                    if (cur.data < data) {
                        cur = cur.right;
                        if (cur == null) {
                            parent.right = nn;
                            return;
                        }
                    } else {
                        cur = cur.left;
                        if (cur == null) {
                            parent.left = nn;
                            return;
                        }
                    }
                }
            }
        }

        public List<List<Integer>> zig_zag_traversal() {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            boolean left_to_right = true;

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> levelNodes = new ArrayList<>(levelSize);

                for (int i = 0; i < levelSize; i++) {
                    Node node = queue.poll();

                    if (left_to_right) {
                        levelNodes.add(node.data);
                    } else {
                        levelNodes.add(0, node.data);
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                result.add(levelNodes);
                left_to_right = !left_to_right;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(11);
        tree.insert(20);
        tree.insert(3);        
        tree.insert(42);
        tree.insert(54);
        tree.insert(16);
        tree.insert(32);
        tree.insert(9);
        tree.insert(4);
        tree.insert(10);
    }
}
