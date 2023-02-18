import java.util.ArrayList;
import java.util.Random;
import java.math.BigInteger;
/**
 * @author Brandon_Pacheco
 * @version Jan 26, 2023
 *
 */
public class StatsLibrary {
	
	public boolean isSorted(ArrayList<Integer> list) {
		for(int i = 0; i < list.size() - 1; i++) {
			if(list.get(i) > list.get(i + 1)) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<Integer> insertionSort(ArrayList<Integer> list){
		for(int i = 1; i < list.size(); i++) {
			int key = list.get(i);
			int j = i - 1;
			int k = list.get(j);
			while(j >= 0 && list.get(j) > key){
				int n = list.get(j);
				list.set(j + 1, n);
				j -= 1;
			}
			
			list.set(j+1, key);
		}
		return list;
	}
	
	public ArrayList<Integer> listRandomized(){
		ArrayList<Integer> list = new ArrayList<>();
		Random rand = new Random();
		for(int i = 0; i < 9; i++) {
			int value = rand.nextInt(100) + 1;
			list.add(value);
		}
		
		return list;
	}

	/**
	 * @param inputNum 
	 * @return result 
	 */
	public double findMean (ArrayList<Integer> list) {
		
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
	//method to find mean
	
	//software design, a b c programming? 
	
	//method to find median
	public double findMedian(ArrayList<Integer> list){

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
	
	//method to find mode STILL NEEDS WORK, GETTING WRONG ANSWERS
	// list is [6, 10, 11, 36, 54, 77, 83, 87, 87] but its saying all nums appear the same times.
	//it should be 87
	public Integer findMode (ArrayList<Integer> list) {
		
		if(!isSorted(list)) {
			list = insertionSort(list);
		}
		
		int limit = 0;
		if(list.size() % 2 == 0) {
			limit = (list.size() / 2) + 1;
		}
		else {
			limit = list.size() / 2;
		}
		//two branches if length is even or odd
		
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
					i = j;
					break;
				}
				
			}
			if(count > highest) {
				highest = count;
				result = key;
				if(highest >= limit) {
					break;
				}
			}
			
		}
		
		if (highest == 1) {
			return null;
		}
		
		return result;
	}
	
	
	
	//method StandardDeviation goes here
	
	
	
	public long Permutations(int n, int r) 
	{
		
		if(r == 0) {
			return 1;
		}
		
		if(n - 1 == n - r) {
			return n;
		}
		
		if(n == 0 && r == 0) {
			return 1;
		}
		
		long result = 0;
		int t = n - r;
		
		for(int i = n; i > 0; i--)
		{
			if(i == t) {
				break;
			}
			else {
				if(i == n) {
					result = i * (i - 1);
					i--;
					if(i == t) {
						break;
					}
				}
				else {
					result *= i;
				}	
			}
			
		}
		return result;
		
	}
	
	public long Combinations(int n, int r)
	{
		if(r == 0) {
			return 1;
		}
		if(n - 1 == n - r) {
			return n;
		}
		
		if(n == 0 && r == 0) {
			return 1;
		}
		
		long result = 0;
		long denom = 0;
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
					result = i * (i - 1);
					i--;
					if(i == t) {
						break;
					}
				}
				else {
					result *= i;
				}	
			}
			
		}
		if(r == 0) {
			for(int i = t; i > 0; i--) {
				if(i == t) {
					denom = i * (i - 1);
					i--;
				}
				else {
					denom *= i;
				}	
			}
			
			result = result / denom;
		}
		else if(t == 0) {
			for(int i = r; i > 0; i--) {
				if(i == r) {
					denom = i * (i - 1);
					i--;
				}
				else {
					denom *= i;
				}	
			}
			
			result = result / denom;
		}
		
		return result;
	}
	
	public BigInteger Factorial(int num) {
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
//----------------------------------------------------Testing Methods-------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------
	public void testMean() {
	    System.out.println("Testing the Mean method");
	    ArrayList<Integer> list = listRandomized();
	    double result = findMean(list);
	    System.out.println(list);
	    System.out.println(result);

    }
	
	public void testSort() {
		
		ArrayList<Integer> list = listRandomized();
		System.out.println(list);
		list = insertionSort(list);
		System.out.println(list);
		
		
	}
	
	public void testMedian() {
	    System.out.println("Testing the Median method");
	    ArrayList<Integer> list = listRandomized();
	    double result = findMedian(list);
	    System.out.println(list);
	    System.out.println(result);

    }
	
	public void testMode() {
	    System.out.println("\nTesting the Mode method");
	    ArrayList<Integer> list = listRandomized();
	    Integer result = findMode(list);
	    System.out.println(list);
	    if(result == null) {
	    	System.out.println("All elements appeared the same number of times");
	    }
	    else {
	    	System.out.println(result);
	    }
/* delete this
	    try 
	    {


	    }catch(NullPointerException error) {
	    	System.out.println("All elements appeared the same number of times");
	    }
*/

	}
}
