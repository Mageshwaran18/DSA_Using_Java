package Tree;

import java.util.LinkedList;
import java.util.Queue;


/* PreOrder --> RootNode, LeftNode, RightNode 
 * InOrder --> LeftNode, RootNode, RightNode
 * PostOrder --> LeftNode, RightNode, RootNode
 * LevelOrder --> Queue Implementation
 *            --> Add the root node to the Queue
 *            --> While the queue is not empty:
 *                (1) Remove the front node from the Queue and print its value
 *                (2) Add the left child of the node to the Queue (if exists)
 *                (3) Add the right child of the node to the Queue (if exists)
 *            --> Repeat until the queue is empty
 */


public class in_pre_post_level_Order {

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

        public void traverse(int traversalType){
            switch(traversalType){
               case 1:
                  System.out.print("\nPreorder traversal: ");
                  preOrder(root);
                  break;
               case 2:
                  System.out.print("\nInorder traversal: ");
                  inOrder(root);
                  break;
               case 3:
                  System.out.print("\nPostorder traversal: ");
                  postOrder(root);
                  break;
               
               case 4:
                  System.out.print("\nLevelOrder traversal: ");
                  levelorder();
                  break;
               }            
         }   
      
         private void preOrder(Node root){
            if(root!=null){
               System.out.print(root.data + " ");
               preOrder(root.left );
               preOrder(root.right );
            }
         }
      
         private void inOrder(Node root){
            if(root!=null){
               inOrder(root.left );
               System.out.print(root.data + " ");            
               inOrder(root.right );
            }
         }
      
         private void postOrder(Node root){
            if(root!=null){            
               postOrder(root.left );
               postOrder(root.right );
               System.out.print(root.data + " ");
            }
         }

        public void levelorder()
        {
            Queue <Node> q1 = new LinkedList<>();
            System.out.print("LevelOder :- ");
            q1.offer(root);
            while(!q1.isEmpty())
            {
                Node temp = q1.poll();
                System.out.print(temp.data + " ");
                if(temp.left!=null)
                {
                    q1.offer(temp.left);
                }
                if(temp.right!=null)
                {
                    q1.offer(temp.right);
                }
            }
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

        tree.traverse(1);
        tree.traverse(2);
        tree.traverse(3);
        tree.traverse(4);



    }
    
}
