package Tree;

/*LeetCode No : 236* 
* Refer https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
* Refer the hand written notes
*/

/*
 * Find the Path approach (Two traversal) --> Find the path for the int p in the given tree , store that in a array
 *                        --> Find the path for the int q in the given tree , store that in a array 
 *                        --> Compare the both arrays 
 *                              --> If arr1[i]!=arr2[i] , then arr1[i-1] is the Least common ancestor
 * 
 * Optimal approach (Single traversal) --> [Refer the notes and the code]
 *                                     --> (1) If the root is the P or Q then it's the Least common ancestor
 *                                     --> (2) If P is found on the leftsubtree and Q is found in the rightsubtree , then the current node is the Least Common Ancestor 
 *                                     --> (3) If not then search the elements in the left subtree and right subtree 
 *                                     --> (4) If ( leftsubtree contains P or Q ) or ( rightsubtree contains P or Q ) , then return respective nod ( right or left ) as they may be the LCA as the contains the required elements
 *                                     --> Repeat the steps 
 */

public class least_common_ancestors {

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

        public Node LCA (Node root , int p , int q)
        {
            if(root==null)
            {
                return null;
            }

            if(root.data == p || root.data ==q)
            {
                return root;
            }

            Node left = LCA(root.left,p,q);
            Node right = LCA(root.right,p,q);

            if(left!=null && right!=null)
            {
                return root;
            }

            return (left!=null) ? left : right;
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

        Node res = tree.LCA(tree.root, 4, 6);
        System.out.println("The Least Common Ancestors of 4 , 6 is :- " + res.data);


    }
    
}
