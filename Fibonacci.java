import java.util.Scanner;
import java.math.BigInteger;
import java.util.TreeMap;

public class Fibonacci {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the position of the Fibonacci number (zero base):");
		TreeMap<Integer, BigInteger> map = new TreeMap<>();
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		map.put(0,a);
		map.put(1,b);
		
		while(true){
			int inputInt = input.nextInt();
			if(inputInt < 0){
				break;
			}
			BigInteger outputInt = new BigInteger("0");
			if(map.containsKey(inputInt)){
				outputInt = map.get(inputInt);
			}
			else{
				outputInt = calculateFib(inputInt, map);
			}
			System.out.println(outputInt);
			System.out.println("Number of digits: " + outputInt.toString().length());
		}
		input.close();
	}
	
	public static BigInteger calculateFib(int place, TreeMap<Integer,BigInteger> map){
		if(map.containsKey(place)){
			return map.get(place);
		}
		else{
			map.put(place, (calculateFib((place - 1), map).add( calculateFib((place -2), map))));
			return map.get(place);
		}
	}
}
