import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

//Finds the HammingDistance between the selected node and compares to the rest
public class HammingDistance 
{
	private String StID;
	ArrayList<String> distance1 = new ArrayList<String>();
	ArrayList<String> distance2 = new ArrayList<String>();
	ArrayList<String> distance3 = new ArrayList<String>();
	ArrayList<String> distance4 = new ArrayList<String>();
	
	int countDistance1 = 0;
	int countDistance2 = 0;
	int countDistance3 = 0;
	int countDistance4 = 0;
	
	public HammingDistance(String StID)
	{
		this.StID = StID;
	}
	
	//We may need to pass the selected StID
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
					distance1.add(line);
					countDistance1++;
					break;
				case 2:
					distance2.add(line);
					countDistance2++;
					break;
				case 3:
					distance3.add(line);
					countDistance3++;
					break;
				case 4:
					distance4.add(line);
					countDistance4++;
					break;
			}
			
			
			line = br.readLine();
		
		
		}      
		
		Collections.sort(distance1);
		Collections.sort(distance2);
		Collections.sort(distance3);
		Collections.sort(distance4);

		
		br.close();
	}
	
	
	
	public void printSomething()
	{
		System.out.println(distance4.toString());
		
		System.out.println("Distance 1: " + countDistance1);
		for (int i = 0; i < distance1.size(); i++) 
		{
		    System.out.println(distance1.get(i));		    
		}
		
		System.out.println("Distance 2: " + countDistance2);
		for (int i = 0; i < distance1.size(); i++) 
		{
		    System.out.println(distance2.get(i));		    
		}
		
		System.out.println("Distance 3: " + countDistance3);
		for (int i = 0; i < distance1.size(); i++) 
		{
		    System.out.println(distance3.get(i));		    
		}
		
		System.out.println("Distance 4: " + countDistance4);
		for (int i = 0; i < distance1.size(); i++) 
		{
		    System.out.println(distance4.get(i));		    
		}
		
	}
	
}
