import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			
			int num = sc.nextInt();
			int[] box = new int[100];
			
			
			for(int i=0;i<100;i++) {
				box[i] = sc.nextInt();
			}
			
			selectionSort(box);
			
			for(int i= 0; i < num; i++) {
				box[0]++;
				box[99]--;
				selectionSort(box);
				
				if(box[99]-box[0] <= 1) 
					break;
			}
		
			 System.out.println("#" + test_case + " " + (box[99] - box[0]));
		}
		sc.close();
	}

	
	
	
	
	public static void selectionSort(int[] arr) {
		int n = arr.length;
		
		for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; 
                }
            }
            
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            } 
		}
	
	}
	
}