package adventure;

import java.util.*;
import java.util.Scanner;

public class Main {
	
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		locations.put(0, new Location(0, "Sunny and dry desert"));
		locations.put(1, new Location(1, "Abandoned city full of zombies"));
		locations.put(2, new Location(2, "Magical fields of clovers"));
		locations.put(3, new Location(3, "Condemned area in the Hell"));
		locations.put(4, new Location(4, "Blessings in the Heaven"));
		
		int loc = 1;
		while(true){
			System.out.println(locations.get(loc).getDescription());
			if(loc == 0){
				break;
			}
			
			loc = scanner.nextInt();
			if(!locations.containsKey(loc)){
				System.out.println("You cannot go in the direction");
			}
		}
	}
	

}
