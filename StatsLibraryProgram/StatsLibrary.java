import java.util.ArrayList;
import java.util.Random;
import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * Date: March 1-2023
 * This class has methods that will help with probability and applied statistics homework.
 * @author Brandon_Pacheco
 * @version 1.0
 */
public class StatsLibrary {
	
	/**
	 * This method will check if a integer list is sorted or not.
	 * @param list An arraylist of integers
	 * @return True if list is sorted. False if list is not sorted.
	 */
	private boolean isSorted(ArrayList<Integer> list) {
		for(int i = 0; i < list.size() - 1; i++) {
			if(list.get(i) > list.get(i + 1)) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * This method takes an unsorted integer list and sorts it using the insertion sort algorithm.
	 * Algorithm inspired by the book: Introduction to Algorithms 4th edition by Cormen, Leiserson, Rivest, and Stein.
	 * @param list An arraylist of integers.
	 * @return returns a sorted list from least to greatest.
	 */
	private ArrayList<Integer> insertionSort(ArrayList<Integer> list){
		for(int i = 1; i < list.size(); i++) {
			int key = list.get(i);
			int j = i - 1;
			while(j >= 0 && list.get(j) > key){
				int n = list.get(j);
				list.set(j + 1, n);
				j -= 1;
			}
			
			list.set(j+1, key);
		}
		return list;
	}
	
	/**
	 * This method makes an arraylist filled with random integers
	 * @return Returns a integer list of randomized numbers in random order.
	 */
	private ArrayList<Integer> listRandomized(){
		ArrayList<Integer> list = new ArrayList<>();
		Random rand = new Random();
		for(int i = 0; i < 9; i++) {
			int value = rand.nextInt(100) + 1;
			list.add(value);
		}
		
		return list;
	}


	/**
	 * This method finds the mean of an integer arraylist.
	 * @param list An arraylist that is filled with integers
	 * @return Returns a double value that is the mean. 0 otherwise.
	 */
	private double findMean (ArrayList<Integer> list) {
		
		if(!isSorted(list)) {
			list = insertionSort(list);
		}
		
		double sum = 0;
		//foreach loop formally known as enhanced for loop
		//foreach uses an iterator
		for(int singleElements : list) {
			sum += singleElements;
		}
		
		double result = sum / list.size();
		return result;
	}
	
	/**
	 * This method finds the median of an integer arraylist.
	 * @param list An arraylist that is filled with integers.
	 * @return Returns a double value that is the median. 0 otherwise.
	 */
	private double findMedian(ArrayList<Integer> list){

		if(!isSorted(list)) {
			list = insertionSort(list);
		}
		//two branches if length is even or odd
		double result = 0;
		
		if(list.size() % 2 != 0) {
			result = (double) list.get(list.size() / 2);
		}
		else {
			double left = (double) list.get((list.size() / 2) - 1);
			double right = (double) list.get(list.size() / 2);
			result = (left + right) / 2;
		}
		
	
                
		return result;
	}
	

	/**
	 * This method finds the mode of an integer arraylist 
	 * @param list An arraylist that is filled with integers.
	 * @return Returns an integer if that value was counted more than once and appeared the most than all other values. Returns a null value to signal that no value appeared more than once.
	 */
	private Integer findMode (ArrayList<Integer> list) {
		
		if(!isSorted(list)) {
			list = insertionSort(list);
		}
		
		
		int result = 0;
		int highest = 0;
		for(int i = 0; i < list.size(); i++) {
			int count = 0;
			int key = list.get(i);
			count++;
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(j) == key) {
					count++;
				}
				else {
					break;
				}
				
			}
			if(count > highest) {
				highest = count;
				result = key;
			}
			
		}
		
		if (highest == 1) {
			return null;
		}
		
		return result;
	}
	
	
	/**
	 * This method calculates the standard deviation of an integer list
	 * @param list A list of integer values
	 * @return Returns the standard deviation value.
	 */
	private Double standardDeviation(ArrayList<Integer> list) {
		double mean = findMean(list);
		double result = 0;
		
		
		for(int i = 0; i < list.size(); i++) {
			result += Math.pow((list.get(i) - mean), 2);
		}
		
		double s = Math.sqrt(result / (list.size() - 1));
		
		
		return s;
	}
	
	
	/**
	 * This method calculates the permutation when given two values: n, r
	 * @param n An int variable that represents the total "objects" in the problem.
	 * @param r An int variable that represents the given "object(s)" from n to rearrange at a time.
	 * @return Returns a BigInteger value of the calculated permutation.
	 */
	private BigInteger Permutations(int n, int r) 
	{
		
		if(r == 0) {
			//return 1
			return BigInteger.ONE;
		}
		
		if(n - 1 == n - r) {
			//return n
			return BigInteger.valueOf(n);
		}
		
		if(n == 0 && r == 0) {
			//return 1
			return BigInteger.ONE;
		}
		
		BigInteger result = BigInteger.ZERO;
		int t = n - r;
		
		for(int i = n; i > 0; i--)
		{
			if(i == t) {
				break;
			}
			else {
				if(i == n) 
				{
					result = BigInteger.valueOf(i).multiply(BigInteger.valueOf(i - 1));
					i--;
					if(i == t) 
					{
						break;
					}
				}
				else 
				{
					result = result.multiply(BigInteger.valueOf(i));
				}	
			}
			
		}
		return result;
		
	}
	
