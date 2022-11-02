import java.util.ArrayList;

public class SharedData 
{

	private ArrayList<Integer> array;
	private boolean [] winArray;
	private boolean flag;
	private final int b;
	
	/**
	 * Constructor of shared data.
	 * @param array
	 * @param b
	 */
	public SharedData(ArrayList<Integer> array, int b) {
		
		this.array = array;
		this.b = b;
	}

	/**
	 * @return an array which contains the corresponding numbers.
	 */
	public boolean[] getWinArray() 
	{
		return winArray;
	}

	/**
	 * @param winArray.
	 */
	public void setWinArray(boolean [] winArray) 
	{
		this.winArray = winArray;
	}

	/**
	 * @return the ArrayList.
	 */
	public ArrayList<Integer> getArray() 
	{
		return array;
	}

	/**
	 * @return b.
	 */
	public int getB() 
	{
		return b;
	}

	/**
	 * @return flag.
	 */
	public boolean getFlag() 
	{
		return flag;
	}

	/**
	 * @param flag.
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
