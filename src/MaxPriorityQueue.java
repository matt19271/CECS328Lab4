//Matthew Berrios & Madeline Powers-Johnson
import java.util.Scanner;

public class MaxPriorityQueue {
	static int heapSize = 0;
	
	static void maxHeapify(int nums[], int size, int root) 
    { 
        int maxValue = root;
        int left = 2 * root + 1; 
        int right = 2 * root + 2; 
  
        //if left child is bigger than the root change max value
        if (left < size && (nums[left] > nums[maxValue])) {
        	maxValue = left; 
        }
     
        //if right child is bigger than the root change max value
        if (right < size && (nums[right] > nums[maxValue])) {
            maxValue = right; 
        }
  
        //swap 
        if (maxValue != root) {
            int temp = nums[root];
            nums[root] = nums[maxValue]; 
            nums[maxValue] = temp; 
            maxHeapify(nums, size, maxValue); 
        } 
    } 
  
    static void generateHeap(int nums[], int size) 
    { 
        //find the furthest index down to start iteration
        int start = (size / 2) - 1; 
        
        //traverse and heapify
        for (int i = start; i >= 0; i--) { 
            maxHeapify(nums, size, i); 
        } 
    } 
    
    //hardcoded height calculations to meet max of 10 numbers as noted in assignment
    static int calcHeight(int nums[]) {
    	
    	int size = nums.length;
    	if(size <= 1) {
    		return 0;
    	}
    	
    	else if(size <= 3) {
    		return 1;
    	}
    	
    	else if(size <= 7) {
    		return 2;
    	}
    	
    	else if(size <= 15) {
    		return 3;
    	}
    	else {
    		return 0;
    	}

    }
    
    static int getMax(int a[]) {
    	return a[0];
    }
    
    
  public static int extractMax(int a[ ]) {
	  if(heapSize < 1) {
		  return -1;
	  }
	  int max = a[0];
      a[0] = a[heapSize - 1];
      a[heapSize - 1] = 0;
      //length = length - 1;
      heapSize--;
      maxHeapify(a, heapSize, 0);
      return max;
    }
    
    
  public static int increaseKey (int a[], int i, int val) {
      if(val < a[i]) {
        return -1;
      }

      a[i] = val;

      while ((i > 1) && (a[(i - 1)/ 2] < a[i])) {
    	  int temp = a[(i - 1) / 2];
          a[(i - 1) / 2] = a[i];
          a[i] = temp;
          i = (i-1)/2;
      }
      return 0;
    }

  public static void displayMenu() {
    System.out.println("\nChoose from the following options:");
    System.out.println("1. Insert\n2. Maximum\n3. Extract-Max\n4. Increase-Key\n5. Exit");
  }

  public static void insert(int a[], int val) {
	  heapSize = heapSize + 1;
	  a[heapSize - 1] = -1;
	  increaseKey(a, heapSize - 1, val);
  }
  
  public static void printHeap(int nums[]) {
	  System.out.println("Outputted Max Heap:");
		for (int i = 0; i < heapSize; ++i) {
			System.out.print(nums[i] + " "); 
		}
  }

/************************************************************
 * DRIVER METHOD
 * @param args
 */
  
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input = "0";
		int size = 15; 
	    int nums[] = new int[size];
		System.out.println("Enter an array of integers followed by spaces");
		String arrayInput = in.nextLine();
		String arr[] = arrayInput.split(" ");
		
		for(int i = 0; i < arr.length; i++) {
	    	nums[i] = Integer.parseInt(arr[i]);
	    }
		heapSize = arr.length;
		
	    MaxPriorityQueue.generateHeap(nums, heapSize); 
	
	    System.out.println("Max Heap Array:");
	  
	    for (int i = 0; i < heapSize; ++i) {
	    	System.out.print(nums[i] + " "); 
		}
	  
		MaxPriorityQueue.displayMenu();
				
	
		while (!input.equals("5")) {
			input = in.nextLine();
			
			if (input.equals("1")) {
				System.out.println("Input the integer you want inserted:");
				int newNum = in.nextInt();
				//inserts the number
				MaxPriorityQueue.insert(nums, newNum);
				//prints the array
				printHeap(nums);
				MaxPriorityQueue.displayMenu();
			}
		
			else if (input.equals("2")) {
		
				System.out.println("Maximum value is: " + MaxPriorityQueue.getMax(nums));
		
				MaxPriorityQueue.displayMenu();
		    }
		
			else if (input.equals("3")) {
		
				System.out.println("Maximum value is: " + MaxPriorityQueue.getMax(nums));
				
				if(MaxPriorityQueue.extractMax(nums) == -1)
					System.out.println("No integer to extract.");
				printHeap(nums);
				
				MaxPriorityQueue.displayMenu();
			}
		
			else if (input.equals("4")) {
		
				System.out.println("Input the index of the node you want to increase:");
				int node = in.nextInt();
				System.out.println("Input the new value:");
				int newValue = in.nextInt();
				
				if (MaxPriorityQueue.increaseKey(nums, node - 1, newValue) == -1) {
					System.out.println("ERROR: new key is smaller than current key");
				    MaxPriorityQueue.displayMenu();
				}
		
				else {
				  printHeap(nums);
				  MaxPriorityQueue.displayMenu();
				}
			}			
		}  
		
		System.out.println("Exiting...");    
	}
}

