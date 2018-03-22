package Unit13;

import static java.lang.System.*;
import java.util.Arrays; //use Arrays.toString() to help print out the array

public class QuickSort {
	private static int passCount;

	public static void quickSort(Comparable[] list) {
		passCount =0;
		System.out.println("pass 0 "+Arrays.toString(list));
		quickSort(list, 0,list.length-1);
	}

	private static void quickSort(Comparable[] list, int low, int high) {
		
		if(low<high){
			int split = partition(list, low,high);
			quickSort(list,low,split);
			quickSort(list,split+1,high);
		}
	}

	private static int partition(Comparable[] list, int low, int high) {
		Comparable pivot = list[low];
		int bottom = low-1;
		int top = high+1;
		while(true){
			do{
				bottom+=1;
			}while(list[bottom].compareTo(pivot)<0);
			do{
				top-=1;

			}while(list[top].compareTo(pivot)>0);
			
			if(bottom>=top){
				return top;
			}
			Comparable sub = list[bottom];
			list[bottom]=list[top];
			list[top]=sub;
			passCount++;
			System.out.println("pass " + passCount+" "+Arrays.toString(list));
		}

	}
	
}