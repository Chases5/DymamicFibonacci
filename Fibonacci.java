import java.util.Scanner;
import java.util.TreeMap;

public class Fibonacci {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the position of the Fibonacci number (zero base):");
		TreeMap<Integer, Double> map = new TreeMap<>();
		map.put(0,0.0);
		map.put(1,1.0);
		
		while(true){
			int inputInt = input.nextInt();
			if(inputInt < 0){
				break;
			}
			double outputInt = 0;
			if(map.containsKey(inputInt)){
				outputInt = (double)map.get((inputInt));
			}
			else{
				outputInt = (double)calculateFib(inputInt, map);
			}
			System.out.println(outputInt);
		}
		input.close();
	}
	
	public static double calculateFib(int place, TreeMap<Integer,Double> map){
		if(map.containsKey(place)){
			return (double)map.get(place);
		}
		else{
			map.put(place, (calculateFib((place - 1), map) + calculateFib((place -2), map)));
			return map.get(place);
		}
	}
}
