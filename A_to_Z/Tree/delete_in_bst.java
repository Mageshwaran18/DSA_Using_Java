package Tree;

/* LeetCode No :- 450 */


/*
 * Optimal Approach --> If the node to be deleted is leaf node , make the node as null
 *                  --> If the node to be deleted contains only the left , replace with the left 
 *                  --> If the node to be deleted contains only the right , replace with the right 
 *                  --> If the node contains the both the left and right child , replace them with 
 *                          --> Minimum value from the right subtree or Maximum value from the left subtree with the node to be deleted
 * 
 */
public class delete_in_bst {

    public static class Node
    {
        int data ; 
        Node left;
        Node right;

        Node(){}

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static class Tree
    {
        private Node root;

        Tree()
        {
            this.root = null;
        }

        public void insert(int data)
        {
            Node nn = new Node(data);
            if(root==null)
            {
                root = nn;
            }
            else
            {
                Node cur = root;
                Node parent = null;
                // System.out.print("Inserting at :-");
                while(true)
                {
                    parent = cur ; 
                    // System.out.print(parent.data + "->");
                    if(cur.data < data)
                    {
                        cur = cur.right;
                        if(cur==null)
                        {
                            parent.right=nn;
                            // System.out.println();
                            return;
                        }
                    }
                    else
                    {
                        cur = cur.left;
                        if(cur==null)
                        {
                            parent.left=nn;
                            // System.out.println();
                            return;
                        }
                    }
                }
            }
        }

        private void inOrder(Node root){
            if(root!=null){
               inOrder(root.left );
               System.out.print(root.data + " ");            
               inOrder(root.right );
            }
         }
        
        public int successor(Node root)
        {
            Node temp = root;
            while(temp.left!=null)
            {
                temp = temp.left;
            }
            return temp.data;

        }

        private Node deletNode(Node root , int target)
        {
            if(root==null)
            {
                return null;
            }
            if(root.data > target)
            {
                root.left = deletNode(root.left, target);
            }
            if(root.data < target)
            {
                root.right = deletNode(root.right, target);
            }
            else
            {
                if(root.left!=null && root.right==null)
                {
                    return root.left;
                }
                else if(root.right!=null && root.left==null)
                {
                    return root.right;
                }
                else
                {
                    int successor = successor(root.right);
                    root.right = deletNode(root.right, successor);
                    root.data = successor;
                }
            }
            return root;
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
        System.out.print("Tree before the deletion :- ");
        tree.inOrder(tree.root);
        /*
        Tree structure after insertion:
        
             11
           /    \
          3      20
         / \    /  \
        9   4  16  42
       /          /  \
      10         32  54
        */

        tree.deletNode(tree.root, 20);

    }
    
}
