package Tree;


import java.util.*;

public class bst_tree_impl_search_insert
 {
   public  static class Tree {
      private Node root;
   
      public Tree(){
         root = null;
      }
      
      public Node search(int data){
         Node current = root;
         System.out.print("Visiting elements: ");
         while(current.data != data){
            if(current != null)
               System.out.print(current.data + " "); 
               if(current.data > data){
                  current = current.leftChild;
               }
               else{                
                  current = current.rightChild;
               }
               if(current == null){
                  return null;
               }
            }
         return current;
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
                System.out.print("Inserting at :-");
                while(true)
                {
                    parent = cur ; 
                    System.out.print(parent.data + "->");
                    if(cur.data < data)
                    {
                        cur = cur.rightChild;
                        if(cur==null)
                        {
                            parent.rightChild=nn;
                            System.out.println();
                            return;
                        }
                    }
                    else
                    {
                        cur = cur.leftChild;
                        if(cur==null)
                        {
                            parent.leftChild=nn;
                            System.out.println();
                            return;
                        }
                    }
                }
            }
        }
   
      

      public static void levelorder(Node root)
      {

         Queue<Node> q1 = new LinkedList<>();
         q1.offer(root);
         while(!q1.isEmpty())
         {
            Node temp = q1.poll();
            System.out.print(temp.data + " ");
            if(temp.leftChild!=null)
            {
               q1.offer(temp.leftChild);
            }
            if(temp.rightChild!=null)
            {
               q1.offer(temp.rightChild);
            }
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
       Node node = tree.search(32);
       if(node!=null){
          System.out.print("Element found.");
          node.display();
          System.out.println();
       }else{
          System.out.println("Element not found.");
       }
 
       Node node1 = tree.search(2);
       if(node1!=null){
          System.out.println("Element found.");
          node1.display();
          System.out.println();
       }else{
          System.out.println("Element not found.");
       }              
    }
 }
 
 