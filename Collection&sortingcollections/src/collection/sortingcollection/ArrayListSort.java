package collection.sortingcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ArrayListSort {

		public static void main(String[] args) {
			
			ArrayList<Integer> data = new ArrayList<Integer>();
			System.out.println("Enter number of elements");
			Scanner A = new Scanner(System.in);
			int n = A.nextInt();
			System.out.println("Enter the Elements");
			for(int i=0;i<n;i++) {
				int val  = A.nextInt();
				data.add(val);
			}
			
			System.out.println("Elements of the arraylist");
			for(int d:data) {
				System.out.println(d);
			}
			
			Collections.sort(data);
			System.out.println("Elements of the arraylist after sorting");
			for(int d:data) {
				System.out.println(d);
			}
			
			

		}

	}

