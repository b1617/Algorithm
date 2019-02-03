package algo.ds.bitwise;

public class Bitwise {

//	0	0000
//	1	0001
//	2	0010
//	3	0011
//	4	0100
//	5	0101
//	6	0110
//	7	0111
//	8	1000
//	9	1001
//	10	1010

	public static void main(String[] args) {
		System.out.println(setBit(4, 1));
		System.out.println(unsetBit(7, 1));
		System.out.println(toggleBit(10, 2));
		System.out.println(checkBit(10, 1));
	}

	// set bit a the position i for the number n
	// left shift 1
	// n | 1
	public static int setBit(int n, int i) {
		return n |= (1 << i);
	}

	// unset bit a the position i
	// left shift 1
	// not 1
	// n & 1
	public static int unsetBit(int n, int i) {
		return n &= (~(1 << i));
	}

	// toggla bit a the position i
	// left shift 1
	// n ^ 1
	public static int toggleBit(int n, int i) {
		return n ^= (1 << i);
	}

	// check if bit is set a the position i
	// left shift 1
	// n & 1
	// return true if x == 0
	public static boolean checkBit(int n, int i) {
		int x = n & (1 << i);
		return x == 0;
	}

}