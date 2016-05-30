public class BinarySearchGoodies {
	
	static int firstOccurrence(int x, int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		
		int pos = -1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (x == arr[middle]) {
				pos = middle;
				high = middle - 1;
			} else if (x < arr[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		
		return pos;
	}

	static int lastOccurrence(int x, int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		
		int pos = -1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (x == arr[middle]) {
				pos = middle;
				low = middle + 1;
			} else if (x < arr[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		
		return pos;
	}
	
	static int predecessor(int x, int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		
		int pos = -1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (x == arr[middle]) {
				high = middle - 1;
			} else if (x < arr[middle]) {
				high = middle - 1;
			} else {
				pos = middle;
				low = middle + 1;
			}
		}
		
		return pos;
	}
	
	static int successor(int x, int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		
		int pos = -1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (x == arr[middle]) {
				low = middle + 1;
			} else if (x < arr[middle]) {
				pos = middle;
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		
		return pos;
	}
	
	// ------------------------ UNIT TESTS -------------------------------
	
	public static void main(String[] args) {
		testFirstOccurrence0();
		testFirstOccurrence1();
		testFirstOccurrence2();
		testFirstOccurrence3();
		testFirstOccurrence4();
		
		testLastOccurrence0();
		testLastOccurrence1();
		testLastOccurrence2();
		testLastOccurrence3();
		testLastOccurrence4();
		
		testPredecessor0();
		testPredecessor1();
		testPredecessor2();
		testPredecessor3();
		testPredecessor4();
		
		testSuccessor0();
		testSuccessor1();
		testSuccessor2();
		testSuccessor3();
		testSuccessor4();
	}
	
	// TEST for firstOccurrence
	private static void testFirstOccurrence(String testName, int x, int[] numbers, int expected) {
        if(firstOccurrence(x, numbers) == expected) {
            System.out.println(testName + " passed.");
        }
        else {
            System.out.println(testName + " FAILED.");
        }
    }
	
	private static void testFirstOccurrence0() {
		int[] input = { 0 };
		int x = 0;
		int expected = 0;
		testFirstOccurrence("testFirstOccurrence0", x, input, expected);
	}
	
	private static void testFirstOccurrence1() {
		int[] input = { 0 };
		int x = 2;
		int expected = -1;
		testFirstOccurrence("testFirstOccurrence1", x, input, expected);
	}
	
	private static void testFirstOccurrence2() {
		int[] input = { 2, 2, 2, 2 };
		int x = 2;
		int expected = 0;
		testFirstOccurrence("testFirstOccurrence2", x, input, expected);
	}
	
	private static void testFirstOccurrence3() {
		int[] input = { 0, 1, 1, 2, 2, 3, 3 };
		int x = 1;
		int expected = 1;
		testFirstOccurrence("testFirstOccurrence3", x, input, expected);
	}
	
	private static void testFirstOccurrence4() {
		int[] input = { 1, 1, 1, 2, 2, 2 };
		int x = 1;
		int expected = 0;
		testFirstOccurrence("testFirstOccurrence4", x, input, expected);
	}
	
	// TEST for lastOccurrence
	private static void testLastOccurrence(String testName, int x, int[] numbers, int expected) {
        if(lastOccurrence(x, numbers) == expected) {
            System.out.println(testName + " passed.");
        }
        else {
            System.out.println(testName + " FAILED.");
        }
    }
		
	private static void testLastOccurrence0() {
		int[] input = { 0 };
		int x = 0;
		int expected = 0;
		testLastOccurrence("testLastOccurrence0", x, input, expected);
	}
	
	private static void testLastOccurrence1() {
		int[] input = { 0 };
		int x = 2;
		int expected = -1;
		testLastOccurrence("testLastOccurrence1", x, input, expected);
	}
	
	private static void testLastOccurrence2() {
		int[] input = { 2, 2, 2, 2 };
		int x = 2;
		int expected = 3;
		testLastOccurrence("testLastOccurrence2", x, input, expected);
	}
	
	private static void testLastOccurrence3() {
		int[] input = { 0, 1, 1, 2, 2, 3, 3 };
		int x = 1;
		int expected = 2;
		testLastOccurrence("testLastOccurrence3", x, input, expected);
	}
	
	private static void testLastOccurrence4() {
		int[] input = { 1, 1, 1, 2, 2, 2 };
		int x = 1;
		int expected = 2;
		testLastOccurrence("testLastOccurrence4", x, input, expected);
	}
	
	// TEST for predecessor
	private static void testPredecessor(String testName, int x, int[] numbers, int expected) {
        if(predecessor(x, numbers) == expected) {
            System.out.println(testName + " passed.");
        }
        else {
            System.out.println(testName + " FAILED.");
        }
    }
	
	private static void testPredecessor0() {
		int[] input = { 0 };
		int x = 0;
		int expected = -1;
		testPredecessor("testPredecessor0", x, input, expected);
	}
	
	private static void testPredecessor1() {
		int[] input = { 0 };
		int x = 2;
		int expected = 0;
		testPredecessor("testPredecessor1", x, input, expected);
	}
	
	private static void testPredecessor2() {
		int[] input = { 2, 2, 2, 2 };
		int x = 2;
		int expected = -1;
		testPredecessor("testPredecessor2", x, input, expected);
	}
	
	private static void testPredecessor3() {
		int[] input = { 0, 1, 1, 2, 2, 3, 3 };
		int x = 1;
		int expected = 0;
		testPredecessor("testPredecessor3", x, input, expected);
	}
	
	private static void testPredecessor4() {
		int[] input = { 1, 1, 1, 2, 2, 2 };
		int x = 2;
		int expected = 2;
		testPredecessor("testPredecessor4", x, input, expected);
	}
	
	// TEST for successor
	private static void testSuccessor(String testName, int x, int[] numbers, int expected) {
        if(successor(x, numbers) == expected) {
            System.out.println(testName + " passed.");
        }
        else {
            System.out.println(testName + " FAILED.");
        }
    }
	
	private static void testSuccessor0() {
		int[] input = { 0 };
		int x = 0;
		int expected = -1;
		testSuccessor("testSuccessor0", x, input, expected);
	}
	
	private static void testSuccessor1() {
		int[] input = { 0 };
		int x = 2;
		int expected = -1;
		testSuccessor("testSuccessor1", x, input, expected);
	}
	
	private static void testSuccessor2() {
		int[] input = { 2, 2, 2, 2 };
		int x = 2;
		int expected = -1;
		testSuccessor("testSuccessor2", x, input, expected);
	}
	
	private static void testSuccessor3() {
		int[] input = { 0, 1, 1, 2, 2, 3, 3 };
		int x = 1;
		int expected = 3;
		testSuccessor("testSuccessor3", x, input, expected);
	}
	
	private static void testSuccessor4() {
		int[] input = { 1, 1, 1, 2, 2, 2 };
		int x = 2;
		int expected = -1;
		testSuccessor("testSuccessor4", x, input, expected);
	}
}
