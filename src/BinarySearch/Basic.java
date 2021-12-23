package BinarySearch;

public class Basic {


    public static void main(String[] args) {



        Basic ob = new Basic();
        int arr[] = { 2, 3, 7, 10, 14, 16, 18};
        int n = arr.length;
        int x = 10;
        //int result = ob.binarySearchexperiment(arr, 2);
        int result = ob.binarySearch(arr, 1,2);
        //int result = ob.binarySearch(arr, 0, 9);
        //result = ob.sorted_search(arr, 10);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);


    }

    int binarySearch(int[] nums, int startIndex, int target) {
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    int binarySearchexperiment(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if(arr[m] == x)
                return m - 1;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return r;
    }


    public int findMin(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < k){
                left = mid;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }



    int binarySearchRec(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearchRec(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearchRec(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
