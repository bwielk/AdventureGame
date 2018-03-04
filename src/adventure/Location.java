package adventure;
import java.util.*;

public class Location {
	
	private final int locationID;
	private final String description;
	private final Map<String, Integer> exits;
	
	public Location(int locationID, String description){
		this.locationID = locationID;
		this.description = description;
		exits = new HashMap<String, Integer>();
	}

	public int getLocationID() {
		return locationID;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Integer> getExits() {
		return new HashMap<String, Integer>(exits);
	}
	
	public boolean addExit(String direction, int location){
		if(exits.containsKey(location)){
			return false;
		}else{
			exits.put(direction, location);
			return true;
		}
	}
}