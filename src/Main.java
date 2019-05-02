import java.io.IOException;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		//This will be the input for the main class
		HammingDistance ham = new HammingDistance("ACME");
		ham.getHammingDistance();
		ham.printSomething();
	}
}