	/**
	 * This method calculates the combination value when given two values: n, r.
	 * @param n An int value that represents the total number of "objects" in the problem.
	 * @param r An int value that represents the total objects to take from n.
	 * @return Returns a BigInteger value of the calculated combinations.
	 */
	private BigInteger Combinations(int n, int r)
	{
		if(r == 0) {
			//return 1
			return BigInteger.ONE;
		}
		if(n - 1 == n - r) {
			//return n
			return BigInteger.valueOf(n);
		}
		
		if(n == 0 && r == 0) {
			//return 1
			return BigInteger.ONE;
		}
		
		BigInteger result = BigInteger.ZERO;
		BigInteger denom = BigInteger.ZERO;
		int t = n - r;
		
		for(int i = n; i > 0; i--)
		{
			if(i == t || i == r) {
				if(i == t) {
					t = 0;
				}
				else {
					r = 0;
				}
				break;
			}
			else {
				if(i == n) {
					result = BigInteger.valueOf(i).multiply(BigInteger.valueOf(i - 1));
					i--;
					if(i == t) {
						break;
					}
				}
				else {
					result = result.multiply(BigInteger.valueOf(i));
				}	
			}
			
		}
		if(r == 0) 
		{
			for(int i = t; i > 0; i--) 
			{
				if(i == t) 
				{
					denom = BigInteger.valueOf(i).multiply(BigInteger.valueOf((i - 1)));
					i--;
				}
				else 
				{
					denom = denom.multiply(BigInteger.valueOf(i));
				}	
			}
			
			result = result.divide(denom);
		}
		else if(t == 0) 
		{
			for(int i = r; i > 0; i--) 
			{
				if(i == r) 
				{
					denom = BigInteger.valueOf(i).multiply(BigInteger.valueOf((i - 1)));
					i--;
				}
				else 
				{
					denom = denom.multiply(BigInteger.valueOf(i));
				}	
			}
			
			result = result.divide(denom);
		}
		
		return result;
	}
	
	/**
	 * This method calculates the factorial (!) of a number.
	 * @param num An int value that is the number to be calculated
	 * @return Returns a BigInteger value that is the calculated factorial.
	 */
	private BigInteger Factorial(int num) {
		if(num == 0) {
			return BigInteger.ONE;
		}
		
		if(num == 1) {
			return BigInteger.ONE;
		}
		
		BigInteger result = BigInteger.ZERO;
		for(int i = num; i > 0; i--) {
			if (i == num) {
        			BigInteger I = BigInteger.valueOf(i);			
				result = I.multiply(BigInteger.valueOf(i - 1));
				i--;
				continue;
			}
			result = result.multiply(BigInteger.valueOf(i));
		}
		
		return result;
		
	}
	
