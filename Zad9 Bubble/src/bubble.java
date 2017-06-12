import java.util.Arrays;
import java.util.Scanner;


public class bubble {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Please input an array (e.g. 1 2 3 4 5):");
		String outputStr = in.nextLine();
		String[] outputArS = outputStr.split(" ");
		int arrayLenght = outputArS.length;
		int[] output = new int[arrayLenght];
		for(int a = 0; a <= outputArS.length - 1; a++){
			output[a] = Integer.parseUnsignedInt(outputArS[a]);
		}
		boolean isSorted = false;
		while(!isSorted){
			isSorted = true;
			for(int i = 0; i <= output.length - 2; i++){
				int output1 = output[i];
				int output2 = output[i + 1];
				int temp = 0;
				if(output1 > output2){
					temp = output[i + 1];
					output[i + 1] = output[i];
					output[i] = temp;
					isSorted = false;
				}
			}
		}
		System.out.println(Arrays.toString(output));
	}
}