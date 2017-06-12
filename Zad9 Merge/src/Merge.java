import java.util.Arrays;
import java.util.Scanner;

public class Merge {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please input an array (e.g. 1 2 3 4 5):");
		String outputStr = in.nextLine();
		String[] outputArS = outputStr.split(" ");
		int arrayLenght = outputArS.length;
		int[] output = new int[arrayLenght];
		for(int a = 0; a <= outputArS.length - 1; a++)
		{
			output[a] = Integer.parseUnsignedInt(outputArS[a]);
		}
		
		int[] extraArray = new int[output.length];
		
		mergeSort(output, 0, output.length - 1, extraArray);
		System.out.println(Arrays.toString(output));
	}
	
	private static void mergeSort(int[]array, int leftIndex, int rightIndex, int[] extraArray)
	{
		if(leftIndex < rightIndex)
		{
			int middle = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, middle, extraArray);
			mergeSort(array, middle + 1, rightIndex, extraArray);
			merge(array, leftIndex, middle, rightIndex, extraArray);
		}
	}
	private static void merge (int[]array, int leftIndex, int middleIndex, int rightIndex, int[] extraArray)
	{
				
		for(int i = leftIndex; i <= rightIndex; i++)
		{
			extraArray[i] = array[i];
		}
		int leftSide = leftIndex;
		int rightSide = middleIndex + 1;
		int current = leftIndex;
		
		while(leftSide <= middleIndex && rightSide <= rightIndex)
		{
			if(extraArray[leftSide] <= extraArray[rightSide])
			{
				array[current] = extraArray[leftSide];
				leftSide++;
			}
			else
			{
				array[current] = extraArray[rightSide];
				rightSide++;
			}
			current++;
		}
		while(leftSide <= middleIndex)
		{
		array[current]	= extraArray[leftSide];
		current++; leftSide++;
		}
	}
}