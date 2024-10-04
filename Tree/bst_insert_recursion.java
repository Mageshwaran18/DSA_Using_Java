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
                return root;
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
