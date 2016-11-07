public class MyMergeSort {

	public static void main(String a[]) {

		int[] inputArr = { 45, 23, 11, 89, 101, 77, 98, 4, 5, 11 };
		print(inputArr);
		inputArr = mergeSort(inputArr);
		System.out.println("");
		print(inputArr);
	}

	public static int[] mergeSort(int[] inputArr) {
		if (inputArr.length <= 1) {
			return inputArr;
		}
		int middle = inputArr.length / 2;
		int[] left = new int[middle];
		int[] right;
		if (inputArr.length % 2 == 0) {
			right = new int[middle];
		} else {
			right = new int[middle + 1];
		}

		for (int i = 0; i < middle; i++) {
			left[i] = inputArr[i];
		}
		int index = 0;
		for (int j = middle; j < inputArr.length; j++) {
			if (index < right.length) {
				right[index] = inputArr[j];
				index++;
			}
		}

		left = mergeSort(left);
		right = mergeSort(right);

		int[] result = new int[inputArr.length];
		result = merge(left, right);

		return result;
	}

	public static int[] merge(int[] left, int[] right) {
    	int[] result = new int[left.length + right.length];
    	int i = 0;
    	int j = 0;
    	int k = 0;
    	while(i < left.length || j < right.length) {
    		if(i < left.length && j < right.length) {
    			if(left[i] <= right[j]) {
	    			result[k] = left[i];
	    			i++;
	    			k++;
    			} else {
	    			result[k] = right[j];
	    			j++;
	    			k++;
    			}
    		}
    	
    		else if (i < left.length) {
	    		result[k] = left[i];
	    		i++;
	    		k++;
    		}
    		else if (j < right.length) {
	    		result[k] = right[j];
	    		j++;
	    		k++;
    		}
    	}
    	return result;
    }

	private static void print(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(i == array.length - 1) {
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + ", ");
			}
		}
	}
}
