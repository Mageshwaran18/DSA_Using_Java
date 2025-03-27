package Maths;

class count_digits
{
    public static int count_digits(int n)
    {
        int count = 0;
        while(n!=0)
        {
            n = n/10;
            count++;
        }
        return count;
    }

    public static void main(String args[])
    {
        int k =1234;
        System.out.println(count_digits(k));
    }
}