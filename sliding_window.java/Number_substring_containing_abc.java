public class Number_substring_containing_abc {
    

/*Leetcode no :- 1358 */

    public static void main(String[] args) {

        String str = "abcabc";
        int a = 0;
        int b = 0;
        int c = 0;
        int count = 0;
        int left =0;
        for(int i = 0 ; i < str.length() ; i++)
        {
            if(str.charAt(i)=='a')
            {
                a+=1;
            }
            else if (str.charAt(i)=='b')
            {
                b+=1;
            }
            else if (str.charAt(i)=='c')
            {
                c+=1;
            }
            while (a>=1 && b>=1 && c>=1)
            {
                count+=1+(str.length()-i-1);
                if(str.charAt(left)=='a')
                {
                    a-=1;
                }
                else if (str.charAt(left)=='b')
                {
                    b-=1;
                }
                else if (str.charAt(left)=='c')
                {
                    c-=1;
                }
                left++;
            }
        }
        System.out.println(count);
        

    }

}
