package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinSwapsToSortArray {

	public static void main(String[] args) {

		//int arr[] = {3, 2, 1, 0};
		
		//int arr[] = {0, 4, 3, 2, 1};
		
		//int arr[] = {1, 3, 4, 0, 2};
		
		int arr[] = {1, 3, 4, 0, 2, 5};
		
		System.out.println(minSwaps(arr));
		
	}
	
	private static int minSwaps(int arr[]) {
		
		int n = arr.length;
		
		if(n == 0)
			return 0;
		
		ArrayList<Pair> pos = new ArrayList<Pair>();
		
		for (int i = 0; i < n; i++) {
			Pair pair = new Pair(arr[i], i);
			pos.add(pair);
		}
		
		Collections.sort(pos, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				
				//Increasing order of key
				
				if(o1.key < o2.key)
					return -1;
				
				else if(o1.key == o2.key)
					return 0;
				
				else
					return 1;
			}
		});
		
		for (int i = 0; i < n; i++) {
			System.out.println(pos.get(i).toString());
		}
		
		boolean visited[] = new boolean[n];
		
		Arrays.fill(visited, false);
		
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			
			if(visited[i] || pos.get(i).value == i) {
				System.out.println("i : " + i);
				System.out.println("continue..");
				continue;
			}
			
			int size = 0;
			
			int j = i;
			
			while(!visited[j]) {
				
				visited[j] = true;
				
				size++;
				
				j = pos.get(j).value;
			}
			
			if(size > 0)
				result = result + (size - 1);
			
		}
		
		return result;
		
	}

}

class Pair{
	
	int key;
	
	int value;
	
	public Pair(int k, int v) {
	
		key = k;
		
		value = v;
	}
	
	@Override
	public String toString() {
		return "{" + key +", " + value + "}";
	}
}
