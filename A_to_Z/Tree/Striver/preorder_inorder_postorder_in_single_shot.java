import java.util.*;

/*
 * We are going to use iPair where it contains [TreeNode , Order]
 *              --> If order is 1
 *                      then add the node's value to the PreOrder , add it's left to the stack if not null , increment the order.
 *              --> If order is 2
 *                      then add the node's value to the InOrder , add it's right to the stack if not null , increment the order.
 *              --> If order is 3 
 *                      then pop the element , add the node's value to the PostOrder.
 * 
 * T.C :- O ( 3N ) ~ O( N ) --> At maximum all the nodes will be operated thrice. Where N is the number of nodes in the tree.
 * S.C :- O ( H ) --> H represent the height of the tree. At maximum the stack can hold H nodes in it. ( consider we are not considering the 3 arraylist ).
 * 
 */

class preorder_inorder_postorder_in_single_shot
{
    static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int val) {
                this.val = val;
            }
        }


    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    static class iPair{
        TreeNode node;
        int order;

        iPair(TreeNode node,int order)
        {
            this.node=node;
            this.order=order;
        }
    }


    public static List<List<Integer>> all_traversal(TreeNode root)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        Stack<iPair> st = new Stack<>();
        st.add(new iPair(root,1));
        while(!st.isEmpty())
        {
            iPair peek = st.peek();
        
            if(peek.order==1)
            {
                pre.add(peek.node.val);
                if(peek.node.left!=null)
                {
                    st.push(new iPair(peek.node.left,1));
                }
                peek.order++;
            }
            else if(peek.order==2)
            {
                in.add(peek.node.val);
                if(peek.node.right!=null)
                {
                    st.push(new iPair(peek.node.right,1));
                }
                peek.order++;
            }
            else
            {
                post.add(peek.node.val);
                st.pop();
            }
        }
        ans.add(pre);
        ans.add(in);
        ans.add(post);
        return ans;
    }

    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};

        TreeNode root = buildTree(input);

        List<List<Integer>> ans = all_traversal(root);
        int j = 0;
        String str[] = {"Preorder:- " ,  "Inorder :- ","Postorder :- "};
        for(List<Integer> order : ans)
        {
            System.out.print(str[j++]);
            for(int i : order)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
    }
}