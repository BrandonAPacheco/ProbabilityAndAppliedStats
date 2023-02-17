import java.util.ArrayList;
import java.math.BigInteger;
/**
 * @author Brandon_Pacheco
 * @version Jan 26, 2023
 *
 */
public class StatsLibrary {

	/**
	 * @param inputNum 
	 * @return result 
	 */
	public double findMean (ArrayList<Integer> inputNum) {
		
		double sum = 0;
		//foreach loop formally known as enhanced for loop
		//foreach uses an iterator
		for(int singleElements : inputNum) {
			sum += singleElements;
		}
		
		double result = sum / inputNum.size();
		
		return result;
	}
	//method to find mean
	
	//software design, a b c programming? 
	
	//method to find median
	public double findMedian(ArrayList<Integer> inputNum){
		//write a function if its in order?
		//pass it to a sorting method
		//two branches if length is even or odd
		//return median
		double result = 0;
                
		return result;
	}
	
	//method to find mode
	public double findMode (ArrayList<Integer> inputNum) {
		
		//write a function if its in order
		//pass it to a sorting method
		//two branches if length is even or odd
		//return mode
		
		double result;
		
		return result = 2 / 4;
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
	
	public void TestMean(){
	    System.out.println("Testing the Mean method");
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    //add a random list generator
	    list.add(1);
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    list.add(5);
	    
	    double result = findMean(list);
	    System.out.println(result);
        }
}
