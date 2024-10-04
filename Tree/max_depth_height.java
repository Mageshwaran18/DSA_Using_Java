package Tree;


/*
 * Height of the tree --> No of edges   ( Hint :- root==null , return -1)
 * Depth of the tree --> No of vertices ( Hint :- root==null , return 0)
 * if a tree contains one node --> Depth = 1 , Height = 0 ;
 */

public class max_depth_height {

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

        public  int height(Node root)
    {
        if (root==null)
        {
            return -1;
        }
        int left_depth = height(root.left);
        int righ_depth = height(root.right);

        int max_depth = Math.max(left_depth,righ_depth);

        return max_depth + 1 ;
    }

    public  int depth(Node root)
    {
        if (root==null)
        {
            return 0;
        }
        int left_depth = depth(root.left);
        int righ_depth = depth(root.right);

        int max_depth = Math.max(left_depth,righ_depth);

        return max_depth + 1 ;
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

        System.out.println("Height of the tree is :- " + tree.height(tree.root));
        System.out.println("Depth of the tree is :- " + tree.depth(tree.root));

    }
}
