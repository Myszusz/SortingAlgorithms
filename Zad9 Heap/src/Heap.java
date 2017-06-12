import java.util.Arrays;
import java.util.Scanner;


public class Heap {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Please input an array (e.g. 1 2 3 4 5):");
		String outputStr = in.nextLine();
		String[] outputArS = outputStr.split(" ");
		int arrayLenght = outputArS.length;
		int[] arrayToSort = new int[arrayLenght];
		
		for(int a = 0; a <= outputArS.length - 1; a++){
			arrayToSort[a] = Integer.parseUnsignedInt(outputArS[a]);
		}
		
		for(int i = arrayLenght/2 - 1; i >= 0; i--){
			Heap.validateMaxHeap(arrayToSort, arrayLenght, i);
		}
		
		for(int i = arrayLenght - 1; i > 0; i--){
			int temp = arrayToSort[0];
			arrayToSort[0] = arrayToSort[i];
			arrayToSort[i] = temp;
			arrayLenght--;
			Heap.validateMaxHeap(arrayToSort, arrayLenght, 0);
		}
		System.out.println(Arrays.toString(arrayToSort));
	}
	
	private static void validateMaxHeap(int[]array, int heapSize, int parentIndex){
		int maxParentIndex = parentIndex;
		int leftChild = parentIndex*2 + 1;
		int rightChild = parentIndex*2 + 2;
		
		if(leftChild < heapSize && array[leftChild] > array[maxParentIndex]){
			maxParentIndex = leftChild;
		}
		if(rightChild < heapSize && array[rightChild] > array[maxParentIndex]){
			maxParentIndex = rightChild;
		}
		if(maxParentIndex != parentIndex){
			int temp = array[maxParentIndex];
			array[maxParentIndex] = array[parentIndex];
			array[parentIndex] = temp; 
			validateMaxHeap(array, heapSize, maxParentIndex);
		}
	}
	
}