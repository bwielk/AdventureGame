package adventure;

import java.util.*; 
import java.util.Scanner;

public class Main {
	
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		locations.put(1, new Location(1, "Sunny and dry desert"));
		locations.put(2, new Location(3, "Abandoned city full of zombies"));
		locations.put(3, new Location(3, "Magical fields of clovers"));
		locations.put(4, new Location(4, "Condemned area in the Hell"));
		locations.put(5, new Location(5, "Blessings in the Heaven"));
		
		//DESERT
		locations.get(1).addExit("W", 2);
		locations.get(1).addExit("N", 3);
		locations.get(1).addExit("E", 4);
		locations.get(1).addExit("S", 5);
		//GRAVEYARD
		locations.get(2).addExit("N", 3);
		locations.get(2).addExit("E", 1);
		locations.get(2).addExit("S", 5);
		//LUCKY_FOREST
		locations.get(3).addExit("W", 2);
		locations.get(3).addExit("E", 4);
		locations.get(3).addExit("S", 1);
		//HELL
		locations.get(4).addExit("S", 5);
		//HEAVEN
		locations.get(5).addExit("W", 2);
		locations.get(5).addExit("N", 1);
		
		int loc = 1;
		while(true){
			System.out.println(locations.get(loc).getDescription());
			if(loc == 0){
				break;
			}
			
			Map<String, Integer> exits = locations.get(loc).getExits();
			System.out.println("Available exits for this location : ");
			for(String exit : exits.keySet()){
				System.out.println(exit + ",");
			}
			System.out.println();
			
			String direction = scanner.nextLine().toUpperCase();
			HashMap<String, String> directions = new HashMap<String, String>();
			directions.put("NORTH", "N");
			directions.put("EAST", "E");
			directions.put("SOUTH", "S");
			directions.put("WEST", "W");
			
			String[] directionPhrase = direction.split(" ");
			for(String word : directionPhrase){
					if(directions.containsKey(word)){
						direction = directions.get(word);
					}
			}
			if(exits.containsKey(direction)){
				loc = exits.get(direction);
			}else{
				System.out.println("You cannot go in that direction");
			}
			
			if(!locations.containsKey(loc)){
				System.out.println("You cannot go in the direction");
				break;
			}
		}
	}
}