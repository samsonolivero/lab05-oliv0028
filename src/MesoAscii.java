

public class MesoAscii extends MesoAsciiAbstract
{
	private int a;
	private int b;
	private int c;
	private int d;
	
	public MesoAscii(MesoStation meso)
	{
		//taken from project 2
		//basically just converting all four chars in the string and converting to ints
		double[] input = new double[4];
        input[0] = meso.getStID().charAt(0);
        input[1] = meso.getStID().charAt(1);
        input[2] = meso.getStID().charAt(2);
        input[3] = meso.getStID().charAt(3);
        this.a = (int)input[0];
        this.b = (int)input[1];
        this.c = (int)input[2];
        this.d = (int)input[3];
	}
	
	//Utilized the Math class to find the average
	//If the decimal is > 0.5 round up
	//If the decimal is < 0.5 round down
	@Override
	public int calAverage() 
	{
		// TODO Auto-generated method stub
		return (int)(Math.round((a + b + c + d) / 4.0));
	}
	
	
	
}

