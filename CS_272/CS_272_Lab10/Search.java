package Lab10;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*****************************************************************************************************************
 * Search uses binary search technique. binarySearch searches for a target in an array
 * with time O(log(n)). findKNearest returns an integer list with the K elements nearest
 * to the target. findKNearest has time O(log(n))
 * 
 * @author schw
 * @version Nov 8, 2022
 * 
*****************************************************************************************************************/
public class Search {
	
	/**
	 * binarySearch searches for int with time O(log(n))
	 * 
	 * @param A: int array to be searched
	 * @param e: target
	 * @return index of target
	 * @return -1: not found
	 */
	public static int binarySearch(int[] A, int e) {
		if(A.length == 0) return -1;
		
		int left = 0;
		int right = A.length - 1;
		
		while(left <= right) {
			int middle = left + (right-left)/2;
			if(A[middle] == e) return middle;
			if(A[middle] > e) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return -1;
	}
	
	/**
	 * findKNearest finds K number of elements in sorted
	 * ArrayList nearest to a target. Time complexity O(log(n))
	 * 
	 * @param A: Arraylist to be searched
	 * @param k: size of return sublist
	 * @param target: value to be searched
	 * @return List: sublist of k number of elements in ArrayList
	 * @return null: Arraylist is empty
	 * @throws IllegalArgumentException () 
	 */
	public static List<Integer> findKNearest(ArrayList<Integer> A, int k, int target) {
		// check parameters O(1)
		if(A.isEmpty()) return null;
		if(k > A.size() || k < 1) throw new IllegalArgumentException("Invalid k: 0 < k < A.size");
		
		// binary search target 0(log(n))
		int left = 0;
		int right = A.size() - 1;
		int middle = 0;
		while(left <= right) {
			middle = left + (right-left)/2;
			if(A.get(middle) == target) break;
			if(A.get(middle) > target) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		
		// return sublist of K values near middle: sublist time is O(1).
		if(k == A.size()) return (List<Integer>) A;
		if(A.get(middle) < A.get(k))  return A.subList(0, k);
		if(A.get(middle) > A.get(A.size()-k)) return A.subList(A.size()-k, A.size());
		
		int temp = (k-1)/2;
		if(temp%2==0) return A.subList(middle-temp, middle+temp+1);
		if(temp%2==1)return A.subList(middle-temp, middle+temp);
		System.out.print("Problem");
		return null;
	}
	
	public static void main(String[] args) {
		// Build array with 100 random numbers
		// Test binary search
		 int[] a = new int[100];
		 for(int i=0;i<a.length;i++) {
			 a[i] = (int)(Math.random() * 100);
		 }
		 Arrays.sort(a);
		 for(int i=1;i<=a.length;i++) {
			 System.out.print(a[i-1] + " ");
			 if(i%5==0)System.out.println();
		 }
		 System.out.println("Binary Search(50): " + binarySearch(a, 50));
		 
		 // Build ArrayList, test findKNearest
		 ArrayList<Integer> L = new ArrayList<Integer>();
		 L.add(30);L.add(20);L.add(10);L.add(25);L.add(28);L.add(24);
		 L.add(11);L.add(5);L.add(11);L.add(12);L.add(50);L.add(40);
		 L.add(35);
		 
		 Collections.sort(L);
		 System.out.println(L);
		 System.out.println(findKNearest(L, 5, 0));
		 System.out.println(findKNearest(L, 1, 30));
		 System.out.println(findKNearest(L, 13, 0));
		 System.out.println(findKNearest(L, 5, 30));
		 //System.out.println(findKNearest(L, 10, 0));
		 
	}
	
	
	
}
