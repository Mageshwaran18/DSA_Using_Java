/**
 * Implements a binary search tree (BST) with recursive insertion.
 * The `bst_insert_recursion` class provides a `Node` class to represent a node in the BST,
 * and a `Tree` class to manage the overall BST structure, including the root node.
 * The `insert` method recursively inserts a new node with the given data value into the BST.
 * The `display` method performs an in-order traversal of the BST and prints the node values.
 */
package Tree;

public class bst_insert_recursion {

    public static class Node
    {
        int data;
        Node right;
        Node left;

        Node(){}
        Node(int data)
        {
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }
    
    public static class Tree
    {
        public Node root;

        Tree()
        {
            this.root=null;
        }

        public Node insert(Node root,int data)
        {
            if(root==null)
            {
                root = new Node(data);
                return root;    /* Even if the root value is changed , during the back tracking it will be corrected by itself */
            }
            if(root.data > data)
            {
                root.left = insert(root.left, data);
            }
            else
            {
                root.right = insert(root.right, data);
            }
            return root;
        }

        public void display(Node root)
        {
            if(root!=null)
            {
                display(root.left);
                System.out.print(root.data + " ");
                display(root.right);

            }
        }  
    }

    public static void main(String[] args) {
        
        Tree tree = new Tree();
        tree.root=tree.insert(tree.root,11);
        tree.insert(tree.root,20);
        tree.insert(tree.root,3);        
        tree.insert(tree.root,42);
        tree.insert(tree.root,54);
        tree.insert(tree.root,16);
        tree.insert(tree.root,32);
        tree.insert(tree.root,9);
        tree.insert(tree.root,4);
        tree.insert(tree.root,10);

        tree.display(tree.root);

    }

}
