import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//Finds the HammingDistance between the selected node and compares to the rest
public class HammingDistance 
{
	private String StID;
	HashMap<String, Integer> distance1 = new HashMap<String, Integer>();
	HashMap<String, Integer> distance2 = new HashMap<String, Integer>();
	HashMap<String, Integer> distance3 = new HashMap<String, Integer>();
	HashMap<String, Integer> distance4 = new HashMap<String, Integer>();
	
	public HammingDistance(String StID)
	{
		this.StID = StID;
	}
	
	public void getHammingDistance() throws IOException
	{
		
		//We need a buffered reader to read into the Mesonet.txt
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		//Reads in the line
		String line = br.readLine();
		int count = 0;
		
	
		while((line  = br.readLine()) != null)
		//We want to start at the fourth line and end on the 124th line because those are all the StIDs
		{
			//We need to read not the whole line but the 4 characters which are the StIDs
			count = 0;
			for(int i = 0; i < StID.length(); i++)
			{
				if(StID.charAt(i) != line.charAt(i))
				{
					count++;
				}
			}
			//System.out.println("Comparison: " + StID + " versus " + line + " Count = " + count);
			
			//This will put the strings with the appropriate distance in their hashmap
			switch(count)
			{
				case 1:
					distance1.put(line, count);
					break;
				case 2:
					distance2.put(line, count);
					break;
				case 3:
					distance3.put(line, count);
					break;
				case 4:
					distance4.put(line, count);
					break;
			}
			
			
			line = br.readLine();
		
		
		}      
		
		
		br.close();
	}
	
	
	/*
	public void printSomething()
	{
		System.out.println(distance4.toString());
		for (String stid : distance1.keySet()) 
		{
		    System.out.println(stid + " " + distance1.get(stid));		    
		}
		
		for (String stid : distance1.keySet()) 
		{
		    System.out.println(stid + " " + distance2.get(stid));		    
		}
		
		for (String stid : distance1.keySet()) 
		{
		    System.out.println(stid + " " + distance3.get(stid));		    
		}
		
		for (String stid : distance1.keySet()) 
		{
		    System.out.println(stid + " " + distance4.get(stid));		    
		}
		
	}
	*/
}
