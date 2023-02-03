import java.util.ArrayList;
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
	public int findMedian(ArrayList<Integer> inputNum){
		//write a function if its in order?
		
		int halfSize = inputNum.size() / 2;
		int result = inputNum.get(halfSize);
		
		
		return result;
	}
	
	//method to find mode
	public double findMode (ArrayList<Integer> inputNum) {
		
		
		
		double result;
		
		return result = 2 / 4;
	}
	
	
	
	//method StandardDeviation
}
