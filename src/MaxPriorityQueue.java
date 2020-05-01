//Matthew Berrios & Madeline Powers-Johnson

public class MaxPriorityQueue {
	
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
    
    public static void main(String args[]) 
    { 
        int size = args.length; 
        int nums[] = new int[size];
        
        for(int i = 0; i < size; i++) {
        	nums[i] = Integer.parseInt(args[i]);
        }
        
        generateHeap(nums, size); 

    	System.out.println("Max Heap Array:");
    	
        for (int i = 0; i < size; ++i) {
            System.out.print(nums[i] + " "); 
        }
        
        System.out.println("\n");
        System.out.println("Height: " + calcHeight(nums));
    } 
} 