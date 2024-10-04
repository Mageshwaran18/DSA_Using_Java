package Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * See the recursion function you can understand easily 
 * (1) Assign the leftchild to the rightchild 
 * (2) Assign the rightchild to the leftchild
 * 
 */

public class mirror {
    public  static class Tree {
      private Node root;
   
      public Tree(){
         root = null;
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
                        cur = cur.rightChild;
                        if(cur==null)
                        {
                            parent.rightChild=nn;
                            // System.out.println();
                            return;
                        }
                    }
                    else
                    {
                        cur = cur.leftChild;
                        if(cur==null)
                        {
                            parent.leftChild=nn;
                            // System.out.println();
                            return;
                        }
                    }
                }
            }
        }

      public Node mirror(Node root)
      {
        if(root==null)
        {
            return null;
        }

        Node left = mirror(root.leftChild);
        Node right = mirror(root.rightChild);

        root.leftChild = right;
        root.rightChild = left;
        
        return root;
      }
      public void display(Node root)
        {
            if(root!=null)
            {
                display(root.leftChild);
                System.out.print(root.data + " ");
                display(root.rightChild);

            }
        }  

   }
   
   public static class Node {
      public int data;
      public Node leftChild;
      public Node rightChild;
   
      public Node(){}

      public Node(int data)
      {
         this.data = data;
         this.rightChild = null;
         this.leftChild = null;
      }
   
      public void display(){
         System.out.print("("+data+ ")");
      }

   }
   public static void main(String[] args){
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
     * Original Tree Structure:
     *          11
     *        /    \
     *       3      20
     *      / \    /  \
     *     9   4  16  42
     *    /           / \
     *   10          32 54
     */

    /*
     * Tree Structure After Mirroring Alternate Levels:
     *          11
     *        /    \
     *      20      3
     *     /  \    / \
     *    42  16  4   9
     *   / \         /
     *  54 32       10
     */

    tree.mirror(tree.root);
    System.out.print("After mirroring the tree :- ");
    tree.display(tree.root);


   }
}
