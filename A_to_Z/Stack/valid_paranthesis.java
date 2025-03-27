package Stack;
import java.util.*;
import java.util.Stack;

/* LeetCode No:- 20  */

/* 
 * Optimal Approach :- --> Create an Stack , If incoming element is the opening paranthesis push to the stack
 *                     --> If the incoming element is the closing paranthesis 
 *                                  * if the incoming element is closing paranthesis and stack is empty (ex:- "}") return false.
 *                                  * if the peek of the stack is opening paranthesis of the corresponding incoming element pop it
 *                                  * if the peek of the stack is not the  opening paranthesis of the corresponding incoming element return false (ex:- "(})")
 *                     --> If the stack is empty then it's valid paranthesis  , else not.
 *                     --> Time Complexity :- O(n).
 */

public class valid_paranthesis {

    public static void main(String[] args) {

        String str = "([])";

        int flag = 0;
        
        Stack <Character> st = new Stack<Character>();
        HashMap<Character,Character> hm = new HashMap<>();
        hm.put('}', '{');
        hm.put(')', '(');
        hm.put(']', '[');

        for(int i = 0 ; i < str.length() ; i++)
        {
            if(st.empty() && hm.containsKey(str.charAt(i)))
            {
                System.out.println("It's not an valid Paranthesis");
                flag =1;
                break;
            }
            if(!hm.containsKey(str.charAt(i)))
            {
                st.push(str.charAt(i));
            }
            else
            {
                if(hm.get(str.charAt(i))==st.peek())
                {
                    st.pop();
                }
                else
                {
                    System.out.println("It's not an valid Paranthesis");
                    flag = 1;
                    break;
                }
            }
        }

        if(st.empty() && flag==0)
        {
            System.out.println("It's an valid Paranthesis");
        }
        else if (flag == 0)
        {
            System.out.println("It's not an valid Paranthesis");
        }



    }
    
}
