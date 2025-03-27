package Know_Basic_Recursion;


/* Easy to understand --> Traverse untill the half of the length of the string , check the i and it's corresponding end string i */


public class valid_palindrome {

    public static String preprocess(String str)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i  < str.length() ; i++)
        {
            char c = str.charAt(i);
            if((c >=65 && c <= 90 ) || (c >=97 && c<=122) || (c>=48 && c<=57))
            {
                sb.append(Character.toLowerCase(c));
            }

        }
        return sb.toString();
    }

    public static boolean check(String str , int i)
    {
        if(i > str.length()/2)
        {
            return true;
        }

        if(str.charAt(i)!=str.charAt(str.length()-i-1))
        {
            return false;
        }

        return check(str, i+1);
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        String prestr = preprocess(str);

        System.out.println("Preprocessed string: " + prestr);
        
        boolean isPalindrome = check(prestr, 0);
        
        if (isPalindrome) {
            System.out.println("The string is a valid palindrome.");
        } else {
            System.out.println("The string is not a valid palindrome.");
        }
    }
    
}