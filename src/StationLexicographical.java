import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StationLexicographical extends MesoSortedAbstract
{

	//HashMap Local Variable 
	private HashMap<String, Integer> map;
	
	//This will print out the sorted output
	//This will also assert the map variable
	public StationLexicographical(HashMap<String, Integer> map)
	{
		this.map = map;
		Map<String, Integer> treeMap = sortedMap(map);
		//This will interate through all the keys and then print out the value
		for (String stid : treeMap.keySet()) 
		{
		    System.out.println(stid + " " + treeMap.get(stid));		    
		}
	}
	
	//This method will sort through the unsorted hashmap
	@Override
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) 
	{
		// TODO Auto-generated method stub
		// Create a list from elements of HashMap 
		//Treemaps sort themselves
		//This is highly useful because it is a type of map
       TreeMap<String, Integer> sorted = new TreeMap<String, Integer>();
       
       //this copies the unsorted Hashmap into the TreeMap
       sorted.putAll(unsorted);
       
       
       return sorted;
       
	}

	
	
}