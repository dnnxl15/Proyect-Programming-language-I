package library;

import java.util.ArrayList;

public interface IFunction
{
	public static ArrayList<Integer> getValue(int pMax)
	{
		ArrayList<Integer> listValue = new ArrayList<Integer>();
		for(int counter = 1; counter < pMax; counter++)
		{
			listValue.add(counter);
		}
		return listValue;
	}

	
}