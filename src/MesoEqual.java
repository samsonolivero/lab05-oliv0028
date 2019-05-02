import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class MesoEqual
{
	//instance variables
	private String StID;
	//The Start of File that we want to access
	private int START_FILE = 4;
	//The End of the File we want to access
	private int FILE_SIZE = 124;
	
	//Initializes StID method
	public MesoEqual(String StID)
	{
		this.StID = StID;
	}
	
	//This returns a hashmap with a key and the value is the average
	public HashMap<String, Integer> calAsciiEqual() throws IOException
	{
		//Declaring local variables in this method
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//We can just declare a MesoAscii Object so we can call the calAverage() method
		MesoAscii meso = new MesoAscii(new MesoStation(StID));
		Integer avg = meso.calAverage();
		
		//This adds the mesostation that we want to test
		map.put(this.StID, avg);
		
		//We need a buffered reader to read into the Mesonet.txt
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		//Reads in the line
		 String line = br.readLine();
         //br.readLine();
		 //We need to do this to skip the first few files
         
         //We want to start at the fourth line and end on the 124th line because those are all the StIDs
		for(int i = START_FILE; i <= FILE_SIZE; i++) 
		{
			//We need to read not the whole line but the 4 characters which are the StIDs
            line = br.readLine().substring(2, 6);
            
            //This value is to be able to compare the averages later on
            MesoAscii compare = new MesoAscii(new MesoStation(line));
            //This tempAvg will be used to compare against the average we want
            Integer tempAvg = compare.calAverage();
            //Compares the avg we want to the average we are currently looking at
            if(tempAvg == avg) 
            {
            	//if they are equal, put it in the hashmap
                map.put(line, avg);
            }
        }
		
		br.close();
		
		
		return map;
	}
}