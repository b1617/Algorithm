package algo.ds;

public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	static int strDist(String a, String sub) {
		int len = sub.length();
		if (a.length() < len) {
			return 0;
		} else {
			if (a.substring(0, len).equals(sub) && a.substring(a.length() - len, a.length()).equals(sub)) {
				return a.length();
			} else {
				if (a.substring(0, len).equals(sub) && a.substring(a.length() - len, a.length()).equals(sub)) {
					return strDist(a.substring(1, a.length() - 1), sub);
				} else if (a.substring(0, len).equals(sub) && !a.substring(a.length() - len, a.length()).equals(sub)) {
					return strDist(a.substring(0, a.length() - 1), sub);
				} else {
					return strDist(a.substring(1), sub);
				}
			}
		}
	}

	static boolean nestParen(String a) {
		System.out.println(a);
		if (a.equals("")) {
			return true;
		} else {
			if (a.charAt(0) == '(' && a.charAt(a.length() - 1) == ')') {
				return nestParen(a.substring(1, a.length() - 1));
			} else {
				return false;
			}
		}
	}

	static boolean strCopies(String a, String sub, int n) {
		if (a.length() < sub.length()) {
			if (n == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			int len = sub.length();
			if (a.substring(0, len).equals(sub)) {
				return strCopies(a.substring(1), sub, n - 1);
			} else {
				return strCopies(a.substring(1), sub, n);
			}
		}
	}

	static int strCount(String a, String sub) {
		if (a.length() < sub.length()) {
			return 0;
		} else {
			int len = sub.length();
			if (a.substring(0, len).equals(sub)) {
				return 1 + strCount(a.substring(len), sub);
			} else {
				return strCount(a.substring(1), sub);
			}
		}
	}

	static String parenBit(String a) {
		if (a.length() < 2) {
			return "";
		} else if (a.charAt(0) == '(' && a.charAt(a.length() - 1) == ')') {
			return a;
		} else if (a.charAt(0) == '(') {
			return parenBit(a.substring(0, a.length() - 1));
		} else if (a.charAt(a.length() - 1) == ')') {
			return parenBit(a.substring(1));
		} else {
			return parenBit(a.substring(1, a.length() - 1));
		}
	}

	static int countHi2(String a) {
		if (a.length() < 3) {
			if (a.length() < 2) {
				return 0;
			} else {
				if (a.charAt(0) == 'h' && a.charAt(1) == 'i') {
					return 1;
				} else {
					return 0;
				}
			}
		} else {
			if (a.charAt(0) == 'x' && a.charAt(1) == 'h' && a.charAt(2) == 'i') {
				return countHi2(a.substring(3));
			} else if (a.charAt(0) == 'h' && a.charAt(1) == 'i') {
				return 1 + countHi2(a.substring(2));
			} else {
				return countHi2(a.substring(1));
			}
		}
	}

	static String stringClean(String a) {
		if (a.length() < 2) {
			return a;
		} else {
			if (a.charAt(0) == a.charAt(1)) {
				return stringClean(a.substring(1));
			} else {
				return a.charAt(0) + stringClean(a.substring(1));
			}
		}
	}

	static int count11(String a) {
		if (a.length() < 2) {
			return 0;
		} else {
			if (a.charAt(0) == '1' && a.charAt(1) == '1') {
				return 1 + count11(a.substring(2));
			} else {
				return count11(a.substring(1));
			}
		}
	}

	static int countAbc(String a) {
		if (a.length() < 3) {
			return 0;
		} else {
			int x = 0;
			if (a.charAt(0) == 'a' && a.charAt(1) == 'b' && (a.charAt(2) == 'c' || a.charAt(2) == 'a')) {
				x = 1;
			}
			return x + countAbc(a.substring(1));
		}
	}

	static int countPairs(String a) {
		if (a.length() < 3) {
			return 0;
		} else {
			if (a.charAt(0) == a.charAt(2)) {
				return 1 + countPairs(a.substring(1));
			} else {
				return countPairs(a.substring(1));
			}
		}
	}

	static String endX(String a) {
		if (a.length() < 1) {
			return a;
		} else {
			if (a.charAt(0) == 'x') {
				return endX(a.substring(1)) + a.charAt(0);
			} else {
				return a.charAt(0) + endX(a.substring(1));
			}
		}
	}

	static String pairStar(String a) {
		if (a.length() <= 1) {
			return a;
		} else {
			if (a.charAt(0) == a.charAt(1)) {
				return a.charAt(0) + "*" + pairStar(a.substring(1));
			} else {
				return a.charAt(0) + pairStar(a.substring(1));
			}
		}
	}

	static String allStar(String a) {
		if (a.length() <= 1) {
			return a;
		} else {
			return a.charAt(0) + "*" + allStar(a.substring(1));
		}
	}


	static boolean array220(int [] nums , int i) {
		if (i == nums.length-1 || nums.length == 0) {
			return false;
		} else {
			if (nums[i] * 10 == nums[i+1]) {
				return true;
			} else {
				return array220(nums , i+1);
			}
		}
	}

	static int array11(int[] nums, int i) {
		if (nums.length < 1) {
			return 0;
		} else if (i >= nums.length - 1) {
			if (nums[i] != 11) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (nums[i] == 11) {
				return 1 + array11(nums, i + 1);
			} else {
				return array11(nums, i + 1);
			}
		}
	}

	static boolean array6(int[] nums, int i) {
		if (nums.length < 1) {
			return false;
		} else if (i == nums.length - 1 && nums[i] != 6) {
			return false;
		} else {
			if (nums[i] == 6) {
				return true;
			} else {
				return array6(nums, i + 1);
			}
		}
	}

	static String noX(String a) {
		if (a.length() <= 1 && !a.equals("x")) {
			return a;
		} else {
			if (a.charAt(0) == 'x') {
				return "" + noX(a.substring(1));
			} else {
				return a.charAt(0) + noX(a.substring(1));
			}
		}
	}

	static String changePi(String a) {
		if (a.length() < 2) {
			return a;
		} else {
			if (a.substring(a.length() - 2, a.length()).equals("pi")) {
				return changePi(a.substring(0, a.length() - 2)) + "3.14";
			} else {
				return changePi(a.substring(0, a.length() - 1)) + a.charAt(a.length() - 1);
			}
		}
	}

	static String changeXY(String a) {
		if (a.length() <= 1 && !a.equals("x") && !a.equals("y")) {
			return a;
		} else {
			if (a.charAt(0) == 'x') {
				return "y" + changeXY(a.substring(1, a.length()));
			} else {
				return a.charAt(0) + changeXY(a.substring(1, a.length()));
			}
		}
	}

	static int countHi(String a) {
		if (a.length() < 2) {
			return 0;
		} else {
			if (a.substring(a.length() - 2, a.length()).equals("hi")) {
				return 1 + countHi(a.substring(0, a.length() - 1));
			} else {
				return countHi(a.substring(0, a.length() - 1));
			}
		}
	}

	static int countX(String a) {
		if (a.length() == 0) {
			return 0;
		} else if (a.length() == 1) {
			if (a.charAt(0) == 'x') {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (a.charAt(a.length() - 1) == 'x') {
				return 1 + countX(a.substring(0, a.length() - 1));
			} else {
				return countX(a.substring(0, a.length() - 1));
			}
		}
	}

	static int powerN(int base, int n) {
		if (n == 1) {
			return base;
		} else {
			return base * powerN(base, n - 1);
		}
	}

	static int count8(int n) {
		if (n < 8) {
			return 0;
		} else {
			if (n % 10 == 8 && (n / 10) % 10 == 8) {
				return 2 + count8(n / 10);
			} else if (n % 10 == 8) {
				return 1 + count8(n / 10);
			} else {
				return count8(n / 10);
			}
		}
	}

	static int count7(int n) {
		if (n < 7) {
			return 0;
		} else {
			if (n % 10 == 7) {
				return 1 + count7(n / 10);
			} else {
				return count7(n / 10);
			}
		}
	}

	static int sumDigits(int n) {
		if (n < 10) {
			return n;
		} else {
			return n % 10 + sumDigits(n / 10);
		}
	}

	static int triangle(int n) {
		if (n < 2) {
			return n;
		} else {
			return n + triangle(n - 1);
		}
	}

	static int bunnyEars3(int n) {
		if (n == 0) {
			return 0;
		} else {
			if (n % 2 == 0) {
				return 3 + bunnyEars3(n - 1);
			} else {
				return 2 + bunnyEars3(n - 1);
			}
		}
	}

	static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n < 3) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	static int bunnyEars(int n) {
		if (n == 0) {
			return 0;
		} else {
			return 2 + bunnyEars(n - 1);
		}
	}

	static long factorial(long n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

}