	/**
	 * This method joins two sets of objects in what's called the union
	 * @param A An object arraylist 
	 * @param B An object arraylist
	 * @return Returns an arraylist that is the union of the two passed lists.
	 */
	private ArrayList<Object> union(ArrayList<Object> A, ArrayList<Object> B){
		ArrayList<Object> result = new ArrayList<>();
		for(int i = 0; i < A.size(); i++) {
			result.add(A.get(i));
		}
		
		for(int i = 0; i < B.size(); i++) {
			if(!result.contains(B.get(i)))
			{
				result.add(B.get(i));
			}
		}
		
		return result;
	}
	
	/**
	 * This method gets the intersection of two sets of objects
	 * @param A An arraylist of objects
	 * @param B An arraylist of objects
	 * @return Returns an arraylist that is the intersection of the two passed lists
	 */
	private ArrayList<Object> intersection(ArrayList<Object> A, ArrayList<Object> B){
		ArrayList<Object> C = new ArrayList<>();
		for(int i = 0; i < A.size(); i++) {
			if(B.contains(A.get(i))) {
				C.add(A.get(i));
			}
		}

		return C;
	}
	
	/**
	 * This method gets the complement of a subset of objects
	 * @param A An arraylist of objects which is the subset
	 * @param S An arraylist of objects which is the set.
	 * @return Returns an arraylist of objects that is the complement of the passed subset.
	 */
	private ArrayList<Object> complement(ArrayList<Object> A, ArrayList<Object> S){	
			S.removeAll(A);	
		return S;
	}
	
	/**
	 * This method calculates the binomial distribution.
	 * @param probability A double value that is the probability of success
	 * @param trials An int value that is the number of trials to run the experiment
	 * @param successes An int value that is the number of successful trials in the experiment
	 * @return Returns a BigDecimal value that is the calculated binomial distribution.
	 */
	private BigDecimal BinomialDistribution(double probability, int trials, int successes) {
		probability = probability * 100;
		double failureChance = (double)(100 - (int) probability) / 100;
		
		BigDecimal q = BigDecimal.valueOf(failureChance);
		q =  q.pow(trials - successes);
		BigDecimal p = BigDecimal.valueOf(probability / 100);
		p = p.pow(successes);

		BigInteger combo = Combinations(trials, successes);
		BigDecimal result = new BigDecimal(combo);
		p = p.multiply(q);
		result = result.multiply(p);
		result = result.multiply(BigDecimal.valueOf(100));
		return result;

	}
	
	/**
	 * This method calculates the Geometric Distribution.
	 * @param probability A double value that represents the probability of success.
	 * @param trials An int value that is the number of trials to run
	 * @return Result a BigDecimal that is the calculation of the Geometric Distribution.
	 */
	private BigDecimal GeometricDistribution(double probability, int trials) {
		double P = probability * 100;
		double failureChance = (double)(100 - (int) P) / 100;
		BigDecimal q = BigDecimal.valueOf(failureChance);
		q = q.pow(trials - 1);
		BigDecimal result = q.multiply(BigDecimal.valueOf(probability));
		return result;
	}
//----------------------------------------------------Testing Methods-------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------
	/**
	 * This method tests the mean method.
	 */
	public void testMean() {
	    System.out.println("\nTesting the Mean method");
	    ArrayList<Integer> list = listRandomized();
	    double result = findMean(list);
	    System.out.println(list);
	    System.out.format("mean is %.3f\n", result);

    }
	
	
	/**
	 * This method tests the median method.
	 */
	public void testMedian() {
	    System.out.println("\nTesting the Median method");
	    ArrayList<Integer> list = listRandomized();
	    double result = findMedian(list);
	    System.out.println(list);
	    System.out.println(result);

    }
	
