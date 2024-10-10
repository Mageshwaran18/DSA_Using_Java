public class summa {

    // Java program to convert
// binary to decimal

// Function to convert
// binary to decimal
public static class GFG {
	static long binaryToDecimal(long n)
	{
		long num = n;
		long dec_value = 0;

		// Initializing base
		// value to 1, i.e 2^0
		long base = 1;

		long temp = num;
		while (temp > 0) {
			long last_digit = temp % 10;
			temp = temp / 10;

			dec_value += last_digit * base;

			base = base * 2;
		}

		return dec_value;
	}

}

public static void main(String[] args)
	{
		long num = 11101110010L;
        GFG bd = new GFG();
		System.out.println(bd.binaryToDecimal(num));
	}

// This code is contributed by mits.


    
    
}