	/**
	 * This method tests the mode method.
	 */
	public void testMode() {
	    System.out.println("\nTesting the Mode method");
	    ArrayList<Integer> list = listRandomized();
	    ArrayList<Integer> list2 = new ArrayList<>();
	    list2.add(2);
	    list2.add(3);
	    list2.add(4);
	    list2.add(5);
	    list2.add(5);
	    Integer result = findMode(list);
	    System.out.println(list);
	    if(result == null) {
	    	System.out.println("All elements appeared the same number of times");
	    }
	    else {
	    	System.out.println(result);
	    }
	    
	    result = findMode(list2);
	    if(result == null) {
	    	System.out.println("All elements appeared the same number of times");
	    }
	    else {
	    	System.out.println("The mode of " + list2 + " is: " + result);
	    }

	}
	
	/**
	 * This method tests the standard deviation method.
	 */
	public void testStandardDeviation() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(46);
		list.add(69);
		list.add(32);
		list.add(60);
		list.add(52);
		list.add(41);
		System.out.print("\nStandard deviation of " + list + "\nis ");
		System.out.format("%.3f\n",standardDeviation(list));
	}
	
	/**
	 * This method tests the union method.
	 */
	public void testUnion() {
		ArrayList<Object> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		A.add(6);
		
		ArrayList<Object> B = new ArrayList<>();
		B.add(4);
		B.add(5);
		B.add(6);
		B.add(7);
		B.add(8);
		B.add(9);
		
		System.out.println("\nUnion of "+ A + " And " + B 
		+ " is " + union(A,B));
	}
	
	/**
	 * This method tests the intersection method.
	 */
	public void testIntersection() {
		ArrayList<Object> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		A.add(6);
		
		
		ArrayList<Object> B = new ArrayList<>();
		B.add(4);
		B.add(5);
		B.add(6);
		B.add(7);
		B.add(8);
		B.add(9);
		System.out.println("\nIntersection of "+ A + " And " + B 
		+ " is " +intersection(A,B));
		
	}
	
	/**
	 * This method tests the complement method.
	 */
	public void testComplement() {
		ArrayList<Object> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		A.add(6);
		
		
		ArrayList<Object> S = new ArrayList<>();
		S.add(1);
		S.add(2);
		S.add(3);
		S.add(4);
		S.add(5);
		S.add(6);
		S.add(7);
		S.add(8);
		S.add(9);
		S.add(10);
		
		System.out.println("\nThe complement of subset A: " + A
				+" from the set S: " + S + " is \n" + complement(A,S));
	}
	
	/**
	 * This method tests all of testing methods that test the stats library class.
	 */
	public void testStatsLibrary() {
//		testMean();
//		testMedian();
//		testMode();
//		testStandardDeviation();
//		testUnion();
//		testIntersection();
//		testComplement();
//		testFactorial();
//		testPermutations();
//		testCombinations();
		testBinomialDistribution();
//		testGeometricDistribution();
	}
	
	/**
	 * This method tests the binomial distribution method.
	 */
	public void testBinomialDistribution() {
		System.out.println("\nTesting Binomial Distribution method");
		System.out.println("p = 80 percent of success, trials = 10, successes = 7");
		BigDecimal result = BinomialDistribution(.80, 10, 7);
		System.out.println("result: " + result.floatValue());

	}
	
	/**
	 * This method tests the factorial method.
	 */
	public void testFactorial() {
		System.out.println("\nFactorial of 12 is: " + Factorial(12));
	}
	
	/**
	 * This method tests the permutation method.
	 */
	public void testPermutations() {
		System.out.println("\nPermutation of 8 and 6 (8P6) is: "
				+ Permutations(8,6));
	}
	
	/**
	 * This method tests the combinations method
	 */
	public void testCombinations() {
		System.out.println("\nCombination of 52 and 2 (52C2) is: "
				+ Combinations(52,2));
	}
	
	/**
	 * This method tests the Geometric Distribution method
	 */
	public void testGeometricDistribution() {
		System.out.println("\nTesting Geometric Distribution method");
		System.out.println("p = 80 percent of success, trials = 10");
		BigDecimal result = GeometricDistribution(.8, 10);
		System.out.println("The geometric distribution is: " + result.toPlainString());
		
	}
}
